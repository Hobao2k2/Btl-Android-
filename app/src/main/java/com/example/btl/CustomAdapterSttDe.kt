package com.example.btl

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapterSttDe(val activity:Activity,val list:List<OutDataSttDe>):ArrayAdapter<OutDataSttDe>(activity,R.layout.list_item_stt_de) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexs=activity.layoutInflater
        val rowview=contexs.inflate(R.layout.list_item_stt_de,parent,false)
        val sttDe=rowview.findViewById<TextView>(R.id.sttDe)
        val imagedongho=rowview.findViewById<ImageView>(R.id.dongho)
        val sophut=rowview.findViewById<TextView>(R.id.thoigian)
        val imagequyensach=rowview.findViewById<ImageView>(R.id.quyensach)
        val soluongcau=rowview.findViewById<TextView>(R.id.soluongcau)
        sttDe.text=list[position].tenDe
        imagedongho.setImageResource(list[position].imageDongHo)
        sophut.text=list[position].soPhut
        imagequyensach.setImageResource(list[position].imageQuyenSach)
        soluongcau.text=list[position].soLuongCau
        return rowview
    }
}