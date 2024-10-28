package com.example.larantaappmobile.welcome.model

import com.google.gson.annotations.SerializedName


data class WelcomeDog (

  @SerializedName("id"       ) var id       : Int?    = null,
  @SerializedName("name_eng" ) var nameEng  : String? = null,
  @SerializedName("name_own" ) var nameOwn  : String? = null,
  @SerializedName("id_gender") var idGender : Int?    = null,
  @SerializedName("children" ) var children : Int?    = null

)