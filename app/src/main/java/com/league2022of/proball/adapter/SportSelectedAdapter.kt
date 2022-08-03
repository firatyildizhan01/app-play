package com.league2022of.proball.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.league2022of.proball.databinding.CardListBinding
import com.league2022of.proball.model.ListModel

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

            firstTeamExp.text = currentToDo.teamOne
            secondTeamExp.text = currentToDo.teamSecond
            firstTeamRateText.text =currentToDo.resultOne
            secondTeamRateText.text =currentToDo.resultTwo
            resultCardText.text =currentToDo.resultText

            if(currentToDo.resultText == "WIN"){
                resultCardText.setTextColor(Color.parseColor("#00A027"))
            }
            if(currentToDo.resultText == "LOSE"){
                resultCardText.setTextColor(Color.parseColor("#FD6767"))
            }
            if(currentToDo.resultText == "DRAW"){
                resultCardText.setTextColor(Color.parseColor("#C7C7C7"))
            }
        }
    }

    override fun getItemCount() = sportList.size

    private var onItemClickListenerString: ((String) -> Unit)? = null

    fun setOnItemClickListenerString(listenerString: (String) -> Unit) {
        onItemClickListenerString = listenerString
    }
}