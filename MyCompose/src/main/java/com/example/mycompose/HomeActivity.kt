package com.example.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.ui.theme.MyJetpackTheme

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @Composable
    fun MyApp() {
        MyJetpackTheme {
            Surface(color = MaterialTheme.colors.background) {
                Text()
            }
        }
    }

    @Composable
    fun Text() {
        Column {
            Text(text = "abcdefg")
            TextColumnList()
            TextRowList()
            TextBoxList()
        }
    }

    /**
     * 垂直
     */
    @Composable
    fun TextColumnList(modifier: Modifier = Modifier) {
        Column {
            Text(text = "Android", modifier = Modifier.size(100.dp), fontSize = 20.sp)
            Text(text = "JetPack Compose", modifier = Modifier.size(100.dp), fontSize = 20.sp)
        }
    }

    /**
     * 水平
     */
    @Composable
    fun TextRowList(modifier: Modifier = Modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Android", modifier = Modifier.size(100.dp), fontSize = 20.sp)
            Text(text = "JetPack Compose", modifier = Modifier.size(100.dp), fontSize = 20.sp)
        }
    }

    /**
     * 叠加
     */
    @Composable
    fun TextBoxList(modifier: Modifier = Modifier) {
        Box {
            Text(text = "Android", modifier = Modifier.size(100.dp), fontSize = 20.sp)
            Text(text = "JetPack Compose", modifier = Modifier.size(100.dp), fontSize = 20.sp)
        }
    }

    /**
     *
     * 自定义控件
     */
    @Composable
    fun Custom(modifier: Modifier = Modifier) {
        Box {
            Surface(
                modifier = modifier,
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {

            }
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyApp()
    }


}