package com.nextu.nextu_android_advanced.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamInfo(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("code")
    val code: String,
    @SerialName("country")
    val country: String,
    @SerialName("founded")
    val founded: Int,
    @SerialName("national")
    val national: Boolean,
    @SerialName("logo")
    val logo: String
)