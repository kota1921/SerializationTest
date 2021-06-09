package com.kota.serializationtest.models

import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

/**
 * Created by ereminilya on 22/2/17.
 */
@Serializable
@JsonClass(generateAdapter = true)
class SmallObject {
	private val _id: String? = null
	private val index = 0
	private val tags: List<String>? = null
	private val greeting: String? = null
	private val favoriteFruit: String? = null
}