package com.asi.ibadancityapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asi.ibadancityapp.Util.Categories
import com.asi.ibadancityapp.data.categoryClass
import com.asi.ibadancityapp.model.ChillingList
import com.asi.ibadancityapp.model.ChillingSpots
import com.asi.ibadancityapp.model.Mall
import com.asi.ibadancityapp.model.MallsList
import com.asi.ibadancityapp.model.Restaurant
import com.asi.ibadancityapp.model.ResturantList


@Composable
fun ResturantItem(modifier: Modifier = Modifier,
                  restaurant: Restaurant,
                 onclick: (String) -> Unit){

    Card(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
        .clickable { onclick(restaurant.name) }) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = restaurant.name, modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(8.dp))
        }
    }
}

@Composable
fun ChillingItem(modifier: Modifier = Modifier,
                  chillingSpots: ChillingSpots,
                  onclick: (String) -> Unit){

    Card(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
        .clickable { onclick(chillingSpots.name) }) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = chillingSpots.name, modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(8.dp))
        }
    }

}
@Composable
fun MallItem(modifier: Modifier = Modifier,
                 mall: Mall,
                  onclick: (String) -> Unit){

    Card(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
        .clickable { onclick(mall.name) }) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = mall.name, modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(8.dp))
        }
    }

}

@Composable
fun DetailList(
    title: String,
    modifier: Modifier = Modifier,
    resturants: List<Restaurant>,
    chillingSpots: List<ChillingSpots>,
    malls: List<Mall>,
    onclick: (String) -> Unit
){
    when(title){
        "Resturants" -> {
                LazyColumn(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp), // Spacing between items
                    contentPadding = PaddingValues(16.dp) // Padding
                ) {
                    items(resturants){resturant->
                        ResturantItem(restaurant = resturant, onclick={resturant.name})
                    }
                }
            }
        "Chilling" ->{
            LazyColumn(modifier,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                items(chillingSpots){chillingspot->
                    ChillingItem(chillingSpots = chillingspot, onclick ={chillingspot.name})
                }
            }

        }
        else->{
            LazyColumn(modifier,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                items(malls){mallitem->
                    MallItem(mall = mallitem, onclick ={mallitem.name})
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TopPreview() {
    DetailList (title = "Hi", resturants = ResturantList(),
    chillingSpots = ChillingList() ,
    malls = MallsList()) {
        
    }
}