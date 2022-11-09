package com.sm.tech.letmesee.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sm.tech.letmesee.R
import com.sm.tech.letmesee.data.network.LetMeSeeRemoteDataSourceImpl

class MainActivity : AppCompatActivity() {

    private var letMeSeeRemoteDataSourceImpl:LetMeSeeRemoteDataSourceImpl = LetMeSeeRemoteDataSourceImpl()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        letMeSeeRemoteDataSourceImpl.getList()
    }
}