package com.asi.ibadancityapp.model

import com.asi.ibadancityapp.R
import com.asi.ibadancityapp.Util.Categories
import com.asi.ibadancityapp.data.categoryClass


fun getCatModel() : List<categoryClass> {


   return listOf (

       categoryClass(
        1,R.drawable.resturant, R.string.resturant, Categories.RESTURANTS),
       categoryClass(
           2,R.drawable.chilli, R.string.chill,Categories.CHILLING_SPOTS
       ),
       categoryClass(
           3,R.drawable.mall,R.string.mall, Categories.MALLS
       ),
       categoryClass(
           1,R.drawable.resturant, R.string.resturant, Categories.RESTURANTS),
       categoryClass(
           2,R.drawable.chilli, R.string.chill,Categories.CHILLING_SPOTS
       ),
       categoryClass(
           3,R.drawable.mall,R.string.mall, Categories.MALLS
       ),
       categoryClass(
           1,R.drawable.resturant, R.string.resturant, Categories.RESTURANTS),
       categoryClass(
           2,R.drawable.chilli, R.string.chill,Categories.CHILLING_SPOTS
       ),
       categoryClass(
           3,R.drawable.mall,R.string.mall, Categories.MALLS
       )

   )


}
fun default() : categoryClass{
   val default = getCatModel()[0]
    return default
}

