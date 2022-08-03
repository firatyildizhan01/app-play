//package com.sport.footballteams.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.paging.PagingDataAdapter
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.sport.footballteams.R
//import com.sport.footballteams.databinding.CardListWithImageBinding
//import com.sport.footballteams.model.Events
//
//class ListAdapter : PagingDataAdapter<Events,
//        ListAdapter.ImageViewHolder>(diffCallback) {
//
//    inner class ImageViewHolder(
//        val binding: CardListWithImageBinding
//    ) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(item: Events) = with(binding) {
//            imageList = item
//
//            firstTeamExp.text = item.opp_1_name
//
//            Glide.with(binding.root)
//                .load(item.opp_1_icon)
//                .centerCrop()
//                .into(firstTeamImage)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
//        val layout= DataBindingUtil.inflate<CardListWithImageBinding>(
//            LayoutInflater.from(parent.context),
//            R.layout.card_list_with_image,parent,false)
//
//        return ImageViewHolder(layout)
//    }
//
//    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
//        getItem(position)?.let { holder.bind(it) }
//    }
//
//    companion object {
//        val diffCallback = object : DiffUtil.ItemCallback<Events>() {
//            override fun areItemsTheSame(oldItem: Events, newItem: Events): Boolean {
//                return oldItem.chain_id == newItem.chain_id
//            }
//
//            override fun areContentsTheSame(oldItem: Events, newItem: Events): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//}