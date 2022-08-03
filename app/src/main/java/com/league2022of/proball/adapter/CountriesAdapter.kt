package com.league2022of.proball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.league2022of.proball.databinding.CardCountryCategoryBinding
import com.league2022of.proball.fragments.TeamFragmentDirections
import com.league2022of.proball.model.BodyCountries

class CountriesAdapter : RecyclerView.Adapter<CountriesAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(val binding: CardCountryCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<BodyCountries>() {

        override fun areItemsTheSame(oldItem: BodyCountries, newItem: BodyCountries): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BodyCountries, newItem: BodyCountries): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)
    var countryList: List<BodyCountries>
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
        val currentToDo = countryList[position]

        holder.binding.apply {
            currentToDo
            countryOrCategoryText.text = currentToDo.name_en

            cardCategories.setOnClickListener {

                onItemClickListenerIntCountry?.let { currentToDo.id?.let { it1 -> it(it1) } }

                Navigation.findNavController(it).navigate(TeamFragmentDirections.actionCountryFragmentToMatchListFragment())
            }

//            cardSport.setOnClickListener {
//                Navigation.findNavController(it).navigate(SecondFragmentDirections.actionSecondFragmentToDetailFragment2(currentToDo))
//            }
        }
    }

    override fun getItemCount() = countryList.size

    private var onItemClickListenerIntCountry: ((Int) -> Unit)? = null

    fun setOnItemClickListenerIntCountry(listenerInt: (Int) -> Unit) {
        onItemClickListenerIntCountry = listenerInt
    }
}