package com.techsultan.staticshoppingapplication.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.techsultan.staticshoppingapplication.util.Util.toCurrency

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(
    image: Int,
    name: String,
    price: Double,
    onClick: () -> Unit
) {

    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(bottom = 10.dp)
            .height(230.dp)
            .width(170.dp)
            .background(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = name,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = price.toCurrency(),
                        overflow = TextOverflow.Ellipsis
                    )
                }

                IconButton(
                    onClick = { onClick() },
                    modifier = Modifier
                ) {
                    Icon(imageVector = Icons.Outlined.Add, contentDescription = null)
                }
            }

        }

    }

}