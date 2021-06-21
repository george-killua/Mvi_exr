package com.hisoka.mvi_exr.data.daos

import androidx.room.*
import com.hisoka.mvi_exr.data.model.UserEntity

@Dao
interface UserDao : BaseDao<UserEntity> {
				@Query("select * from ${TableNames.USERS_TABLE}")
				override fun getAll() : List<UserEntity>
}

