package com.example.larantaappmobile.welcome.model

import com.google.gson.annotations.SerializedName


data class WelcomeData (

    @SerializedName("top_dogs"        ) var statOnDogs      : ArrayList<WelcomeDog>          = arrayListOf(),
    @SerializedName("top_nurseries"   ) var statOnNurseries : ArrayList<WelcomeNursery>      = arrayListOf(),
    @SerializedName("last_added_dogs" ) var newDogs         : ArrayList<WelcomeNewDog> = arrayListOf()

)