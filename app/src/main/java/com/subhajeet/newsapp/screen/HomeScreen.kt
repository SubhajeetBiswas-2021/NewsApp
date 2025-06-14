package com.subhajeet.newsapp.screen




import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.subhajeet.newsapp.screen.nav.Routes
import com.subhajeet.newsapp.viewModels.NewsViewModels


@Composable
fun HomeScreen(viewModels : NewsViewModels,navController:NavController){

    val res = viewModels.res.value?.articles ?: emptyList()


    val context = LocalContext.current


    /*Column {

        LazyColumn {
            items(res){

                EachCard(title = it.title , imageUrl= it.urlToImage, onClick = {

                    navController.navigate(Routes.DetailsScreenRoutes(
                        title=it.title,
                        url=it.url,
                        description =it.description,
                        imageUrl = it.urlToImage,
                        content = it.content
                    ))
                })
            }

        }
    }*/
    Column {
        LazyColumn {
            items(res) { item ->
                EachCard(
                    title = item.title,
                    imageUrl = item.urlToImage,
                    onClick = {
                        // Check if any required parameter is null
                        if (item.title != null &&
                            item.url != null &&
                            item.description != null &&
                            item.urlToImage != null &&
                            item.content != null) {

                            // Proceed with navigation
                            navController.navigate(
                                Routes.DetailsScreenRoutes(
                                    title = item.title,
                                    url = item.url,
                                    description = item.description,
                                    imageUrl = item.urlToImage,
                                    content = item.content
                                )
                            )
                        } else {
                            // Optionally show a message or log the issue
                            Log.e("Navigation", "Navigation aborted due to null parameters")

                            Toast.makeText(context, "There is nothing more to read", Toast.LENGTH_SHORT).show()

                        }
                    }
                )
            }
        }
    }

}

@Composable
fun EachCard(

    onClick:() -> Unit,
    title:String?,
    imageUrl:String?,
){

    Card(modifier = Modifier.fillMaxWidth().padding(8.dp).clickable(onClick = onClick))
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().height(100.dp).padding(8.dp)
        ){

            if(imageUrl != null){
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(80.dp).clip(RoundedCornerShape(8.dp))
                )
            }else{
                Image(
                    imageVector = Icons.Default.Face,
                contentDescription = null
                )

            }

            Spacer(modifier = Modifier.width(8.dp))


            Column{


                if(title != null){
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                    )
                }else{
                    Text(text = "Title is not found")
                }

            }

        }
    }
}
