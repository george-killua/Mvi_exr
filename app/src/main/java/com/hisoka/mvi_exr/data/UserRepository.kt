package com.hisoka.mvi_exr.data

import com.hisoka.mvi_exr.data.daos.UserDao
import com.hisoka.mvi_exr.data.model.UserEntity

class UserRepository(private val userDao : UserDao) {
				fun getAllUser() =userDao.getAll()
				fun insertUser(vararg users:UserEntity)=userDao.insertObject(*users)
				fun updateUser(vararg users:UserEntity)=userDao.updateObjects(*users)
				fun deleteUser(vararg users:UserEntity)=userDao.delete(*users)

}