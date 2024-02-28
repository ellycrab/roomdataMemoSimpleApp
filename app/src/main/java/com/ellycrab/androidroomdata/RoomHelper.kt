package com.ellycrab.androidroomdata

import androidx.room.Database
import androidx.room.RoomDatabase

//데이터 베이스임을 알려주고 또한 테이블이 몇개인지 entities로 알수있음
@Database(entities = arrayOf(RoomMemo::class), version = 1, exportSchema = false)
abstract class RoomHelper:RoomDatabase() {//RoomHelper를 통해서
    abstract fun roomMemoDao():RoomMemoDAO  //RoomMemoDao를 가져옴
}