package com.example.herboshadhi

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.squareup.picasso.Picasso

class MyListAdapter(private val context: FragmentActivity?, private val title:Array<String?>, private val imgid:Array<String?>):ArrayAdapter<String>(
    context!!,R.layout.custom_list,title){

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflator= context?.layoutInflater
        val rowView= inflator?.inflate(R.layout.custom_list,null,true)

        val titleText=rowView?.findViewById(R.id.herbotitle) as TextView
        val imgView=rowView.findViewById(R.id.herboicon) as ImageView

        titleText.text=title[position]
        Picasso.get().load(imgid[position]).into(imgView)

        return rowView
    }
}