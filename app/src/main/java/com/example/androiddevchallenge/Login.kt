package com.example.androiddevchallenge

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun Login(navController: NavHostController) {
    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {
        MySootheBackground(
            lightImage = R.drawable.light_login,
            darkImage = R.drawable.dark_login,
            contentDescription = "Login Background"
        ) {
            LoginContent(navController)
        }
    }
}

@Composable
fun LoginContent(navController: NavHostController) {
    CenteredColumn {
        Text(
            text = "LOG IN",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        MySootheInput(placeholder = "Email address")
        MySootheInput(
            placeholder = "Password",
            visualTransformation = PasswordVisualTransformation()
        )
        MySoothButton(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = { navController.navigate("Home") },
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
fun MySootheInput(
    modifier: Modifier = Modifier,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: (@Composable () -> Unit)? = null
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
                color = MaterialTheme.colors.onSurface
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onBackground,
            backgroundColor = MaterialTheme.colors.surface
        ),
        visualTransformation = visualTransformation,
        leadingIcon = leadingIcon
    )
}