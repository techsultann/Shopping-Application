package com.techsultan.staticshoppingapplication.presentation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.techsultan.staticshoppingapplication.MainViewModel
import com.techsultan.staticshoppingapplication.models.CheckoutItems
import com.techsultan.staticshoppingapplication.models.Product
import com.techsultan.staticshoppingapplication.models.allProducts
import com.techsultan.staticshoppingapplication.models.categoryList
import com.techsultan.staticshoppingapplication.ui.theme.component.Category
import com.techsultan.staticshoppingapplication.ui.theme.component.ProductCard
import com.techsultan.staticshoppingapplication.util.Util.toCurrency

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(

) {

    val viewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
    var search by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    Scaffold { paddingValues ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(16.dp)

        ) {
            item(
                span = { GridItemSpan(this.maxLineSpan) },
                content = {
                    SearchBar(
                        query = search,
                        onQueryChange = { search = it },
                        onSearch = { expanded = false },
                        active = expanded,
                        onActiveChange = { expanded = it },
                        placeholder = { Text(text = "Search...")},
                        leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = null) }
                    ) {
                        Column(
                            modifier = Modifier
                        ) {
                            repeat(4) {idx ->
                                val result = "Suggestion $idx"
                                ListItem(
                                    headlineContent = { Text(text = result) },
                                    supportingContent = { Text(text = "Additional info") },
                                    leadingContent = { Icon(Icons.Filled.Star, contentDescription = null) },
                                    colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                                    modifier =
                                    Modifier
                                        .clickable {
                                            expanded = false
                                        }
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp, vertical = 4.dp)
                                )
                            }

                        }

                    }

                }
            )

            header {
                Row(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Categories",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "See all"
                    )
                }

            }

            header {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    val category = categoryList
                    items(category) { item ->
                        Category(
                            image = item.image,
                            category = item.name
                        )
                    }
                }
            }

            header {
                Text(
                    text = "All Product",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                )
            }

            items(allProducts) { item ->
                ProductCard(
                    image = item.image,
                    name = item.name,
                    price = item.price,
                    onClick = {
                        viewModel.addItemToCart(item.id, item.image, item.name, item.price)
                        Toast.makeText(context, "Item added to cart", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }


}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}

@Preview
@Composable
fun PreviewHomeScreen(){
    HomeScreen()
}