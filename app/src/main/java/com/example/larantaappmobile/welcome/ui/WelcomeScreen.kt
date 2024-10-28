package com.example.larantaappmobile.welcome.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.larantaappmobile.utils.LabazaTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun WelcomeScreen(
    vm: WelcomeViewModel
) {
    val vScroll = rememberScrollState()

    LaunchedEffect(Unit) {
        vm.getData()
    }

    val statDogs = remember { vm.statDogs }
    val statNurseries = remember { vm.statNurseries }
    val newDogs = remember { vm.newDogs }

    val isLoading by remember { vm.isDataLoading }
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isLoading)

    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = vm::getData
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(vScroll)
        ) {
            
            Spacer(modifier = Modifier.height(30.dp))
            
            Text(
                text = "Недавно добавленные",
                color = LabazaTheme.title,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            NewDogsList(dogs = newDogs)

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Общая статистика",
                color = LabazaTheme.title,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            TopNurseriesList(nurseries = statNurseries)

            Spacer(modifier = Modifier.height(20.dp))
            TopDogsByChildrenList(dogs = statDogs)

            Spacer(modifier = Modifier.height(30.dp))
            
        }
    }


}
