package com.megalexa.adapters.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.megalexa.R

class BlockViewAdapter(val dataset: ArrayList<String>,val context: Context): RecyclerView.Adapter<BlockViewHolder>(){

    override fun onBindViewHolder(holder: BlockViewHolder, position: Int) {
        holder.tView?.text = dataset[position]
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockViewHolder {
        return BlockViewHolder(LayoutInflater.from(context).inflate(R.layout.item_workflow, parent, false))
    }

}

class BlockViewHolder(v: View): RecyclerView.ViewHolder(v) {

    val  tView = v.findViewById<TextView>(R.id.workflow_name)

}