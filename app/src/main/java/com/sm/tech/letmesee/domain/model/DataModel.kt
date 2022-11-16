package com.sm.tech.letmesee.domain.model

import android.os.Parcelable
import com.sm.tech.letmesee.data.entity.Articles
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel(var status:String, var totalResults:Int?, var articles: List<Articles?>?) :
    Parcelable