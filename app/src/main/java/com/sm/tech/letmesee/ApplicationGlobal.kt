package com.sm.tech.letmesee

import android.app.Application
import com.sm.tech.letmesee.di.LetMeSeeInject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationGlobal: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
                .androidContext(this@ApplicationGlobal)
                .modules(LetMeSeeInject.provideDependency())

        }
    }
}