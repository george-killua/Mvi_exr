package com.hisoka.mvi_exr.data

import android.app.Application
import androidx.room.Room
import com.hisoka.mvi_exr.ui.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val modules = module {
				fun databaseProvider(application : Application) = Room
								.databaseBuilder(application
												.applicationContext, DbStructure::class.java,
												DbStructure::javaClass.name)
								.allowMainThreadQueries()
								.build()

				fun userDao(dbStructure : DbStructure) = dbStructure.userDao


				single { databaseProvider(androidApplication()) }
				single { userDao(get()) }
				single { UserRepository(get()) }
				factory {
								MainViewModel()
				}
}