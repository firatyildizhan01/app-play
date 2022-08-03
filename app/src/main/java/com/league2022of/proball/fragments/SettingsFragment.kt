package com.league2022of.proball.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.league2022of.proball.adapter.SportSelectedAdapter
import com.league2022of.proball.databinding.FragmentSettingsBinding
import com.league2022of.proball.viewmodel.CharacterViewModel
import com.league2022of.proball.viewmodel.SharedViewModel
import com.league2022of.proball.viewmodel.SportViewModel
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