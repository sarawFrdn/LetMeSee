package com.sm.tech.letmesee.data.entity

import androidx.annotation.Keep
import com.sm.tech.letmesee.domain.model.DataModel

@Keep
data class LetMeSeeEntity(
 var status       : String?             = null,
 var totalResults : Int?                = null,
 var articles     : ArrayList<Articles> = arrayListOf()
)
{
    fun toModel()= DataModel(
        status = status.orEmpty()
    )
}


data class Source (

  var id   : String? = null,
  var name : String? = null

)

data class Articles (

  var source      : Source? = Source(),
  var author      : String? = null,
  var title       : String? = null,
  var description : String? = null,
  var url         : String? = null,
  var urlToImage  : String? = null,
  var publishedAt : String? = null,
  var content     : String? = null

)