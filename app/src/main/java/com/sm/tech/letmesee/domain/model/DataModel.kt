package com.sm.tech.letmesee.domain.model

import com.sm.tech.letmesee.data.entity.Articles

data class DataModel(var status:String, var totalResults:Int?, var articles: List<Articles?>?)