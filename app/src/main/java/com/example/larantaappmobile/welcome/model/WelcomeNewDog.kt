package com.example.larantaappmobile.welcome.model

import com.google.gson.annotations.SerializedName


data class WelcomeNewDog (

  @SerializedName("id"         ) var id          : Int?    = null,
  @SerializedName("name_eng"   ) var nameEng     : String? = null,
  @SerializedName("name_own"   ) var nameOwn     : String? = null,
  @SerializedName("id_gender"  ) var idGender    : Int?    = null,
  @SerializedName("code"       ) var countryCode : String? = null,
  @SerializedName("country"    ) var countryName : String? = null,
  @SerializedName("image_title") var imageTitle  : String? = null

)