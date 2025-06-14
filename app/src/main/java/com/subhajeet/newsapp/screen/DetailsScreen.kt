package com.subhajeet.newsapp.screen

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import coil3.compose.SubcomposeAsyncImage


@Composable
fun DetailsScreen(
    title : String,
    description:String,
    imageUrl:String,
    content:String,
    url:String
) {

    val verticalScrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize().verticalScroll(
        state = verticalScrollState,
        enabled = true
    ).padding(0.dp,34.dp,0.dp,0.dp)) {



        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 25.sp)

        Spacer(modifier = Modifier.fillMaxWidth().padding(0.dp,35.dp,0.dp,0.dp))

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

        Spacer(modifier = Modifier.fillMaxWidth().padding(0.dp,34.dp,0.dp,0.dp))

        Text(text=description)

        Spacer(modifier = Modifier.fillMaxWidth().padding(0.dp,34.dp,0.dp,0.dp))

        Text(text = content)

        Spacer(modifier = Modifier.fillMaxWidth().padding(0.dp,34.dp,0.dp,0.dp))

        val context  = LocalContext.current
        ElevatedButton(
            onClick = {
                val urlIntent = Intent(Intent.ACTION_VIEW).apply {

                    data = url.toUri()
                }
                context.startActivity(urlIntent)
            }
        ) {
            Text(text = "Read More")
        }


    }


}