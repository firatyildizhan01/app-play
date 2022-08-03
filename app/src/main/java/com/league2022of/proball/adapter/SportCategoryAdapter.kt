package com.league2022of.proball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.league2022of.proball.databinding.CardCountryCategoryBinding
import com.league2022of.proball.fragments.MainPageFragmentDirections
import com.league2022of.proball.model.BodySportCategories

class SportCategoryAdapter : RecyclerView.Adapter<SportCategoryAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(val binding: CardCountryCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<BodySportCategories>() {

        override fun areItemsTheSame(oldItem: BodySportCategories, newItem: BodySportCategories): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BodySportCategories, newItem: BodySportCategories): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)
    var sportCategoryList: List<BodySportCategories>
        get() = differ.currentList
        set(value) { differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {

        return ToDoViewHolder(
            CardCountryCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false

            )
        )
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val currentToDo = sportCategoryList[position]

        holder.binding.apply {
            currentToDo
            countryOrCategoryText.text = currentToDo.name_en


            cardCategories.setOnClickListener {

                onItemClickListenerString?.let { currentToDo.id?.let { it1 -> it(it1) } }

                Navigation.findNavController(it).navigate(MainPageFragmentDirections.actionSportCategoryFragmentToCountryFragment())
            }

        }
    }

    override fun getItemCount() = sportCategoryList.size

    private var onItemClickListenerString: ((Int) -> Unit)? = null

    fun setOnItemClickListenerString(listenerString: (Int) -> Unit) {
        onItemClickListenerString = listenerString
    }
}