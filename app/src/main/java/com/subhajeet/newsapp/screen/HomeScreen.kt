package com.subhajeet.newsapp.screen




import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.subhajeet.newsapp.viewModels.NewsViewModels


@Composable
fun HomeScreen(viewModels : NewsViewModels){

    val res = viewModels.res.value?.articles ?: emptyList()


    Column {

        LazyColumn {
            items(res){

                eachCard(title = it.title , imageUrl= it.urlToImage)
            }

        }
    }
}

@Composable
fun eachCard(
    title:String,
    imageUrl:String
){

    Card(modifier = Modifier.fillMaxWidth().padding(8.dp))
    {
        Row(){

            if(imageUrl != null){
                AsyncImage(
                    model = "imageUrl",
                    contentDescription = null,
                )
            }else{
                Image(
                    imageVector = Icons.Default.Face,
                contentDescription = null
                )

            }


            Column {
                Text(
                    text = "title",
                    fontWeight = FontWeight.Bold,
                )
            }

        }
    }
}
