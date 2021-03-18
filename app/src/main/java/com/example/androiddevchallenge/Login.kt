package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MySootheBackground(
                        lightImage = R.drawable.light_login,
                        darkImage = R.drawable.dark_login,
                        contentDescription = "Login Background"
                    ) {
                        LoginContent()
                    }
                }
            }
        }
    }
}

@Composable
fun LoginContent() {
    CenteredColumn {
        Text(
            text = "LOG IN",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        LoginInput(placeholder = "Email address")
        LoginInput(placeholder = "Password", visualTransformation = PasswordVisualTransformation())
        MySoothButton(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = {},
            label = "LOG IN",
            bgColor = MaterialTheme.colors.primary
        )
        Text(
            text = "Don't have an account? Sign up",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
fun LoginInput(
    modifier: Modifier = Modifier,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        value = "",
        onValueChange = {},
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onBackground,
            backgroundColor = MaterialTheme.colors.surface
        ),
        visualTransformation = visualTransformation,
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MySootheBackground(
        lightImage = R.drawable.light_login,
        darkImage = R.drawable.dark_login,
        contentDescription = "Login Background"
    ) {
        LoginContent()
    }
}