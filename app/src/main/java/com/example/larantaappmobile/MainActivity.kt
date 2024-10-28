package com.example.larantaappmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.larantaappmobile.template.LabazaAppBar
import com.example.larantaappmobile.utils.LabazaTheme
import com.example.larantaappmobile.ui.theme.LarantaAppMobileTheme
import com.example.larantaappmobile.utils.RetrofitInstance
import com.example.larantaappmobile.welcome.WelcomeApi
import com.example.larantaappmobile.welcome.ui.WelcomeScreen
import com.example.larantaappmobile.welcome.ui.WelcomeViewModel

class MainActivity : ComponentActivity() {

    private lateinit var welcomeApi: WelcomeApi
    private lateinit var welcomeViewModel: WelcomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        welcomeApi = RetrofitInstance.getInstance().create(WelcomeApi::class.java)
        welcomeViewModel = WelcomeViewModel(welcomeApi)
//        welcomeViewModel = viewModels<WelcomeViewModel>()

        setContent {
            LarantaAppMobileTheme(
                dynamicColor = false
            ) {
                LabazaTheme.updateTheme()

                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = LabazaTheme.bg
                ) {

                    ModalNavigationDrawer(
                        drawerContent = {
                            ModalDrawerSheet {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(LabazaTheme.bg)
                                ) {
                                    Text(text = "asdfgdfgwrgregedf")
                                }
                            }
                        }
                    ) {

                        WelcomeScreen(vm = welcomeViewModel)

//                        Scaffold(
//                            topBar = { LabazaAppBar() }
//                        ) {
//                            Box(
//                                Modifier
//                                    .fillMaxSize()
//                                    .padding(it)
//                            ) {
//                                WelcomeScreen(vm = welcomeViewModel)
//                            }
//                        }

                    }

                }


            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LarantaAppMobileTheme {
        Greeting("Android")
    }
}