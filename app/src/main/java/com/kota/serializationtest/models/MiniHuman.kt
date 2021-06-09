package com.kota.serializationtest.models

import kotlinx.serialization.Serializable

/**
 * Created by ereminilya on 19/2/17.
 */
@Serializable
class MiniHuman {
	private val id: Long = 0
	private val name: String? = null
	private val gender: String? = null
	private val company: String? = null
	private val email: String? = null
	private val phone: String? = null
	private val address: String? = null
	private val about: String? = null
}