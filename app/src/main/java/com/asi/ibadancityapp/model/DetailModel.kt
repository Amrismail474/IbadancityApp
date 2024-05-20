package com.asi.ibadancityapp.model

data class Restaurant(val name: String,  val rating: Double)

fun ResturantList(): List<Restaurant>{

    return listOf(
        Restaurant("Iya Meta", 5.0),
        Restaurant("Amala Skye", 4.5),
        Restaurant("Chicken Republic", 3.0),
        Restaurant("Dominion",3.5),
        Restaurant("Kilimanjaro",4.9)
    )
}

data class ChillingSpots(val name:String, val gatefee:Boolean,  val rating: Double)

fun ChillingList() : List<ChillingSpots>{

    return listOf(
        ChillingSpots("Agodi Garden", true,3.9),
        ChillingSpots("Ui Zoo", true, 4.0),
        ChillingSpots("TopfatArt", false, 4.0)
    )
}

data class Mall(val name: String,  val rating: Double)

fun MallsList() : List<Mall>{

    return listOf(
        Mall("Ace Mall", 4.0),
        Mall("Palms", 4.0),
        Mall("Ventura", 4.5)
    )
}