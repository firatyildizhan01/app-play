package com.league2022of.proball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.league2022of.proball.databinding.CardListBinding
import com.league2022of.proball.fragments.NewGameFragmentDirections
import com.league2022of.proball.model.Body

class SportAdapter : RecyclerView.Adapter<SportAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(val binding: CardListBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Body>() {

        override fun areItemsTheSame(oldItem: Body, newItem: Body): Boolean {
            return oldItem.tournament_id == newItem.tournament_id
        }

        override fun areContentsTheSame(oldItem: Body, newItem: Body): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)
    var sportList: List<Body>
        get() = differ.currentList
        set(value) { differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {

        return ToDoViewHolder(
            CardListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        var y = sportList
        val currentToDo = sportList[position].events_list

        holder.binding.apply {

            firstTeamExp.text = currentToDo.elementAtOrNull(0)?.opp_1_name_en ?: ""
            secondTeamExp.text = currentToDo.elementAtOrNull(0)?.opp_2_name_en ?: ""
            firstTeamRateText.text =(currentToDo.elementAtOrNull(0)?.game_oc_list?.elementAtOrNull(0)?.oc_rate ?: "").toString()
            secondTeamRateText.text =(currentToDo.elementAtOrNull(0)?.game_oc_list?.elementAtOrNull(1)?.oc_rate ?: "").toString()

            cardSport.setOnClickListener {
                Navigation.findNavController(it).navigate(NewGameFragmentDirections.actionMatchListFragmentToDetailFragment(currentToDo[0]))
            }
        }
    }

    override fun getItemCount() = sportList.size

    private var onItemClickListenerString: ((String) -> Unit)? = null

    fun setOnItemClickListenerString(listenerString: (String) -> Unit) {
        onItemClickListenerString = listenerString
    }
}