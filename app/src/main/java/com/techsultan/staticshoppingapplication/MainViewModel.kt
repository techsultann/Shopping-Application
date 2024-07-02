package com.techsultan.staticshoppingapplication

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.preference.PreferenceManager
import com.techsultan.staticshoppingapplication.models.CheckoutItems
import com.techsultan.staticshoppingapplication.models.Product
import com.techsultan.staticshoppingapplication.repository.Repository
import com.techsultan.staticshoppingapplication.ui.theme.ShopApplication
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
): ViewModel() {

    private val _cartItems = MutableStateFlow<List<CheckoutItems>>(emptyList())
    val cartItems: StateFlow<List<CheckoutItems>> = _cartItems.asStateFlow()


    fun addItemToCart(
        id: Int,
        image: Int,
        name: String,
        price: Double
    ) {
        viewModelScope.launch {
            repository.addCartItem(id, image, name, price)
            _cartItems.value = repository.getCartItems()
        }

    }

    fun removeItemFromCart(cart: CheckoutItems) {
        viewModelScope.launch {
            repository.deleteCartItem(cart)
            _cartItems.value = repository.getCartItems()
        }

    }

    fun getCart() {
        viewModelScope.launch {
            _cartItems.value = repository.getCartItems()
        }

    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as ShopApplication)
                val repository = application.repository
                MainViewModel(repository = repository)
            }
        }
    }
}