package com.gerritvanleeuwen.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.gerritvanleeuwen.coffeemasters.pages.InfoPage
import com.gerritvanleeuwen.coffeemasters.pages.MenuPage
import com.gerritvanleeuwen.coffeemasters.pages.OrderPage
import com.gerritvanleeuwen.coffeemasters.ui.theme.CoffeeMastersTheme

@Preview
@Composable
fun App_Preview() {
    CoffeeMastersTheme {
        App()
    }
}

@Composable
fun App() {
    var selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }

    Scaffold(
        topBar = {
                 TopAppBar {
                     AppTitle()
                 }
        },
        content = {
                  when(selectedRoute.value) {
                      Routes.MenuPage.route -> MenuPage()
                      Routes.OffersPage.route -> OffersPage()
                      Routes.OrderPage.route -> OrderPage()
                      Routes.InfoPage.route -> InfoPage()
                  }
        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,
                onChange = {  // Lambda expression
                // closure
                selectedRoute.value = it
            })
//            NavBar(onChange = { newRoute ->
//                selectedRoute.value = newRoute
//            })
        }
    )
}

@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo")
    }
}