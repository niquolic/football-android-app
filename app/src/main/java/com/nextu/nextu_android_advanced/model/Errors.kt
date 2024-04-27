package com.nextu.nextu_android_advanced.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Errors(
    @SerialName("endpoint")
    val endpoint: String? = null,
)