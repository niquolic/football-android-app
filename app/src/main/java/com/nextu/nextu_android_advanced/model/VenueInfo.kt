package com.nextu.nextu_android_advanced.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VenueInfo(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("address")
    val address: String,
    @SerialName("city")
    val city: String,
    @SerialName("capacity")
    val capacity: Int,
    @SerialName("surface")
    val surface: String,
    @SerialName("image")
    val image: String
)