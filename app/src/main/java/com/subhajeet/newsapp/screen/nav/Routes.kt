package com.subhajeet.newsapp.screen.nav

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object MainScreenRoutes

    //@Serializable
    //object DetailsScreenRoutes
    // as we have to transfer data from one screen to other screen so we write as data class

    @Serializable
    data class DetailsScreenRoutes(

         val title:String,
         val description : String,
         val imageUrl : String,
         val content :String,
         val url:String )

    }

