package com.kota.serializationtest

import android.annotation.SuppressLint
import android.content.Context
import com.alibaba.fastjson.JSON
import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kota.serializationtest.models.SmallObject
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.ArrayList
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import timber.log.Timber

class TestShortJsonReading(context: Context) {
	
	companion object {
		private const val REPEAT_COUNT = 1000
		private val HUMAN_LIST_GSON = object : TypeToken<ArrayList<SmallObject>>() {}.type
	}
	
	private val jsonString = Utils.readJsonAsStringFromDisk(context, R.raw.small)
	private val gcTracker = GcTracker()
	private val gson = Gson()
	private val mapper = ObjectMapper().apply {
		setVisibility(
			visibilityChecker.withFieldVisibility(JsonAutoDetect.Visibility.ANY)
				.withGetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withSetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withCreatorVisibility(JsonAutoDetect.Visibility.NONE)
		             )
	}
	private val moshi = Moshi.Builder()
		.add(KotlinJsonAdapterFactory()).build()
	private val moshiAdapter: JsonAdapter<List<SmallObject>>? =
		moshi.adapter(Types.newParameterizedType(MutableList::class.java, SmallObject::class.java))
	
	init {
		gcTracker.startListening()
	}
	
	fun testFastJson() {
		JSON.parseArray(jsonString, SmallObject::class.java)
		val diff = Utils.doNTimes(REPEAT_COUNT) { JSON.parseArray(jsonString, SmallObject::class.java) }
		Timber.d("diff reading short fastjson $diff")
	}
	
	fun testGson() {
		gson.fromJson<List<SmallObject>>(jsonString, HUMAN_LIST_GSON)
		val diff = Utils.doNTimes(REPEAT_COUNT) { gson.fromJson(jsonString, HUMAN_LIST_GSON) }
		Timber.d("diff reading short gson $diff")
	}
	
	fun testJackson() {
		listOf(mapper.readValue(jsonString, Array<SmallObject>::class.java))
		val diff = Utils.doNTimes(REPEAT_COUNT) { listOf(mapper.readValue(jsonString, Array<SmallObject>::class.java)) }
		Timber.d("diff reading short jackson $diff")
	}
	
	@SuppressLint("CheckResult")
	fun testMoshi() {
		moshiAdapter?.fromJson(jsonString ?: "")
		val diff = Utils.doNTimes(REPEAT_COUNT) { moshiAdapter?.fromJson(jsonString ?: "") }
		Timber.d("diff reading short moshi $diff")
	}
	
	fun testKotlinSerialization() {
//		Json.decodeFromString<List<SmallObject>>(jsonString ?: "")
		val diff = Utils.doNTimes(REPEAT_COUNT) {
			Json.decodeFromString<List<SmallObject>>(jsonString ?: "")
		}
		Timber.d("diff reading short serialization $diff")
	}
}