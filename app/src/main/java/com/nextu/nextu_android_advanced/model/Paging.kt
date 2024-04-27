package com.nextu.nextu_android_advanced.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Paging(
    @SerialName("current") val current: Int,
    @SerialName("total") val total: Int
)