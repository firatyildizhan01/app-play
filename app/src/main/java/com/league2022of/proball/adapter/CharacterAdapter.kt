package com.league2022of.proball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.league2022of.proball.adapter.CharacterAdapter.ImageViewHolder
import com.bumptech.glide.Glide
import com.league2022of.proball.R
import com.league2022of.proball.databinding.CardListWithImageBinding
import com.league2022of.proball.model.Events

class CharacterAdapter : PagingDataAdapter<Events,
        ImageViewHolder>(diffCallback) {

    inner class ImageViewHolder(
        val binding: CardListWithImageBinding
    ) :
        ViewHolder(binding.root) {
        fun bind(item: Events) = with(binding) {
            imageList = item

            binding.firstTeamExp.text = item.opp_1_name_en

            binding.secondTeamExp.text = item.opp_2_name_en

            Glide.with(binding.root)
                .load(item.opp_1_icon)
                .centerCrop()
                .into(firstTeamImage)

            Glide.with(binding.root)
                .load(item.opp_2_icon)
                .centerCrop()
                .into(secondTeamImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layout= DataBindingUtil.inflate<CardListWithImageBinding>(LayoutInflater.from(parent.context),
            R.layout.card_list_with_image,parent,false)

        return ImageViewHolder(layout)

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Events>() {
            override fun areItemsTheSame(oldItem: Events, newItem: Events): Boolean {
                return oldItem.chain_id == newItem.chain_id
            }

            override fun areContentsTheSame(oldItem: Events, newItem: Events): Boolean {
                return oldItem == newItem
            }
        }
    }
}