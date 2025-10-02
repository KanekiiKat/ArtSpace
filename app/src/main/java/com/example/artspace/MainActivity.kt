package com.example.artspace

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DinamicImage(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DinamicImage(modifier: Modifier = Modifier) {
    var imageNumber by remember { mutableStateOf(0) }
    val imageResource = listOf(
        R.drawable.sololeveling1,
        R.drawable.callofthenigth2,
        R.drawable.attackontitan3,
        R.drawable.jujutsukaisen4,
        R.drawable.mirainikki5,
        R.drawable.rezero6,
        R.drawable.swordartonline7,
        R.drawable.shangrilafrontier8,
        R.drawable.tokyoghoul9,
        R.drawable.tokyorevengers10
    )

    val animesTitleResource = listOf(
            R.string.sololevelingTitle,
            R.string.callofthenigthTitle,
            R.string.attackontitanTitle,
            R.string.jujutsukaisenTitle,
            R.string.mirainikkiTitle,
            R.string.rezeroTitle,
            R.string.swordartonlineTitle,
            R.string.shangrilafrontierTitle,
            R.string.tokyoghoulTitle,
            R.string.tokyorevengersTitle
    )
    val animesAutorResource = listOf(
        R.string.sololevelingAutor,
        R.string.callofthenigthAutor,
        R.string.attackontitanAutor,
        R.string.jujutsukaisenAutor,
        R.string.mirainikkiAutor,
        R.string.rezeroAutor,
        R.string.swordartonlineAutor,
        R.string.shangrilafrontierAutor,
        R.string.tokyoghoulAutor,
        R.string.tokyorevengersAutor
    )
    
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Column(modifier = modifier.background(color = Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,) {

        Image(
            painter = painterResource(imageResource[imageNumber]),
            contentDescription = "Image not hidden",
            alignment = Alignment.Center,
            modifier = modifier.size(300.dp).padding(top = 20.dp).fillMaxSize(),

            )
        Text(
            text = stringResource(animesTitleResource[imageNumber]),
            textAlign = TextAlign.Center,
            fontSize = 36.sp,
            modifier = modifier.padding(top = 20.dp)

                )
        Text(
            text = stringResource(animesAutorResource[imageNumber]),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = modifier.padding(top = 5.dp)
            )

        Row (
            modifier = modifier.padding(vertical = 20.dp)
        ){
            Button(
                colors = ButtonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.Gray),
                modifier = modifier.width(100.dp).height(40.dp),
                onClick = { imageNumber = formerImage(imageNumber, imageResource.size) }

            ) { Text("Former")}
            Spacer(modifier.padding(horizontal = 10.dp))
            Button(
                colors = ButtonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.Gray),
                modifier = modifier.width(100.dp).height(40.dp),
                onClick = {imageNumber = nextImage(imageNumber, imageResource.size) }


            ) { Text("Next")}
        } }

    }
}


fun nextImage(imageNumber: Int, imageListSize: Int): Int {
    if (imageNumber == imageListSize - 1){
        return 0
    } else {
        return imageNumber + 1
    }
}

fun formerImage(imageNumber: Int, imageListSize: Int): Int{

    if (imageNumber == 0){
        return imageListSize - 1
    } else {
        return imageNumber - 1
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        DinamicImage()
    }
}