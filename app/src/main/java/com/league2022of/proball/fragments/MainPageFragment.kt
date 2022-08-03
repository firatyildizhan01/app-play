package com.league2022of.proball.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.league2022of.proball.R
import com.league2022of.proball.viewmodel.CharacterViewModel
import com.league2022of.proball.viewmodel.SportViewModel
import com.league2022of.proball.adapter.SportSelectedAdapter
import com.league2022of.proball.databinding.FragmentMainPageBinding
import com.league2022of.proball.utils.DataStoreSport
import com.league2022of.proball.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding
    private lateinit var sportSelectedAdapter : SportSelectedAdapter
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

    private lateinit var dataStore: DataStore<Preferences>

    companion object {
        val IMAGE_REQUEST_CODE = 1_000;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { DataStoreSport().DataStoreFun(it)}


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(layoutInflater)

        setupRecyclerView()

//
//        sportcategoryAdapter.setOnItemClickListenerString {
//            sharedViewModel.sportId.value = it.toString()
//        }

        binding.imageView4.setOnClickListener {

            findNavController().navigate(R.id.action_sportCategoryFragment_to_countryFragment)
        }

        binding.startNewGameButton.setOnClickListener {

            findNavController().navigate(R.id.action_sportCategoryFragment_to_matchListFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
//            val value = read("hello")
            val value = DataStoreSport().read("hello")

            binding.textView4.text = value ?: "Nickname"
        }


        lifecycleScope.launch {
//            val valueUri = read("saveuri")
            val valueUri = DataStoreSport().read("saveuri")

            if (valueUri != null) {
                binding.imageView6.setImageURI(valueUri.toUri())
            }
        }


//        if(binding.checkBoxSport.isChecked){
//            sharedViewModel.sportId.value = "0"
//            Log.d("sportlogx","logsport")
//            findNavController().navigate(R.id.action_sportCategoryFragment_to_countryFragment)
//        }
//
//        binding.countriesLayout.setOnClickListener {
//            binding.recyclerviewCategoriesSport.visibility = View.VISIBLE
//
//        }
    }

//    private fun setupRecyclerView() {
//
//        sportSelectedAdapter = SportSelectedAdapter()
//
//        binding.mainPageRecyclerview.apply {
//            layoutManager = LinearLayoutManager(requireContext())
//            adapter = sportSelectedAdapter
//        }
//
//        viewModel.sportResponseCategories.observe(requireActivity()) { categories ->
//            var u = categories.body
//
//            if(categories.body.isNotEmpty()){
//                sportSelectedAdapter.sportList = categories.body
//            }
//        }
//
//    }

    private fun setupRecyclerView() {
        sportSelectedAdapter = SportSelectedAdapter()

        binding.mainPageRecyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = sportSelectedAdapter
        }

        sportViewModel.allEvents.observe(requireActivity()) { selectedsports ->
            sportSelectedAdapter.sportList = selectedsports

            binding.winText.text = selectedsports.filter { it.resultText == "WIN" }.size.toString()
            binding.lostText.text = selectedsports.filter { it.resultText == "LOSE" }.size.toString()
            binding.drawText.text = selectedsports.filter { it.resultText == "DRAW" }.size.toString()
        }
    }


}