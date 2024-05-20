package com.asi.ibadancityapp

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.navigation.compose.rememberNavController
import com.asi.ibadancityapp.Viewmodel.StateViewmodel
import com.asi.ibadancityapp.model.ChillingList
import com.asi.ibadancityapp.model.MallsList
import com.asi.ibadancityapp.model.ResturantList
import com.asi.ibadancityapp.model.getCatModel

@Composable
fun CategoryApp(
    navController : NavHostController = rememberNavController(),
    viewmodel : StateViewmodel = viewModel()
){

    val uiState by viewmodel.uiState.collectAsState()
    Log.d("CategoryApp", "UI State: $uiState")

    val currentBackStack = navController.currentBackStackEntryAsState().value
    val currentroute = currentBackStack?.destination?.route

    val currenttitle = when {
        currentroute?.startsWith(Screen.detail.route) ==true -> Screen.detail.title
        currentroute?.startsWith(Screen.category.route) ==true -> Screen.category.title
        currentroute?.startsWith(Screen.subdetail.route) ==true -> Screen.subdetail.title
        else -> R.string.app_name
    }



    Scaffold(

        topBar = {
            Log.d("CategoryApp", "Current category title: ${uiState.currentcategory.title}")
            Topbar(title = currenttitle)}) {contentpadding->

        NavHost(navController = navController,
            startDestination = Screen.category.route,
            modifier = Modifier
                .padding(contentpadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            composable(route = Screen.category.route){

                CategoryList(
                    categories = uiState.category , onclick={
                        title ->
                        Log.d("CategoryApp", "Category clicked: $title")
                        navController.navigate("${Screen.detail.route}/$title")
                    }
                  )
            }

            composable(route = Screen.detail.route){navBackStackEntry ->
                val title = navBackStackEntry.arguments?.getString("title")
                Log.d("CategoryApp", "Navigated to Detail with title: $title")
                if (title != null) {
                    DetailList(
                        title = title, resturants = ResturantList(),
                        chillingSpots = ChillingList() ,
                        malls = MallsList()
                    ) {name->
                        Log.d("CategoryApp", "Detail item clicked: $name")
                        navController.navigate("${Screen.subdetail.route}/$name")
                    }
                }
        }

    }


}}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar(modifier: Modifier = Modifier, title: Int){
    TopAppBar(
        title = {
            Text(text = stringResource(title))
        },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary)

    )
}


sealed class Screen (val route: String, @StringRes val title : Int){
    object category : Screen ("Category", R.string.category_title)
    object detail : Screen ("Details/{title}", R.string.detail_title)
    object subdetail : Screen("SubDetails/{name}", R.string.subdetail_title)
}


@Preview(showBackground = true)
@Composable
fun TopbarPreview() {
    CategoryApp()
}
