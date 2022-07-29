package com.football.challengemyteams.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.football.challengemyteams.databinding.CardListBinding
import com.football.challengemyteams.model.ListModel

class SportSelectedAdapter : RecyclerView.Adapter<SportSelectedAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(val binding: CardListBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<ListModel>() {

        override fun areItemsTheSame(oldItem: ListModel, newItem: ListModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ListModel, newItem: ListModel): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)
    var sportList: List<ListModel>
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
        val currentToDo = sportList[position]

        holder.binding.apply {

            firstTeamExp.text = currentToDo.nameOne
            secondTeamExp.text = currentToDo.nameSecond
            firstTeamRateText.text =currentToDo.rateOne
            secondTeamRateText.text =currentToDo.rateTwo

            var m = currentToDo.score?.substring(0,1)
            var s = currentToDo.score?.substring(1,2)
        }
    }

    override fun getItemCount() = sportList.size

    private var onItemClickListenerString: ((String) -> Unit)? = null

    fun setOnItemClickListenerString(listenerString: (String) -> Unit) {
        onItemClickListenerString = listenerString
    }
}