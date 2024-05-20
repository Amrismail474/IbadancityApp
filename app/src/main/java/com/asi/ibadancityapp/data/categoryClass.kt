package com.asi.ibadancityapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.asi.ibadancityapp.Util.Categories



data class categoryClass(
    val id: Int,
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    val category : Categories
    )

