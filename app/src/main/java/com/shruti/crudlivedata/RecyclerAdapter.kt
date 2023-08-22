package com.shruti.crudlivedata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var item : ArrayList<NotesEntity>, var recyclerInterface: RecyclerInterface) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            var title = view.findViewById<TextView>(R.id.tvtitle)
            var description = view.findViewById<TextView>(R.id.tvdescription)
            var time = view.findViewById<TextView>(R.id.tvtime)
            var btnupdate = view.findViewById<TextView>(R.id.btnupdate)
            var btndelete = view.findViewById<TextView>(R.id.btndelete)
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
        holder.time.setText(item[position].time)
        holder.btndelete.setOnClickListener {
            recyclerInterface.deleteNotes(item[position], position)
        }
        holder.btnupdate.setOnClickListener {
            recyclerInterface.updateNotes(item[position],position)
        }

    }
}