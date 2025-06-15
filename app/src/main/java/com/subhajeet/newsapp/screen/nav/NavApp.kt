package com.subhajeet.newsapp.screen.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.subhajeet.newsapp.screen.DetailsScreen
import com.subhajeet.newsapp.screen.HomeScreen
import com.subhajeet.newsapp.viewModels.NewsViewModels
import okhttp3.Route

@Composable
fun NavApp(viewModels: NewsViewModels){

    val navController = rememberNavController()

    NavHost(navController=navController, startDestination = Routes.MainScreenRoutes){

        composable<Routes.MainScreenRoutes>{
            HomeScreen(viewModels=viewModels,navController=navController)
        }

        composable<Routes.DetailsScreenRoutes> {

            val data = it.toRoute<Routes.DetailsScreenRoutes>()
            DetailsScreen(
                title = data.title,
                description = data.description,
                imageUrl = data.imageUrl,
                content = data.content,
                url=data.url
            )
        }
    }
}