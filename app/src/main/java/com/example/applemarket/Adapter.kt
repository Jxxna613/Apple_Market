package com.example.applemarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemViewBinding

class Adapter(val items: MutableList<MarketInfo>) : RecyclerView.Adapter<Adapter.Holder>() {
    private var onClickListener : OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Holder {
        return Holder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(items[position].itemImage)
        holder.itemTitle.text = items[position].itemTitle
        holder.address.text = items[position].address
        holder.priceInfo.text = (String.format("%,d원",items[position].priceInfo))
        holder.chat.text = items[position].chat.toString()
        holder.heart.text = items[position].heart.toString()
        holder.itemView.setOnClickListener {
            if(onClickListener != null) {
                onClickListener!!.onClick(position, item)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setOnClickListener(onClickLister : OnClickListener) {
        this.onClickListener = onClickLister
    }

    interface OnClickListener {
        fun onClick(position: Int, model: MarketInfo)
    }

    class Holder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView = binding.imageView
        val itemTitle = binding.titleText
        val address = binding.locationText
        val priceInfo = binding.price
        val chat = binding.chatNumber
        val heart = binding.heartNumber
    }
}