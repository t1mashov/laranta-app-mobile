package com.example.larantaappmobile.utils

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.larantaappmobile.R

object LabazaTheme {
    private var isLightTheme = false
    @Composable
    fun updateTheme() {
        isLightTheme = !isSystemInDarkTheme()
    }
    fun setLightTheme() {
        isLightTheme = true
    }
    fun setDarkTheme() {
        isLightTheme = false
    }

    val statusBarLight: Color = Color(0xFF07416D)
    val statusBarDark: Color = Color(0xFF021422)
    val bgLight: Color = Color(0xFFFFFFFF)
    val bgDark: Color = Color(0xFF0E0E0E)

    val bg: Color
        get() = if (isLightTheme) Color(0xFFFFFFFF) else Color(0xFF1F1F20)
    val primary: Color
        get() = if (isLightTheme) Color(0xFF3B82F6) else Color(0xFF07416D)

    val noYorkImage: Int
        get() = if (isLightTheme) R.drawable.york_no_photo else R.drawable.york_no_photo_dark

    val cardBgTop: Color
        get() = if (isLightTheme) Color(0xFFE9E9E9) else Color(0xFF333333)
    val cardDogBg: Color
        get() = if (isLightTheme) Color(0xFFE2E2E2) else Color(0xFF333333)
    val cardBgList: Color
        get() = if (isLightTheme) Color(0xFFD9D9D9) else Color(0xFF2C2C2C)
    val cardDivider: Color
        get() = if (isLightTheme) Color(0xFFCACACA) else Color(0xFF383838)
    val cardTitle: Color
        get() = if (isLightTheme) Color(0xFF717171) else Color(0xFFB8B8B8)
    val imageProgressBar: Color
        get() = if (isLightTheme) Color(0xFFD5D5D5) else Color(0xFF464646)

    val textBlack: Color
        get() = if (isLightTheme) Color(0xFF000000) else Color(0xFFF8F8F8)

    val male: Color
        get() = if (isLightTheme) Color(0xFF2196F3) else Color(0xFF7FBEF0)
    val female: Color
        get() = if (isLightTheme) Color(0xFFEC407A) else Color(0xFFF088AB)
    val nursery: Color
        get() = if (isLightTheme) Color(0xFF545858) else Color(0xFFDEECEA)

    val title: Color
        get() = if (isLightTheme) Color(0xFF2E2E2E) else Color(0xFFD3D3D3)

}