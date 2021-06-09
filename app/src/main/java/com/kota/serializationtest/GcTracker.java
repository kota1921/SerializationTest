package com.kota.serializationtest;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

import androidx.annotation.Nullable;
import timber.log.Timber;

/**
 * Created by ereminilya on 5/3/17.
 */

public class GcTracker {
	@Nullable private Thread mThread;
	private int count = 0;
	
	/**
	 * Starts listening for GC_FOR_ALLOC events
	 */
	public void startListening() {
		if (mThread != null) {
			return;
		}
		
		mThread = new Thread() {
			@Override
			public void run() {
				final ReferenceQueue<Object> rq = new ReferenceQueue<>();
				
				//noinspection unused
				PhantomReference<Object> phantom = new PhantomReference<>(new Object(), rq);
				while (!isInterrupted()) {
					
					if (Thread.interrupted()) {
						return;
					}
					
					if (rq.poll() != null) {
						count++;
						Timber.d("GC TRACKER gc was called count - " + count);
						//noinspection UnusedAssignment
						phantom = new PhantomReference<>(new Object(), rq);
					}
					
					try {
						Thread.sleep(16);
					} catch(InterruptedException ignored) {
					}
				}
			}
		};
		mThread.setPriority(Thread.MIN_PRIORITY);
		mThread.start();
	}
	
	/**
	 * Stops listening for GC_FOR_ALLOC events
	 */
	public void stopListening() {
		if (mThread != null) {
			mThread.interrupt();
			mThread = null;
		}
	}
}