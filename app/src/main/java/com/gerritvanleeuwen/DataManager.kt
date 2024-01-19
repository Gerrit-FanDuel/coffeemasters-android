package com.gerritvanleeuwen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.gerritvanleeuwen.coffeemasters.pages.Category
import com.gerritvanleeuwen.coffeemasters.pages.ItemInCart
import com.gerritvanleeuwen.coffeemasters.pages.Product

class DataManager {
    var menu: List<Category> by mutableStateOf(listOf())
    var cart: List<ItemInCart> by mutableStateOf(listOf())

    fun cartAdd(product: Product) {
        var found = false
        cart.forEach {
            if (product.id == it.product.id) {
                it.quantity++
                found = true
            }
        }
        if (!found) {
            cart = listOf(*cart.toTypedArray(), ItemInCart(product, 1))
        }
     }

    fun cartClear() {
        // similar to Flux
        // must create a new reference for state engine to detect a change and trigger an update
        cart = listOf()
    }

    fun cartRemove(product: Product) {
        val aux = cart.toMutableList()
        aux.removeAll { it.product.id == product.id }
        cart = listOf(*aux.toTypedArray())
    }
}