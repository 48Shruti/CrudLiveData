package com.shruti.crudlivedata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var item : ArrayList<LiveDataEntity>, var liveDataDao: LiveDataDao) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            var title = view.findViewById<TextView>(R.id.tvtitle)
            var description = view.findViewById<TextView>(R.id.tvdescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_view,parent,false
        )
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return  item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(item[position].title)
        holder.description.setText(item[position].description)
    }
}