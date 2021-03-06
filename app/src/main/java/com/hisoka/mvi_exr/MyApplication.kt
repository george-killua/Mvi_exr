package com.hisoka.mvi_exr

import android.app.Application
import com.hisoka.mvi_exr.data.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication:Application() {
				override fun onCreate() {
								super.onCreate()
								startKoin {
												androidContext(this@MyApplication)
												modules(modules)
								}
				}
}