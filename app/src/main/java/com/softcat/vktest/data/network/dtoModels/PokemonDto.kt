package com.softcat.vktest.data.network.dtoModels

import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val infoUrl: String,
    @SerializedName("stats") val characteristics: List<CharacteristicDto>,
    @SerializedName("types") val types: List<PokemonTypeDto>,
    @SerializedName("weight") val weight: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("base_experience") val experience: Int,
    @SerializedName("height") val height: Int,
)
