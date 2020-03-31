package org.d3if4127.jurnal09.ui.miwok

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_miwok.view.*
import org.d3if4127.jurnal09.R
import org.d3if4127.jurnal09.network.MiwokData
import org.d3if4127.jurnal09.network.WordListData

class MiwokAdapter(private val myDataset: List<MiwokData>, val onClickListener: OnClickListener) :
    RecyclerView.Adapter<MiwokAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiwokAdapter.MyViewHolder {
        val miwok_item = LayoutInflater.from(parent.context).inflate(R.layout.item_miwok, parent, false)
        return MyViewHolder(miwok_item)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: MiwokAdapter.MyViewHolder, position: Int) {
        holder.view.tv_category.text = myDataset[position].category
        holder.view.container_item.setBackgroundColor(Color.parseColor( myDataset[position].background))
        holder.view.setOnClickListener {
            onClickListener.onClick(myDataset[position].wordList, myDataset[position].background, myDataset[position].category)
        }
    }

    class OnClickListener(val clickListener: (miwokProperty: List<WordListData>, color: String, title: String) -> Unit) {
        fun onClick(miwokProperty:List<WordListData>, color: String, title: String) = clickListener(miwokProperty, color, title)
    }

}