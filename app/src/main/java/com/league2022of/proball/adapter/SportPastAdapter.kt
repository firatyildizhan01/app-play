package com.league2022of.proball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.league2022of.proball.databinding.CardListBinding
import com.league2022of.proball.model.ListModel

class SportPastAdapter : RecyclerView.Adapter<SportPastAdapter.ToDoViewHolder>() {

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

//        holder.binding.apply {
//
//            firstTeamExp.text = currentToDo.nameOne
//            secondTeamExp.text = currentToDo.nameSecond
//            firstTeamRateText.text =currentToDo.rateOne
//            secondTeamRateText.text =currentToDo.rateTwo
//
//            var firstNumber = currentToDo.score?.substring(0,1)
//            var SecondNumber = currentToDo.score?.substring(2,3)
//
//            if(currentToDo.teamCount == 0 && (firstNumber?.toInt() ?: 0) > (SecondNumber?.toInt() ?: 0)){
//                resultText.visibility = View.VISIBLE
//                resultText.text = "Win"
//                onItemClickListenerStringPast?.let {it(currentToDo.id)}
//            }
//            else if(currentToDo.teamCount == 1 && (firstNumber?.toInt() ?: 0) < (SecondNumber?.toInt() ?: 0)){
//                resultText.visibility = View.VISIBLE
//                resultText.text = "Win"
//                onItemClickListenerStringPast?.let {it(currentToDo.id)}
//            }
//            else if((firstNumber?.toInt() ?: 0) == (SecondNumber?.toInt() ?: 0)){
//                resultText.visibility = View.VISIBLE
//                resultText.text = "Draw"
//            }
//            else{
//                resultText.visibility = View.VISIBLE
//                resultText.text = "Lost"
//            }
//
//
//
////            if(currentToDo.teamCount == 0){
////                firstTeamRate.setBackgroundColor(Color.parseColor("#FFE9BF"))
////            }
//
//            else {
//                secondTeamRate.setBackgroundColor(Color.parseColor("#FFE9BF"))
//            }
//
//        }
    }

    override fun getItemCount() = sportList.size

    private var onItemClickListenerStringPast: ((Int) -> Unit)? = null

    fun setOnItemClickListenerStringPast(listenerString: (Int) -> Unit) {
        onItemClickListenerStringPast = listenerString
    }
}