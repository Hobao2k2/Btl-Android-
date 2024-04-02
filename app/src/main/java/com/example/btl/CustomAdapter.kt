package com.example.btl

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(val activity: Activity,val list:List<OutData>):ArrayAdapter<OutData>(activity,R.layout.list_item_monhoc) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexs=activity.layoutInflater
        val rowview=contexs.inflate(R.layout.list_item_monhoc,parent,false)
        val images=rowview.findViewById<ImageView>(R.id.images)
        val title=rowview.findViewById<TextView>(R.id.title)
        title.text=list[position].title
        images.setImageResource(list[position].image)
        return rowview
    }
}