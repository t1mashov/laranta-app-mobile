package com.example.larantaappmobile.welcome.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.larantaappmobile.utils.LabazaURL
import com.example.larantaappmobile.welcome.WelcomeApi
import com.example.larantaappmobile.welcome.model.WelcomeData
import com.example.larantaappmobile.welcome.model.WelcomeDog
import com.example.larantaappmobile.welcome.model.WelcomeNewDog
import com.example.larantaappmobile.welcome.model.WelcomeNursery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WelcomeViewModel(
    private val api: WelcomeApi
): ViewModel() {

    val statDogs: SnapshotStateList<WelcomeDog> = mutableStateListOf(
        WelcomeDog(id=1, nameEng="")
    )
    val statNurseries: SnapshotStateList<WelcomeNursery> = mutableStateListOf(
        WelcomeNursery(id=1, nameEng="")
    )
    val newDogs: SnapshotStateList<WelcomeNewDog> = mutableStateListOf(
        WelcomeNewDog(id=1)
    )

    val data: MutableState<WelcomeData?> = mutableStateOf(null)

    val isDataLoading: MutableState<Boolean> = mutableStateOf(false)

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            isDataLoading.value = true
            try {
                val response = api.getData()

                if (response.isSuccessful) response.body()?.let {
                    data.value = it

                    statDogs.clear()
                    statNurseries.clear()
                    newDogs.clear()

                    statDogs.addAll(it.statOnDogs)
                    statNurseries.addAll(it.statOnNurseries)
                    newDogs.addAll(it.newDogs)

                    for (i in 0..< newDogs.size) {
                        if (newDogs[i].imageTitle != null) {
                            newDogs[i].imageTitle = LabazaURL.image(newDogs[i].imageTitle!!)
                        }
                    }
                }


                isDataLoading.value = false

            } catch (e: Exception) {
                e.printStackTrace()
                isDataLoading.value = false
            }
        }
    }

}