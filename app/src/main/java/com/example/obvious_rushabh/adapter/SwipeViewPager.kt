package com.example.obvious_rushabh.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.obvious_rushabh.R
import com.example.obvious_rushabh.model.NasaModel
import kotlinx.android.synthetic.main.swipe_item.view.*


class SwipeViewPager(context: Context) : PagerAdapter() {
    private var list = listOf<NasaModel>()
    private var ctx = context;
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }

    override fun getCount(): Int {
        return list.size
    }

    fun setData(list: List<NasaModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View =
            LayoutInflater.from(container.context).inflate(R.layout.swipe_item, container, false)
        itemView.textTitle.text = list.get(position).title
        itemView.textDate.text =
            "Date: " + list.get(position).date + "\nCopyright: " + list.get(position).copyright
        itemView.textDesc.text = list.get(position).explanation
        Glide.with(container.context).load(list.get(position).hdurl!!).into(itemView.imageNasaPic)
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}