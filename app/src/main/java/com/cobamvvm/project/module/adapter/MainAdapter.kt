package com.cobamvvm.project.module.adapter

import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cobamvvm.project.R
import com.cobamvvm.project.data.model.ConfirmedResponseItem
import kotlinx.android.extensions.LayoutContainer
import java.text.SimpleDateFormat
import java.util.*

class MainAdapter (private var items:MutableList<ConfirmedResponseItem>, private val context: Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_confirmed, parent, false))

        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view=holder.itemView
        val data=items[position]

        view.let {
            it.visibility = View.VISIBLE

            (it.findViewById(R.id.tv_country) as TextView).text = data.combinedKey
            (it.findViewById(R.id.tv_confirmed) as TextView).text = "Confirmed : "+data.confirmed
            (it.findViewById(R.id.tv_recovered) as TextView).text = "Recovered : "+data.recovered
            (it.findViewById(R.id.tv_death) as TextView).text = "Deaths : "+data.deaths
            (it.findViewById(R.id.tv_active) as TextView).text = "Active : "+data.active
            (it.findViewById(R.id.tv_last_update) as TextView).text = "Last Update : "+getDateTime(data.lastUpdate.toString())

        }

        view.setOnClickListener {

        }

    }

    private fun getDateTime(s: String): String? {
        try {
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val netDate = Date(s.toLong())
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }

    fun resetData(){
        items.clear()
        notifyDataSetChanged()
    }

    fun addItem(confirmedResponseItem: ConfirmedResponseItem){
        items.add(confirmedResponseItem)
        notifyDataSetChanged()
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {


    }
}