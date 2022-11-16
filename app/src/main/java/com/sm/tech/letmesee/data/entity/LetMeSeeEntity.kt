package com.sm.tech.letmesee.data.entity

import android.os.Parcelable
import androidx.annotation.Keep
import com.sm.tech.letmesee.domain.model.DataModel
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class LetMeSeeEntity(
 var status       : String?             = null,
 var totalResults : Int?                = null,
 var articles     : ArrayList<Articles>? = arrayListOf()
) : Parcelable {
    fun toModel()= DataModel(
        status = status.orEmpty(),
        totalResults = totalResults,
        articles = articles.orEmpty()
    )
}
@Parcelize
@Keep
data class Source (

  var id   : String? = null,
  var name : String? = null

) : Parcelable

@Parcelize
@Keep
data class Articles (

  var source      : Source? = Source(),
  var author      : String? = null,
  var title       : String? = null,
  var description : String? = null,
  var url         : String? = null,
  var urlToImage  : String? = null,
  var publishedAt : String? = null,
  var content     : String? = null

) : Parcelable