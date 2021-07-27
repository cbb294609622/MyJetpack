package com.example.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.ui.theme.MyJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp(){
    MyJetpackTheme{
       Surface(color = MaterialTheme.colors.background) {
           ImageText()
       }
    }
}


@Composable
fun NewsStory() {
    Column{
        Text(text = "what your name")
        Text(text = "what your name")
        Text(text = "what your name")
        Text(text = "what your name")
    }
}

@Composable
fun ImageText() {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(10.dp))
        NewsStory()
        BtnText()
    }
}

@Composable
fun BtnText(){
    Button(onClick = { /*TODO*/ }) {
        Text(text = "123")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}