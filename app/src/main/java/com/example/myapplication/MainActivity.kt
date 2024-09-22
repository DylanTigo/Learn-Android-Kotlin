package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    GreetingImage(stringResource(R.string.happy_birthday_text), from = stringResource(
//                        R.string.signature_text
//                    )
//                    )
                    Article(title = stringResource(R.string.title), paragraph1 = stringResource(R.string.paragraph1), paragraph2 = stringResource(R.string.paragraph2))
                }
            }
        }
    }
}

@Composable
fun GreetingText (message: String, from: String, modifier: Modifier = Modifier) {
    Column ( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(30.dp)) {
        Text(
            text = message,
            fontSize = 110.sp,
            lineHeight = 110.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Text(
            text = from,
            fontSize = 30.sp,
            lineHeight = 40.sp,
            color = Color.White
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.birdthday)
    Box(modifier = Modifier.padding(bottom = 50.dp)) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.7F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
fun Article (title: String, paragraph1: String, paragraph2: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose)
    val defaultFontSize = 16.sp
    val defaultLineHeight = 20.sp

    Column( verticalArrangement = Arrangement.Top){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Column( modifier = Modifier.padding(16.dp)){
            Text(
                text = title,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                modifier= Modifier.padding(top = 32.dp, bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = paragraph1,
                fontSize = defaultFontSize,
                lineHeight = defaultLineHeight,
            )
            Text(
                text = paragraph2,
                fontSize = defaultFontSize,
                lineHeight = defaultLineHeight,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun BirthDayCardPreview() {
    MyApplicationTheme {
//        GreetingImage("Happy BirthDay Dylan Noel", from = "Merveille and Audrey")
        Article(title = stringResource(R.string.title), paragraph1 = stringResource(R.string.paragraph1), paragraph2 = stringResource(R.string.paragraph2))
    }
}