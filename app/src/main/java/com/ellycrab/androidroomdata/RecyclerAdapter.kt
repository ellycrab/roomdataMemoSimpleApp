package com.ellycrab.androidroomdata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ellycrab.androidroomdata.databinding.ItemRecyclerBinding
import kotlinx.coroutines.InternalCoroutinesApi
import java.text.SimpleDateFormat

class RecyclerAdapter(val roomMemoList:List<RoomMemo>):RecyclerView.Adapter<RecyclerAdapter.Holder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)

    }



    @OptIn(InternalCoroutinesApi::class)
    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder.setMemo(roomMemoList.get(position))
    }

    override fun getItemCount(): Int = roomMemoList.size

    class Holder(val binding: ItemRecyclerBinding):RecyclerView.ViewHolder(binding.root){
        fun setMemo(roomMemo:RoomMemo){
            with(binding){
                number.text = "${roomMemo.no}"
                content.text = "${roomMemo.content}"

                val sdf = SimpleDateFormat("yyyy/mm/dd hh:mm")
                date.text = sdf.format(roomMemo.datetime)
            }
        }
    }
}