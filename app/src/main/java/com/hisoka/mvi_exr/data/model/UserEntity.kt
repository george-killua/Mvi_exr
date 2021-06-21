package com.hisoka.mvi_exr.data.model

import androidx.room.*
import com.hisoka.mvi_exr.data.daos.TableNames

@Entity(tableName = TableNames.USERS_TABLE)
class UserEntity(
								@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val uId : Long?=null,
								@ColumnInfo(name = "firstname") val firstname : String,
								@ColumnInfo(name = "lastname") val lastname : String,
								@ColumnInfo(name = "creation_date") val date : Long = System.currentTimeMillis(),
)

