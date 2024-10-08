package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.*
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
//                    Article(title = stringResource(R.string.title), paragraph1 = stringResource(R.string.paragraph1), paragraph2 = stringResource(R.string.paragraph2))
//                    TaskHandler(text1 = stringResource(R.string.task_handler_text1), text2 = stringResource(R.string.task_handler_text2))
//                    QuadrantsTP(title1 = stringResource(R.string.title1), description1 = stringResource(R.string.description1), title2 = stringResource(R.string.title2), description2 = stringResource(R.string.description2), title3 = stringResource(R.string.title3), description3 = stringResource(R.string.description3), title4 = stringResource(R.string.title4), description4 = stringResource(R.string.description4))
                    Quadrants(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun GreetingText (message: String, from: String, modifier: Modifier = Modifier) {
    Column ( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(30.dp).fillMaxSize(0.5f)) {
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
                textAlign = TextAlign.Justify,
                lineHeight = defaultLineHeight,
            )
            Text(
                text = paragraph2,
                fontSize = defaultFontSize,
                textAlign = TextAlign.Justify,
                lineHeight = defaultLineHeight,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

    }
}

@Composable
fun TaskHandler(text1: String, text2: String, modifier: Modifier = Modifier) {
    val imageIcon = painterResource(R.drawable.ic_task_completed)

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Image(
            painter = imageIcon,
            contentDescription = null
        )
        Text(
            text = text1,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = text2,
            fontSize = 16.sp
        )
    }
}

@Composable
fun QuadrantItem ( title: String, description: String, modifier: Modifier) {
    Column ( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxWidth(0.5f).fillMaxHeight().padding(16.dp)){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )
        Text(
            text = description,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            color = Color.Black
        )
    }
}

@Composable
fun Quadrants (modifier: Modifier = Modifier) {
    Column (modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Row (Modifier.fillMaxWidth().weight(1f), horizontalArrangement = Arrangement.Center) {
            QuadrantItem(
                title = stringResource(R.string.title1),
                description = stringResource(R.string.description1),
                modifier = Modifier.weight(1f).background(Color(0xFFEADDFF))
            )
            QuadrantItem(
                title = stringResource(R.string.title2),
                description = stringResource(R.string.description2),
                modifier = Modifier.weight(1f).background(Color(0xFFD0BCFF))
            )
        }
        Row (Modifier.fillMaxWidth().weight(1f), horizontalArrangement = Arrangement.Center) {
            QuadrantItem(
                title = stringResource(R.string.title3),
                description = stringResource(R.string.description3),
                modifier = Modifier.weight(1f).background(Color(0xFFB69DF8))
            )
            QuadrantItem(
                title = stringResource(R.string.title4),
                description = stringResource(R.string.description4),
                modifier = Modifier.weight(1f).background(Color(0xFFF6EDFF))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthDayCardPreview() {
    MyApplicationTheme {
//        GreetingImage("Happy BirthDay Dylan Noel", from = "Merveille and Audrey")
//        Article(title = stringResource(R.string.title), paragraph1 = stringResource(R.string.paragraph1), paragraph2 = stringResource(R.string.paragraph2))
//        TaskHandler(text1 = stringResource(R.string.task_handler_text1), text2 = stringResource(R.string.task_handler_text2))
//        QuadrantItem( title = stringResource(R.string.title1), description = stringResource(R.string.description1), modifier = Modifier)
        Quadrants(modifier = Modifier)
//        QuadrantsTP(title1 = stringResource(R.string.title1), description1 = stringResource(R.string.description1), title2 = stringResource(R.string.title2), description2 = stringResource(R.string.description2), title3 = stringResource(R.string.title3), description3 = stringResource(R.string.description3), title4 = stringResource(R.string.title4), description4 = stringResource(R.string.description4))
    }
}