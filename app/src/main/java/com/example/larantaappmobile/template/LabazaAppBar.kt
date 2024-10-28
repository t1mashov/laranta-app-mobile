package com.example.larantaappmobile.template

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.larantaappmobile.utils.LabazaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabazaAppBar() {
    TopAppBar(
        title = { Text(text = "LaBaza") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = LabazaTheme.bg
        )
    )
}