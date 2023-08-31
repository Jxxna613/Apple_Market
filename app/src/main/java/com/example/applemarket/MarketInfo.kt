package com.example.applemarket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarketInfo(
    val itemImage : Int,
    val itemTitle : String,
    val itemInfo : String,
    val nickName : String,
    val priceInfo : Int,
    val address : String,
    val chat : Int,
    val heart : Int
) : Parcelable
