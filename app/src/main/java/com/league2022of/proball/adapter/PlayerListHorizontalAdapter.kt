package com.league2022of.proball.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.league2022of.proball.databinding.CardPlayerHorizantalBinding
import com.league2022of.proball.model.PlayerModel

class PlayerListHorizontalAdapter : RecyclerView.Adapter<PlayerListHorizontalAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(val binding: CardPlayerHorizantalBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<PlayerModel>() {

        override fun areItemsTheSame(oldItem: PlayerModel, newItem: PlayerModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PlayerModel, newItem: PlayerModel): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)
    var sportList: List<PlayerModel>
        get() = differ.currentList
        set(value) { differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {

        return ToDoViewHolder(
            CardPlayerHorizantalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        var y = sportList
        val currentToDo = sportList[position]



        holder.binding.apply {

            playerImage.setImageResource(currentToDo.imageUrl)

            playerName.text = currentToDo.playerName

//            playerLayout.setOnClickListener {
//                Navigation.findNavController(it).navigate(TeamFragmentDirections.actionCountryFragmentToPlayerInfoFragment(currentToDo))
//            }
//
//            roleText.text = currentToDo.role
//


        }

            holder.binding.playerLayout.setOnClickListener {

                holder.binding.playerLayout.visibility = View.GONE

                var c = currentToDo.playerName
                onItemClickListenerStringxId?.let { currentToDo.playerName?.let { it1 -> it(it1) } }
        }

    }

    override fun getItemCount() = sportList.size

    private var onItemClickListenerString: ((String) -> Unit)? = null

    fun setOnItemClickListenerString(listenerString: (String) -> Unit) {
        onItemClickListenerString = listenerString
    }

    private var onItemClickListenerStringxId: ((String) -> Unit)? = null

    fun setOnItemClickListenerStringxId(listenerStringxId: (String) -> Unit) {
        onItemClickListenerStringxId = listenerStringxId
    }
}