package com.example.larantaappmobile.welcome.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.larantaappmobile.utils.LabazaTheme
import com.example.larantaappmobile.welcome.model.WelcomeNursery

@Composable
fun TopNurseriesList(
    modifier: Modifier = Modifier,
    nurseries: SnapshotStateList<WelcomeNursery>
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = LabazaTheme.cardBgTop
        )
    ) {
        Column {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                text = "По количеству собак",
                color = LabazaTheme.cardTitle,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LabazaTheme.cardBgList)
            ) {
                for (i in 0..< nurseries.size) {
                    Row {
                        if (nurseries[i].nameEng != null)
                        Text(
                            text = "${if (nurseries[i].nameOwn != null) nurseries[i].nameOwn else nurseries[i].nameEng}",
                            fontSize = 20.sp,
                            color = LabazaTheme.nursery,
                            modifier = Modifier
                                .padding(start=20.dp, top=10.dp, bottom = 10.dp)
                                .weight(1f)
                        )

                        if (nurseries[i].dogs != null)
                        Text(text = "${nurseries[i].dogs}",
                            fontSize = 20.sp,
                            color = LabazaTheme.nursery,
                            modifier = Modifier
                                .padding(end=20.dp, top=10.dp, bottom = 10.dp)
                        )
                    }
                    if (i != nurseries.size-1) {
                        Divider(color = LabazaTheme.cardDivider)
                    }
                }
            }
        }
    }
}

@Composable
fun TopNurseriesListPreview() {

    val nurseries = remember {
        mutableStateListOf(
            WelcomeNursery(id=1, nameEng = "Primavera Incanta", nameOwn = "Примавера Инканта", dogs = 141),
            WelcomeNursery(id=2, nameEng = "Sharm de luxe", dogs = 87),
            WelcomeNursery(id=3, nameEng = "Wellary", nameOwn = "Веллари", dogs = 85),
        )
    }

    TopNurseriesList(
        modifier = Modifier.padding(20.dp),
        nurseries = nurseries
    )

}

@Preview
@Composable
fun TopNurseriesListPreviewLight() {
    LabazaTheme.setLightTheme()
    TopNurseriesListPreview()
}

@Preview
@Composable
fun TopNurseriesListPreviewDark() {
    LabazaTheme.setDarkTheme()
    TopNurseriesListPreview()
}