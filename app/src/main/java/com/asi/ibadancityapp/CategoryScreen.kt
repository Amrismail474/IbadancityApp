package com.asi.ibadancityapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.asi.ibadancityapp.Viewmodel.StateViewmodel
import com.asi.ibadancityapp.data.categoryClass
import com.asi.ibadancityapp.model.default
import com.asi.ibadancityapp.model.getCatModel
import com.asi.ibadancityapp.ui.theme.IbadanCityAppTheme





@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    category: categoryClass,
    onclick: (Int) -> Unit
){

    Card (modifier = Modifier.padding(8.dp).clickable { onclick(category.id) }){
        Column(modifier = Modifier.padding(8.dp)) {
          Row {

                Image(painter = painterResource(category.image),
                    contentDescription = stringResource(category.title),
                    modifier
                        .clip(RoundedCornerShape(10.dp))
                        .size(100.dp).weight(1f),
                    contentScale = ContentScale.Crop)

              Text(text = stringResource(category.title),modifier = modifier
                  .align(Alignment.CenterVertically)
                  .padding(20.dp).weight(1f), )
          }

        }
    } }

@Composable
fun CategoryList(
    categories: List<categoryClass>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    onclick: (Int) -> Unit
){

    LazyColumn(
        modifier.height(100.dp),
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        items(categories){category->
            CategoryItem(modifier, category, onclick=onclick)
        }
    }
}


@Preview
@Composable
fun preview(){
    IbadanCityAppTheme {

        CategoryList(
            categories = getCatModel(), onclick = {})
    }
}






