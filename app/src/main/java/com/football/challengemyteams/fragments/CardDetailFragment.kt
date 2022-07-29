package com.football.challengemyteams.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.football.challengemyteams.adapter.CountriesAdapter
import com.football.challengemyteams.databinding.FragmentCardDetailBinding
import com.football.challengemyteams.viewmodel.CharacterViewModel
import com.football.challengemyteams.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardDetailFragment : Fragment() {

    private lateinit var binding: FragmentCardDetailBinding

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
        binding = FragmentCardDetailBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}