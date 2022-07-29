package com.football.challengemyteams.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.football.challengemyteams.databinding.FragmentDetailBinding
import com.football.challengemyteams.model.ListModel
import com.football.challengemyteams.viewmodel.SportViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    var teamSelectNumber = 0

    private val sportViewModel : SportViewModel by viewModels()

    private val arguments : DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(layoutInflater)

        binding.backgroundFirst.setOnClickListener{
            binding.backgroundFirst.setBackgroundColor(Color.parseColor("#FFE9BF"));
            binding.backgroundSecond.setBackgroundColor(Color.parseColor("#FFFFFF"))
            teamSelectNumber = 0
        }

        binding.backgroundSecond.setOnClickListener{
            binding.backgroundSecond.setBackgroundColor(Color.parseColor("#FFE9BF"));
            binding.backgroundFirst.setBackgroundColor(Color.parseColor("#FFFFFF"));
            teamSelectNumber = 1

        }

        val date = Date((arguments.idModel?.game_start ?: 0) * 1000L)
        val format: DateFormat = SimpleDateFormat("dd.MM")
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"))
        val formatted: String = format.format(date)

            binding.textviewCalender.text = formatted
            binding.textFirstTeamName.text = arguments.idModel.opp_1_name_en
            binding.textSecondTeamName.text = arguments.idModel.opp_2_name_en
            binding.winFirstScore.text = arguments.idModel.game_oc_list.elementAtOrNull(0)?.oc_rate.toString()
            binding.winSecondScore.text = arguments.idModel.game_oc_list.elementAtOrNull(1)?.oc_rate.toString()
//            binding.matchScore.text = arguments.idModel.score

        Glide.with(activity!!).load("https://cdn.incub.space/v1/opp/icon/${arguments.idModel.opp_1_icon}.png").into(binding.imageTeamOne)
        Glide.with(activity!!).load("https://cdn.incub.space/v1/opp/icon/${arguments.idModel.opp_2_icon}.png").into(binding.imageTeamSecond)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButtonDetail.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMatchListFragment3())
        }

        binding.imageSelectTeamButton.setOnClickListener {

            val date = Date((arguments.idModel?.game_start ?: 0) * 1000L)
            val format: DateFormat = SimpleDateFormat("yyyyMMdd")
            format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"))
            val formattedDay: String = format.format(date)

            sportViewModel.insertEvents(ListModel(
                0,
                arguments.idModel.opp_1_name_en,
                arguments.idModel.opp_2_name_en,
                arguments.idModel.game_oc_list.elementAtOrNull(0)?.oc_rate.toString(),
                arguments.idModel.game_oc_list.elementAtOrNull(1)?.oc_rate.toString(),
                formattedDay,
                arguments.idModel.score_full,
                teamSelectNumber,
            0
            ))

//            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMyMatchesFragment())
        }
    }

}