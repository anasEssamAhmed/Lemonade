package com.example.clickbehavior

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clickbehavior.ui.theme.ClickBehaviorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickBehaviorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    var currentImage by remember { mutableStateOf(R.drawable.lemon_tree) }
    var counter by remember { mutableStateOf(1) }
    var counter2 by remember { mutableStateOf(1) }
    var text by remember { mutableStateOf("Tap the lemon tree to select a lemon") }

    currentImage = when (counter) {
        1 -> {
            R.drawable.lemon_tree
        }

        2 -> {
            R.drawable.lemon_squeeze
        }

        3 -> {
            R.drawable.lemon_drink
        }

        else -> {
            R.drawable.lemon_restart
        }
    }
    text = when (counter) {
        1 -> {
            "Tap the lemon tree to select a lemon"
        }

        2 -> {
            "Keep tapping the lemon to squeeze it"
        }

        3 -> {
            "Tap the lemonade to drink it"
        }

        else -> {
            "Tap the empty glass to start again"
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(currentImage),
            contentDescription = null,
            Modifier
                .size(200.dp)
                .background(Color(0xFFc3ecd2), RoundedCornerShape(10.dp))
                .clickable {
                    if(counter == 2){
                        if (counter2 == 1) {
                            counter2 = (2..5).random()
                        }
                        counter2--
                        if(counter2 == 1){
                            counter = 3
                        }
                    }

               else if (counter != 4 ){
                        counter++
                    }else {
                        counter = 1
                    }



/*                    if(counter >= 4){
                        if (counter == 2){
                            counter2 = (2..5).random()
                        }else {
                            counter++
                        }
                    }else {
                        counter = 1
                    }

                    if (counter2 >= 2 && counter == 2){
                        counter2--
                    }else {
                        counter = 3
                    }*/
                },

            )
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = text, fontSize = 13.sp)
    }


}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LemonPreview() {
    ClickBehaviorTheme {
        LemonadeApp()
    }
}