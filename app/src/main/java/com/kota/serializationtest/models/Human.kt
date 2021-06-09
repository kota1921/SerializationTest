package com.kota.serializationtest.models

import kotlinx.serialization.Serializable

/**
 * Created by ereminilya on 19/2/17.
 */
@Serializable
class Human() {
	private val _id: String? = null
	private val tags: List<String>? = null
	private val phone: String? = null
	private val index = 0
	private val favoriteFruit: String? = null
	private val greeting: String? = null
	private val about: String? = null
	private val guid: String? = null
	private val isActive = false
	private val picture: String? = null
	private val balance: String? = null
	private val friends: List<MiniHuman>? = null
	private val address: String? = null
	private val eyeColor: String? = null
	private val email: String? = null
	private val registered: String? = null
	private val age = 0
	private val name: String? = null
	private val company: String? = null
	private val gender: String? = null
	private val longitude = 0.0
	private val latitude = 0.0
	private val radiostations: List<Radiostation>? = null
	private val notes: List<Note>? = null
}