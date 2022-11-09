package com.sm.tech.letmesee.data.entity

import android.os.Parcelable
import androidx.annotation.Keep


@Keep
data class LetMeSeeEntity(
      val name: String,
      val url: String,
      /* val image: Image,*/
      val description: String,
      /*val about: List<About>,
      val provider: List<Provider>,*/
      val datePublished: String,
      val category: String
)
