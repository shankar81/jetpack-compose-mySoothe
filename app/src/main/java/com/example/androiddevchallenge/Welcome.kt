package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class Welcome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme(true) {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    WelcomeBackground {
                        WelcomeContent()
                    }
                }
            }
        }
    }
}

@Composable
fun WelcomeBackground(content: @Composable () -> Unit) {
    val isDarkMode = !MaterialTheme.colors.isLight
    Box {
        CoilImage(
            data = if (isDarkMode) R.drawable.dark_welcome else R.drawable.light_welcome,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Welcome Background"
        )
        content()
    }
}

@Composable
fun WelcomeContent() {
    val isDarkMode = !MaterialTheme.colors.isLight
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = if (isDarkMode) R.drawable.dark_logo else R.drawable.light_logo),
            modifier = Modifier
                .height(48.dp)
                .padding(bottom = 32.dp),
            contentDescription = "MySooth Logo",
            contentScale = ContentScale.Fit,
        )
        MySoothButton(
            modifier = Modifier.padding(bottom = 8.dp),
            onClick = { },
            label = "SIGN UP",
            bgColor = MaterialTheme.colors.primary
        )
        MySoothButton(
            onClick = { },
            label = "LOG IN",
            bgColor = MaterialTheme.colors.secondary
        )
    }
}

@Composable
fun MySoothButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    label: String,
    bgColor: Color
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(backgroundColor = bgColor),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(24.dp)
    ) {
        Text(
            text = label,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.button,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme {
        WelcomeContent()
    }
}