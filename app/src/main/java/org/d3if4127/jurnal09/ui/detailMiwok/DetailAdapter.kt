package org.d3if4127.jurnal09.ui.detailMiwok

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_miwok_detail.view.*
import org.d3if4127.jurnal09.R
import org.d3if4127.jurnal09.network.WordListData
import org.d3if4127.jurnal09.ui.miwok.MiwokAdapter

class DetailAdapter(private val myDataset: ArrayList<WordListData>?, private val background: String?) :
    RecyclerView.Adapter<MiwokAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiwokAdapter.MyViewHolder {
        val miwok_item = LayoutInflater.from(parent.context).inflate(R.layout.item_miwok_detail, parent, false)
        return MiwokAdapter.MyViewHolder(miwok_item)
    }

    override fun getItemCount(): Int {
        if (myDataset == null) {
            return 0
        }else {
            return myDataset.size
        }
    }

    override fun onBindViewHolder(holder: MiwokAdapter.MyViewHolder, position: Int) {
        holder.view.iv_miwok.setImageDrawable(null);
        holder.view.container_item.setBackgroundColor(Color.parseColor(background))
        holder.view.tv_defaultmiwok.text = myDataset?.get(position)?.defaultWord.toString()
        holder.view.tv_miwokword.text = myDataset?.get(position)?.miwokWord.toString()
        if (myDataset!![position].image != null) {
//            Glide.with(holder.itemView.context).load("http://dif.indraazimi.com/miwok/${myDataset?.get(position)?.image}").into(holder.view.iv_miwok)
            Glide.with(holder.view.context)
                .load("http://dif.indraazimi.com/miwok/${myDataset?.get(position)?.image}")
                .placeholder(R.drawable.ic_launcher_foreground)
                .dontAnimate()
                .into(holder.view.iv_miwok);
        }else {
            Glide.with(holder.view.context).clear(holder.view.iv_miwok)
            holder.view.iv_miwok.setImageDrawable(null);
            holder.view.iv_miwok.visibility = View.GONE
        }
    }

}