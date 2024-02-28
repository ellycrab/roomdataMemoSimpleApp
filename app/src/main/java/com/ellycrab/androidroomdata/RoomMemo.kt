package com.ellycrab.androidroomdata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.chrono.ChronoLocalDateTime


@Entity(tableName = "room_memo")
class RoomMemo {

    @PrimaryKey(autoGenerate = true) //no에 값이 없을 때 자동증가된 숫자값을 db에 입력해주ㅜㄴ다.
    @ColumnInfo
    var no: Long? = null

    @ColumnInfo
    var content: String = ""

    @ColumnInfo(name = "date")  //alias
    var datetime: Long = 0L

    constructor(content: String, datetime: Long) {
        this.content = content
        this.datetime = datetime
    }
}
