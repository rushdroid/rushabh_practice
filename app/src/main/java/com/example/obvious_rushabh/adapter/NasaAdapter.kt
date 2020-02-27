package com.example.obvious_rushabh.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.obvious_rushabh.R
import com.example.obvious_rushabh.activity.NasaDetailActivity
import com.example.obvious_rushabh.model.NasaModel
import kotlinx.android.synthetic.main.list_item_grid_nasa.view.*

class NasaAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listNasaModel: List<NasaModel> = listOf()
    private var context: Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NasaListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_grid_nasa,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listNasaModel.size
    }

    fun setData(listOfNasaModel: List<NasaModel>?) {
        if (listOfNasaModel != null) {
            this.listNasaModel = listOfNasaModel
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val nasaListViewHolder = holder as NasaListViewHolder
        holder.itemView.imageNasaPic.setOnClickListener(View.OnClickListener {
            context.startActivity(
                Intent(
                    context,
                    NasaDetailActivity::class.java
                ).putExtra("position", position)
            )
        })
        nasaListViewHolder.bindView(listNasaModel.get(position))
    }

    class NasaListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(nasa: NasaModel) {
            itemView.textTitle.text = nasa.title
            itemView.textDate.text = "Date: " + nasa.date
            itemView.textCopy.text = "Copy righ by: " + nasa.copyright

            Glide.with(itemView.context).load(nasa.url!!).into(itemView.imageNasaPic)
        }

    }
}