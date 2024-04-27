package com.nextu.nextu_android_advanced.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("get")
    val get: String,
    @SerialName("parameters")
    val parameters: Parameters,
    @SerialName("errors")
    val errors: List<Errors>,
    @SerialName("results")
    val results: Int,
    @SerialName("paging")
    val paging: Paging,
    @SerialName("response")
    val response: List<Team>
)