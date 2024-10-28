package com.example.larantaappmobile.welcome

import com.example.larantaappmobile.utils.LabazaURL
import com.example.larantaappmobile.welcome.model.WelcomeData
import retrofit2.Response
import retrofit2.http.GET

interface WelcomeApi {
    @GET(LabazaURL.WELCOME_API)
    suspend fun getData(): Response<WelcomeData>
}