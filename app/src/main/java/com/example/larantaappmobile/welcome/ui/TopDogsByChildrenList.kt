package com.example.larantaappmobile.welcome.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.larantaappmobile.R
import com.example.larantaappmobile.utils.LabazaTheme
import com.example.larantaappmobile.welcome.model.WelcomeDog

@Composable
fun TopDogsByChildrenList(
    modifier: Modifier = Modifier,
    dogs: SnapshotStateList<WelcomeDog>
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
                text = "По потомству",
                color = LabazaTheme.cardTitle,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LabazaTheme.cardBgList)
            ) {
                for (i in 0..< dogs.size) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (dogs[i].idGender != null)
                        Icon(
                            modifier = Modifier
                                .padding(start=10.dp)
                                .size(20.dp),
                            imageVector = ImageVector.vectorResource(if (dogs[i].idGender==3) R.drawable.male else R.drawable.female),
                            contentDescription = null,
                            tint = if (dogs[i].idGender==3) LabazaTheme.male else LabazaTheme.female
                        )

                        if (dogs[i].nameEng != null)
                        Text(
                            text = "${if (dogs[i].nameOwn != null) dogs[i].nameOwn else dogs[i].nameEng}",
                            fontSize = 20.sp,
                            color = if (dogs[i].idGender==3) LabazaTheme.male else LabazaTheme.female,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(start=2.dp, top=10.dp, bottom = 10.dp)
                                .weight(1f)
                        )

                        if (dogs[i].children != null)
                        Text(text = "${dogs[i].children}",
                            fontSize = 20.sp,
                            color = if (dogs[i].idGender==3) LabazaTheme.male else LabazaTheme.female,
                            modifier = Modifier
                                .padding(end=20.dp, top=10.dp, bottom = 10.dp)
                        )
                    }
                    if (i != dogs.size-1) {
                        Divider(color = LabazaTheme.cardDivider)
                    }
                }
            }
        }
    }
}


@Composable
fun TopDogsByChildrenListPreview() {

    val dogs = remember {
        mutableStateListOf(
            WelcomeDog(id=1, nameEng = "Favourite Winners Vostorg Kelwin", idGender = 3, children = 43),
            WelcomeDog(id=1, nameEng = "Kimi", nameOwn = "Кими", idGender = 4, children = 25),
            WelcomeDog(id=1, nameEng = "Mini Shop Federer", idGender = 3, children = 22),
            WelcomeDog(id=1, nameEng = "Primavera Incanta Renzo", idGender = 4, children = 20),
        )
    }

    TopDogsByChildrenList(
        modifier = Modifier.padding(20.dp),
        dogs = dogs
    )
}

@Preview
@Composable
fun TopDogsByChildrenListPreviewLight() {
    LabazaTheme.setLightTheme()
    TopDogsByChildrenListPreview()
}

@Preview
@Composable
fun TopDogsByChildrenListPreviewDark() {
    LabazaTheme.setDarkTheme()
    TopDogsByChildrenListPreview()
}