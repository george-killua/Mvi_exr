package com.hisoka.mvi_exr.data.daos

import androidx.room.*

@Dao
interface BaseDao<T> {
				fun getAll() : List<T>

				@Insert(onConflict = OnConflictStrategy.REPLACE)
				fun insertObject(vararg objects : T)

				@Update
				fun updateObjects(vararg objects : T)

				@Delete
				fun delete(vararg objects : T)
}