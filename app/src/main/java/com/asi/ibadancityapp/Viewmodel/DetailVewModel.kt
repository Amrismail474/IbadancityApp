package com.asi.ibadancityapp.Viewmodel

import androidx.lifecycle.ViewModel
import com.asi.ibadancityapp.R
import com.asi.ibadancityapp.Util.Categories
import com.asi.ibadancityapp.data.categoryClass
import com.asi.ibadancityapp.model.getCatModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class StateViewmodel : ViewModel(){

    val categories = getCatModel()
    val _uiState = MutableStateFlow(StateUiViemodel(

        category = categories,
        currentcategory = categories.firstOrNull() ?:
        categoryClass(
            1, R.drawable.resturant, R.string.resturant, Categories.RESTURANTS),
    ))

    val uiState : MutableStateFlow<StateUiViemodel> = _uiState



    fun selectcategory(category:categoryClass){
        _uiState.value = _uiState.value.copy(currentcategory = category)
    }

}



data class StateUiViemodel(
    val category : List<categoryClass>,
    val currentcategory : categoryClass
)
