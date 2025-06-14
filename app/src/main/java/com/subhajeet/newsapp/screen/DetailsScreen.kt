package com.subhajeet.newsapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.subhajeet.newsapp.R


@Composable
fun DetailsScreen(
    title : String,
    description:String,
    imageUrl:String,
    content:String,
    url:String
) {

    Column(modifier = Modifier.fillMaxSize()) {



        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 25.sp)

        SubcomposeAsyncImage(
            model = imageUrl,
            loading = {
                CircularProgressIndicator()
            },
            error = {
                Text(text = "error")
            },
            contentDescription = null,
        )

        Text(text=description)

        Text(text = content)


    }


}