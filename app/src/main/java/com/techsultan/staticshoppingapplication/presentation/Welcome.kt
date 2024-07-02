package com.techsultan.staticshoppingapplication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.techsultan.staticshoppingapplication.R
import com.techsultan.staticshoppingapplication.navigation.Graph
import com.techsultan.staticshoppingapplication.navigation.Screens
import com.techsultan.staticshoppingapplication.ui.theme.component.AppButton

@Composable
fun WelcomeScreen(
    navHostController: NavHostController
) {

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Welcome",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "HNG Shopping Application",
            fontSize = 26.sp
        )
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.shopping_illustration),
            contentDescription = "shopping illustration image",
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )

        Spacer(modifier = Modifier.weight(0.5f))

        AppButton(
            onClick = {
                navHostController.popBackStack()
                navHostController.navigate(Graph.HOME)
                      },
            modifier = Modifier.fillMaxWidth().padding(bottom = 22.dp)
        ) {
            Text(text = "Continue")
            Spacer(modifier = Modifier.width(22.dp))
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = "right icon arrow"
            )
        }

    }
}

@Preview
@Composable
fun PreviewWelcome() {
    WelcomeScreen(rememberNavController())
}