package com.example.larantaappmobile.welcome.model

import com.google.gson.annotations.SerializedName


data class WelcomeNursery (

  @SerializedName("id"      ) var id               : Int?    = null,
  @SerializedName("name_eng") var nameEng          : String? = null,
  @SerializedName("name_own") var nameOwn          : String? = null,
  @SerializedName("dogs"    ) var dogs             : Int?    = null

)