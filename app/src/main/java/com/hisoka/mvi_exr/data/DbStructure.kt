package com.hisoka.mvi_exr.data

import androidx.room.*
import com.hisoka.mvi_exr.data.daos.UserDao
import com.hisoka.mvi_exr.data.model.UserEntity

@Database(entities = [UserEntity::class],version = 1,exportSchema = false)
abstract class DbStructure:RoomDatabase() {
				abstract val userDao: UserDao
}