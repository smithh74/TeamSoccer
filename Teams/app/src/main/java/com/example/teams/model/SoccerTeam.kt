package com.example.teams.model

import com.google.gson.annotations.SerializedName

data class SoccerTeam  (
    val strTeam: String?,
    val strTeamBadge: String?,
    val strStadium: String?,
    val strDescriptionEN: String?,
    val strTeamJersey: String?
    //@SerializedName("strDescriptionEN") val descriptionTeam: String?,
    //@SerializedName("strDescriptionEN") val shirtTeam: String?


)