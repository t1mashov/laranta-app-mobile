package com.example.larantaappmobile.utils

object LabazaURL {

    const val BASE = "http://192.168.1.75:8000"
    const val WELCOME_API = "/api/welcome"

    fun image(title: String) = "$BASE/storage/$title"

    fun flag(code: String) = "https://ipdata.co/flags/$code.png"

}
