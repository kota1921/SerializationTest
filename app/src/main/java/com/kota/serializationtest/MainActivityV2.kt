package com.kota.serializationtest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivityV2 : AppCompatActivity() {
	
	private val testSmallReading by lazy { TestShortJsonReading(this) }
	private val testBigReading by lazy { TestBigJsonReading(this) }
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		findViewById<View>(R.id.buttonParseFastJson).setOnClickListener { testSmallReading.testFastJson() }
		findViewById<View>(R.id.buttonParseGson).setOnClickListener { testSmallReading.testGson() }
		findViewById<View>(R.id.buttonParseJackson).setOnClickListener { testSmallReading.testJackson() }
		findViewById<View>(R.id.buttonParseMoshi).setOnClickListener { testSmallReading.testMoshi() }
		findViewById<View>(R.id.buttonParseKotlinSerialization).setOnClickListener {
			testSmallReading.testKotlinSerialization()
		}
		findViewById<View>(R.id.buttonBigParseFastJson).setOnClickListener { testBigReading.testFastJson() }
		findViewById<View>(R.id.buttonBigParseGson).setOnClickListener { testBigReading.testGson() }
		findViewById<View>(R.id.buttonBigParseJackson).setOnClickListener { testBigReading.testJackson() }
		findViewById<View>(R.id.buttonBigParseMoshi).setOnClickListener { testBigReading.testMoshi() }
		findViewById<View>(R.id.buttonBigParseKotlinSerialization).setOnClickListener { testBigReading.testKotlinSerialization() }
	}
	
}