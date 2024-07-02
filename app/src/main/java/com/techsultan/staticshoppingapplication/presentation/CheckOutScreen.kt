package com.techsultan.staticshoppingapplication.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.techsultan.staticshoppingapplication.MainViewModel
import com.techsultan.staticshoppingapplication.models.CheckoutItems
import com.techsultan.staticshoppingapplication.navigation.Screens
import com.techsultan.staticshoppingapplication.ui.theme.component.AppButton
import com.techsultan.staticshoppingapplication.util.Util.toCurrency

@Composable
fun CheckOutScreen(
    navHostController: NavHostController
) {

    val viewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
    val cartItemState by viewModel.cartItems.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(cartItemState) {
        viewModel.getCart()
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(imageVector = Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = null)

            Text(text = "CheckOut")

            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = null)
        }

        val cartItems = cartItemState
        Log.d("CART ITEM", "Cart: $cartItems")
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(cartItems) { item ->
                CheckOutCard(
                    image = item.image,
                    name = item.name,
                    price = item.price.toCurrency(),
                    onClick = {
                        viewModel.removeItemFromCart(item)
                        Toast.makeText(context, "Item removed", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }

        AppButton(
            onClick = {
                if (cartItems.isNotEmpty()) {
                    navHostController.popBackStack()
                    navHostController.navigate(Screens.Successful.route)
                } else {
                    Toast.makeText(context, "Your cart is empty", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 100.dp)
        ) {
            Text(text = "Checkout")
        }

    }
}

@Composable
fun CheckOutCard(
    image: Int,
    name: String,
    price: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.weight(1f).fillMaxHeight()
            ) {

                Text(
                    text = price,
                    fontSize = 18.sp,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = name,
                    fontSize = 18.sp,
                    overflow = TextOverflow.Ellipsis
                )

            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = {onClick()},
                content = {
                    Icon(
                        imageVector = Icons.Outlined.Clear,
                        contentDescription = null
                    )
                },
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}
