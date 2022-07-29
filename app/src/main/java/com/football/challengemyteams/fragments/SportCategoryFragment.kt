package com.football.challengemyteams.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.football.challengemyteams.R
import com.football.challengemyteams.viewmodel.CharacterViewModel
import com.football.challengemyteams.viewmodel.SportViewModel
import com.football.challengemyteams.adapter.SportCategoryAdapter
import com.football.challengemyteams.databinding.FragmentSportCategoryBinding
import com.football.challengemyteams.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SportCategoryFragment : Fragment() {

    private lateinit var binding: FragmentSportCategoryBinding
    private lateinit var sportcategoryAdapter : SportCategoryAdapter
    private val viewModelSport: CharacterViewModel by viewModels()

    var nameOne = ""
    var nameSecond = ""
    var nameRateOne = ""
    var nameRateSecond = ""
    var nameRateThird = ""
    var calendar = ""
    var finishTime = ""
    var imageUrlOne = ""
    var imageUrlSecond = ""
    var score = ""
    var gameid = ""

    private val viewModel: CharacterViewModel by viewModels()
    private val sportViewModel: SportViewModel by viewModels()
    private val sharedViewModel : SharedViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSportCategoryBinding.inflate(layoutInflater)

        setupRecyclerView()

        sportcategoryAdapter.setOnItemClickListenerString {
            sharedViewModel.sportId.value = it.toString()
        }

        binding.selectAllCategory.setOnClickListener {
            sharedViewModel.sportId.value = "0"

            findNavController().navigate(R.id.action_sportCategoryFragment_to_countryFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if(binding.checkBoxSport.isChecked){
            sharedViewModel.sportId.value = "0"
            Log.d("sportlogx","logsport")
            findNavController().navigate(R.id.action_sportCategoryFragment_to_countryFragment)
        }

        binding.countriesLayout.setOnClickListener {
            binding.recyclerviewCategoriesSport.visibility = View.VISIBLE

        }
    }

    private fun setupRecyclerView() {

        sportcategoryAdapter = SportCategoryAdapter()

        binding.recyclerviewCategoriesSport.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = sportcategoryAdapter
        }

        viewModel.sportResponseCategories.observe(requireActivity()) { categories ->
            var u = categories.body
            sportcategoryAdapter.sportCategoryList = categories.body
        }

    }

}