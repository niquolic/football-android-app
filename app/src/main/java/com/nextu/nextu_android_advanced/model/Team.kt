package com.nextu.nextu_android_advanced.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Team(
    @SerialName("team")
    val teamInfo: TeamInfo,
    @SerialName("venue")
    val venueInfo: VenueInfo
)