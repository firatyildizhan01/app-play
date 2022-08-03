package com.league2022of.proball.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.league2022of.proball.R
import com.league2022of.proball.adapter.SportPastAdapter
import com.league2022of.proball.adapter.SportSelectedAdapter
import com.league2022of.proball.databinding.FragmentNewPlayerBinding
import com.league2022of.proball.model.PlayerModel
import com.league2022of.proball.utils.DataStoreSport
import com.league2022of.proball.viewmodel.CharacterViewModel
import com.league2022of.proball.viewmodel.SharedViewModel
import com.league2022of.proball.viewmodel.SportViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class NewPlayerFragment : Fragment() {

    private lateinit var binding: FragmentNewPlayerBinding

    private lateinit var sportSelectedAdapter : SportSelectedAdapter

    private lateinit var sportPastAdapter : SportPastAdapter

    private val viewModel: CharacterViewModel by viewModels()

    private val sportViewModel: SportViewModel by viewModels()

    private val sharedViewModel: SharedViewModel by activityViewModels()

    var teamName = ""

    private val arguments : NewPlayerFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { DataStoreSport().DataStoreFun(it) }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewPlayerBinding.inflate(layoutInflater)

//        setupRecyclerView()
//        setupRecyclerViewPast()

//        sportPastAdapter.setOnItemClickListenerStringPast {
//            sportViewModel.updateEvents(it,"1")
//        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var attack = (1..3).random()
        var defence = (1..3).random()
        var goalie = (1..3).random()


        Glide.with(binding.root)
            .load("https://spoyer.com/api/team_img/soccer/${arguments.imageId}.png")
            .centerCrop()
            .into(binding.imageView22)


        when (attack) {
            1 -> binding.imageAttack1.setImageResource(R.drawable.ic_foot_yellow_ball)
            2 -> {
                binding.imageAttack1.setImageResource(R.drawable.ic_foot_yellow_ball)
                binding.imageAttack2.setImageResource(R.drawable.ic_foot_yellow_ball)
            }
            else -> {
                binding.imageAttack1.setImageResource(R.drawable.ic_foot_yellow_ball)
                binding.imageAttack2.setImageResource(R.drawable.ic_foot_yellow_ball)
                binding.imageAttack3.setImageResource(R.drawable.ic_foot_yellow_ball)
            }
        }

        when (defence) {
            1 -> binding.imageDefence1.setImageResource(R.drawable.ic_foot_yellow_ball)
            2 -> {
                binding.imageDefence1.setImageResource(R.drawable.ic_foot_yellow_ball)
                binding.imageDefence2.setImageResource(R.drawable.ic_foot_yellow_ball)
            }
            else -> {
                binding.imageDefence1.setImageResource(R.drawable.ic_foot_yellow_ball)
                binding.imageDefence2.setImageResource(R.drawable.ic_foot_yellow_ball)
                binding.imageDefence3.setImageResource(R.drawable.ic_foot_yellow_ball)
            }
        }

        when (goalie) {
            1 -> binding.imageGoalie1.setImageResource(R.drawable.ic_foot_yellow_ball)
            2 -> {
                binding.imageGoalie1.setImageResource(R.drawable.ic_foot_yellow_ball)
                binding.imageGoalie2.setImageResource(R.drawable.ic_foot_yellow_ball)
            }
            else -> {
                binding.imageGoalie1.setImageResource(R.drawable.ic_foot_yellow_ball)
                binding.imageGoalie2.setImageResource(R.drawable.ic_foot_yellow_ball)
                binding.imageGoalie3.setImageResource(R.drawable.ic_foot_yellow_ball)
            }
        }

        lifecycleScope.launch {
//            val value = read("hello")
            val value = DataStoreSport().read("hello")

            teamName = value ?: "Nickname"
        }


        sportViewModel.insertPlayer(PlayerModel(
            0,
            arguments.imageId,
            teamName,
            attack.toString(),
            defence.toString(),
            goalie.toString(),
            "fiko",
            "0"
        ))

        Handler().postDelayed({

            findNavController().navigate(NewPlayerFragmentDirections.actionMyMatchesFragmentToPrivacyPolicyFragment(PlayerModel(
                0,
                arguments.imageId,
                teamName,
                attack.toString(),
                defence.toString(),
                goalie.toString(),
                "fiko",
                "0"
            )))

        }, 3000)


    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()

    }
//
//    private fun setupRecyclerView() {
//        sportSelectedAdapter = SportSelectedAdapter()
//
//        val date: String = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date())
//
//        binding.futureRecyclerView.apply {
//            layoutManager = LinearLayoutManager(requireContext())
//            adapter = sportSelectedAdapter
//        }
//
////        sportViewModel.allEvents.observe(requireActivity()) { selectedsports ->
////            sportSelectedAdapter.sportList = selectedsports.filter { it.calendar == date  }
////        }
//    }
//
//    private fun setupRecyclerViewPast() {
//
//        sportPastAdapter = SportPastAdapter()
//
//        val date: String = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date())
//
//        binding.pastWatches.apply {
//            layoutManager = LinearLayoutManager(requireContext())
//            adapter = sportPastAdapter
//        }

//        sportViewModel.allEvents.observe(requireActivity()) { selectedsports ->
//            sportPastAdapter.sportList = selectedsports.filter { it.calendar != date  }
//        }
    }