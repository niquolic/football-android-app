package com.nextu.nextu_android_advanced.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Parameters(
    @SerialName("league") val league: String? = null,
    @SerialName("season") val season: String? = null,
    @SerialName("id") val id: Int? = null,
)