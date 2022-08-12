package com.league2022of.proball.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.league2022of.proball.databinding.CardPlayerBinding
import com.league2022of.proball.fragments.TeamFragmentDirections
import com.league2022of.proball.model.PlayerModel

class PlayerListAdapter : RecyclerView.Adapter<PlayerListAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(val binding: CardPlayerBinding) : RecyclerView.ViewHolder(binding.root)

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
            CardPlayerBinding.inflate(
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

            playerImage.setOnClickListener {
                Navigation.findNavController(it).navigate(TeamFragmentDirections.actionCountryFragmentToPlayerInfoFragment(currentToDo))
            }

//
//            roleText.text = currentToDo.role
//
            if(currentToDo.roster == "0"){
                forward.text = "TO ROSTER"
            }
            else{
                forward.text = "TO RESERVE"
            }


        }
            holder.binding.forward.setOnClickListener {

            onItemClickListenerString?.let { currentToDo.roster?.let { it1 -> it(it1) } }
            onItemClickListenerStringId?.let { it(currentToDo.id.toString()) }
        }
    }

    override fun getItemCount() = sportList.size

    private var onItemClickListenerString: ((String) -> Unit)? = null

    fun setOnItemClickListenerString(listenerString: (String) -> Unit) {
        onItemClickListenerString = listenerString
    }

    private var onItemClickListenerStringId: ((String) -> Unit)? = null

    fun setOnItemClickListenerStringId(listenerStringId: (String) -> Unit) {
        onItemClickListenerStringId = listenerStringId
    }
}