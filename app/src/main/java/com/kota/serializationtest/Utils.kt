package com.kota.serializationtest

import android.content.Context
import androidx.annotation.NonNull
import androidx.annotation.RawRes
import java.io.ByteArrayOutputStream
import java.io.IOException

object Utils {
	fun readJsonAsStringFromDisk(@NonNull context: Context, @RawRes rawRes: Int): String? {
		val inputStream = context.resources.openRawResource(rawRes)
		val byteArrayOutputStream = ByteArrayOutputStream()
		var ctr: Int
		try {
			ctr = inputStream.read()
			while (ctr != -1) {
				byteArrayOutputStream.write(ctr)
				ctr = inputStream.read()
			}
			inputStream.close()
		} catch (e: IOException) {
			e.printStackTrace()
		}
		return byteArrayOutputStream.toString()
	}
	
	fun doNTimes(times: Int, task: () -> Unit): Long {
		val before = System.currentTimeMillis()
		for (i in 0 until times) {
			task.invoke()
		}
		return System.currentTimeMillis() - before
	}
}