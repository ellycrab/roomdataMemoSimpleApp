package com.ellycrab.androidroomdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.ellycrab.androidroomdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}
    lateinit var helper: RoomHelper
    lateinit var  memoAdapter:RecyclerAdapter
    private val memoList = mutableListOf<RoomMemo>()
    lateinit var memoDAO:RoomMemoDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        helper = Room.databaseBuilder(this,RoomHelper::class.java,"room_db")
            .allowMainThreadQueries() //공부할때만 쓴다.
            .build()

        memoDAO = helper.roomMemoDao()

        memoAdapter = RecyclerAdapter(memoList)

        refreshAdapter()

        with(binding){
            recyclerMemo.adapter = memoAdapter
            recyclerMemo.layoutManager = LinearLayoutManager(this@MainActivity)

            button.setOnClickListener {
                val content = editText.text.toString()
                if(content.isNotEmpty()){
                    val datetime = System.currentTimeMillis()
                    val memo = RoomMemo(content,datetime)
                    memoDAO.insert(memo)
                        refreshAdapter()

                }
            }
        }
    }
    private fun refreshAdapter(){
        memoList.clear()
        memoList.addAll(memoDAO.getAll())
        memoAdapter.notifyDataSetChanged()
    }
}