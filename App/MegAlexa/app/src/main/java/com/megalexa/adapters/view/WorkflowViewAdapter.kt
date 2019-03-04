package com.megalexa.adapters.view

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.megalexa.R
import com.megalexa.activities.ViewBlockActivity
import com.megalexa.models.workflow.Workflow
import com.megalexa.util.ItemClickListener


class WorkflowViewAdapter(private val dataset: ArrayList<Workflow>, private val context: Context):RecyclerView.Adapter<WorkflowViewHolder>(){


    override fun onBindViewHolder(holder: WorkflowViewHolder, position: Int) {
        holder.workflowName?.text = dataset[position].getName()

        holder.setItemClickListener(object: ItemClickListener{

            override fun onClick(view: View?, position: Int) {
                val intent = Intent(context,ViewBlockActivity::class.java)
                intent.putExtra("workflowName",dataset[position].getName())
                context.startActivity(intent)
            }

        })

    }

    override fun getItemCount(): Int {
        return dataset.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkflowViewHolder {
        return WorkflowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_workflow, parent, false))
    }
}



class WorkflowViewHolder(v: View): RecyclerView.ViewHolder(v),View.OnClickListener {

    val  workflowName :TextView? = v.findViewById(R.id.workflow_name)
    private lateinit var itemClickListener:ItemClickListener

    init{
        workflowName?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        itemClickListener.onClick(v,adapterPosition)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener= itemClickListener
    }

}