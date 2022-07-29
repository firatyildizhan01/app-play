package com.football.challengemyteams.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.football.challengemyteams.adapter.SportPastAdapter
import com.football.challengemyteams.adapter.SportSelectedAdapter
import com.football.challengemyteams.databinding.FragmentMyMatchesBinding
import com.football.challengemyteams.viewmodel.CharacterViewModel
import com.football.challengemyteams.viewmodel.SharedViewModel
import com.football.challengemyteams.viewmodel.SportViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MyMatchesFragment : Fragment() {

    private lateinit var binding: FragmentMyMatchesBinding

    private lateinit var sportSelectedAdapter : SportSelectedAdapter

    private lateinit var sportPastAdapter : SportPastAdapter

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
        binding = FragmentMyMatchesBinding.inflate(layoutInflater)

        setupRecyclerView()
        setupRecyclerViewPast()

        sportPastAdapter.setOnItemClickListenerStringPast {
            sportViewModel.updateEvents(it,"1")
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun setupRecyclerView() {
        sportSelectedAdapter = SportSelectedAdapter()

        val date: String = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date())

        binding.futureRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = sportSelectedAdapter
        }

        sportViewModel.allEvents.observe(requireActivity()) { selectedsports ->
            sportSelectedAdapter.sportList = selectedsports.filter { it.calendar == date  }
        }
    }

    private fun setupRecyclerViewPast() {

        sportPastAdapter = SportPastAdapter()

        val date: String = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date())

        binding.pastWatches.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = sportPastAdapter
        }

        sportViewModel.allEvents.observe(requireActivity()) { selectedsports ->
            sportPastAdapter.sportList = selectedsports.filter { it.calendar != date  }
        }
    }
}