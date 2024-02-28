package com.ellycrab.androidroomdata

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface RoomMemoDAO {

    @Query("select * from room_memo")
    fun getAll():List<RoomMemo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memo:RoomMemo)

    @Delete
    fun delete(memo: RoomMemo)
}