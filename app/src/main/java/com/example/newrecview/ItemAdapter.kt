package com.example.newrecview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newrecview.databinding.ItemLayoutFirstBinding
import com.example.newrecview.databinding.ItemLayoutSecondBinding

class ItemAdapter(
    private val items: MutableList<ItemModelFirst>,
    private var ItemLongClickListener: ItemLongClickListener,

) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1)
            ItemImgViewHolder(
                ItemLayoutFirstBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        else
            ItemNoImgViewHolder(
                ItemLayoutSecondBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is ItemImgViewHolder -> holder.bind()
            is ItemNoImgViewHolder -> holder.bind()
        }

    }

    override fun getItemCount() = items.size

    inner class ItemImgViewHolder(private val binding: ItemLayoutFirstBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnLongClickListener, View.OnClickListener {
        private lateinit var model: ItemModelFirst
        fun bind() {

            model = items[adapterPosition]

            binding.brandName.text = model.title

            val url: String? = model.url
            Glide.with(binding.imageView.context)
                .load(url)
                .centerCrop()
                .apply(RequestOptions.circleCropTransform())
                .into(binding.imageView)

            binding.root.setOnLongClickListener(this)
            binding.root.setOnClickListener(this)
        }



        override fun onLongClick(v: View?): Boolean {
            ItemLongClickListener.itemLongClickListener(adapterPosition)
            return true
        }

        override fun onClick(v: View?) {
            ItemLongClickListener.itemClickListener(adapterPosition)

        }
    }


    inner class ItemNoImgViewHolder(private val binding: ItemLayoutSecondBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnLongClickListener, View.OnClickListener {
        private lateinit var model: ItemModelFirst
        fun bind() {

            model = items[adapterPosition]
            binding.brandName.text = model.title
            if (model.url == null) {
                binding.imageView.setImageResource(R.drawable.ic_error)
            }

            binding.root.setOnLongClickListener(this)
            binding.root.setOnClickListener(this)

        }

        override fun onLongClick(v: View?): Boolean {
            ItemLongClickListener.itemLongClickListener(adapterPosition)
            return true
        }

        override fun onClick(v: View?) {
            ItemLongClickListener.itemClickListener(adapterPosition)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val model = items[position]
        return if (model.url == null)
            2
        else
            1
    }


}