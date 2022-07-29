package com.football.challengemyteams.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.football.challengemyteams.adapter.SportSelectedAdapter
import com.football.challengemyteams.databinding.FragmentSettingsBinding
import com.football.challengemyteams.viewmodel.CharacterViewModel
import com.football.challengemyteams.viewmodel.SharedViewModel
import com.football.challengemyteams.viewmodel.SportViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    private lateinit var sportSelectedAdapter : SportSelectedAdapter

    private val viewModel: CharacterViewModel by viewModels()

    private val sportViewModel: SportViewModel by viewModels()

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.countriesLayout.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToSportCategoryFragment())
        }

        binding.countriesLayout2.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToSportCategoryFragment())
        }

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}