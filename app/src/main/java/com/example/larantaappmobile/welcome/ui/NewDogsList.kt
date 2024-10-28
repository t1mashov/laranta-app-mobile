package com.example.larantaappmobile.welcome.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.larantaappmobile.utils.LabazaURL
import com.example.larantaappmobile.R
import com.example.larantaappmobile.test.LabazaProgressBar
import com.example.larantaappmobile.utils.LabazaTheme
import com.example.larantaappmobile.welcome.model.WelcomeNewDog

@Composable
fun WelcomeDogCard(
    dog: WelcomeNewDog
) {

    Card(
        modifier = Modifier
            .sizeIn(minWidth = 150.dp, minHeight = 150.dp, maxWidth = 250.dp, maxHeight = 400.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = LabazaTheme.cardDogBg
        )
    ) {
        Column {
            Box(
                modifier = Modifier.wrapContentWidth(),
                contentAlignment = Alignment.Center
            ) {
                if (!dog.imageTitle.isNullOrEmpty()) {

                    var isImageLoading by remember { mutableStateOf(true) }

                    if (isImageLoading)
                        LabazaProgressBar(
                            modifier = Modifier.size(150.dp),
                            color = LabazaTheme.imageProgressBar
                        )

                    Image(
                        modifier = Modifier
                            .size(width = 250.dp, height = 300.dp),
                        painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(LocalContext.current)
                                .data(dog.imageTitle!!)
                                .error(LabazaTheme.noYorkImage)
                                .build(),
                            onSuccess = {
                                isImageLoading = false
                            },
                            onError = {
                                println("NewDogsList >> onError: ${it.result.throwable.stackTrace.toList()}")
                            }
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                else {
                    Image(
                        modifier = Modifier
                            .size(width = 250.dp, height = 300.dp),
                        painter = painterResource(id = LabazaTheme.noYorkImage),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )

                }
            }


            Column(
                modifier = Modifier.padding(10.dp)
            ) {

                Row {
                    if (dog.idGender!=null)
                    Icon(
                        modifier = Modifier
                            .padding(top = 5.dp, end = 5.dp)
                            .size(20.dp),
                        imageVector = ImageVector.vectorResource(if (dog.idGender==3) R.drawable.male else R.drawable.female),
                        contentDescription = null,
                        tint = if (dog.idGender==3) LabazaTheme.male else LabazaTheme.female
                    )

                    if (dog.nameEng != null)
                    Text(
                        modifier = Modifier,
                        text = if (dog.nameOwn.isNullOrEmpty()) dog.nameEng!! else dog.nameOwn!!,
                        color = if (dog.idGender==3) LabazaTheme.male else LabazaTheme.female,
                        fontSize = 20.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))

                if (dog.countryCode != null)
                Row {
                    Image(
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .size(30.dp, 20.dp),
                        painter = rememberAsyncImagePainter(LabazaURL.flag(dog.countryCode!!)),
                        contentDescription = null
                    )
                    Text(
                        text = dog.countryName!!,
                        fontSize = 16.sp,
                        color = LabazaTheme.textBlack
                    )
                }

            }

        }

        Spacer(modifier = Modifier.weight(1f))
    }
}


@Composable
fun NewDogsList(
    modifier: Modifier = Modifier,
    dogs: SnapshotStateList<WelcomeNewDog>
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(
            items = dogs,
            key = {el -> el.id!!}
        ) {
            WelcomeDogCard(it)
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}


fun getDogs(): SnapshotStateList<WelcomeNewDog> {
    val dogs = mutableListOf(
        WelcomeNewDog(id=1, nameEng="A'LOCOMOTION OF MILLMOOR", idGender=3, countryCode = "cz", countryName="Чехия", imageTitle="1729195085-5.png"),
        WelcomeNewDog(id=2, nameEng="MANRIS LE BRI SANSA MAGIYA PROSHLOGO", nameOwn="МАНРС ЛЕ БРИ МАГИЯ ПРОШЛОГО", idGender=4, countryCode = "by", countryName="Беларусь"),
        WelcomeNewDog(id=3, nameEng="MANRIS LE BRI KIKI FARY TAIE", idGender=3, countryCode = "ru", countryName="Россия", imageTitle="1729416783-6.png"),
    )

    for (i in 0..< dogs.size) {
        if (dogs[i].imageTitle != null) {
            dogs[i].imageTitle = LabazaURL.image(dogs[i].imageTitle!!)
        }
    }

    val res = mutableStateListOf<WelcomeNewDog>()
    res.addAll(dogs)

    return res
}


@Preview
@Composable
fun NewDogsListPreviewLight() {
    LabazaTheme.setLightTheme()
    NewDogsListPreview()
}

@Preview
@Composable
fun NewDogsListPreviewDark() {
    LabazaTheme.setDarkTheme()
    NewDogsListPreview()
}

@Composable
fun NewDogsListPreview() {
    val dogs = remember { getDogs() }

    NewDogsList(
        modifier = Modifier.padding(20.dp),
        dogs = dogs
    )
}
