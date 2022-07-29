package com.football.challengemyteams.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.football.challengemyteams.adapter.CountriesAdapter
import com.football.challengemyteams.databinding.FragmentCountryBinding
import com.football.challengemyteams.viewmodel.CharacterViewModel
import com.football.challengemyteams.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryFragment : Fragment() {

    private lateinit var binding: FragmentCountryBinding
    private lateinit var countryAdapter: CountriesAdapter

    private val viewModel: CharacterViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountryBinding.inflate(layoutInflater)

        setupRecyclerView()

        countryAdapter.setOnItemClickListenerIntCountry {

            sharedViewModel.countryId.value = it.toString()
        }

        binding.selectAllCountries.setOnClickListener {

            sharedViewModel.countryId.value = "0"
            findNavController().navigate(CountryFragmentDirections.actionCountryFragmentToMatchListFragment())
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.countriesLayout.setOnClickListener {

            binding.countryRecyclerview.visibility = View.VISIBLE
        }
    }

    private fun setupRecyclerView() {

        countryAdapter = CountriesAdapter()

        binding.countryRecyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = countryAdapter
        }

        viewModel.getAllCountries(sharedViewModel.sportId.value.toString())

            viewModel.sportResponseCountries.observe(requireActivity()) { countries ->
                var u = countries.body
                countryAdapter.countryList = countries.body
            }
    }

    override fun onPause() {
        super.onPause()
    }
}