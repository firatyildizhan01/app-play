package com.league2022of.proball.fragments

import android.R
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.league2022of.proball.databinding.FragmentGameVictoryBinding
import com.league2022of.proball.model.ListModel
import com.league2022of.proball.utils.DataStoreSport
import com.league2022of.proball.viewmodel.CharacterViewModel
import com.league2022of.proball.viewmodel.SportViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameVictoryBinding

    var teamSelectNumber = 0

    private val sportViewModel : SportViewModel by viewModels()
    private val characterViewModel : CharacterViewModel by viewModels()

//    private val arguments : DetailFragmentArgs by navArgs()

    val team1 = MutableLiveData<Int>(0)
    val team2 = MutableLiveData<Int>(0)

    var resultTextDetail = ""

    var resultTextDetailforCat = ""

    var randomOppositeTeam = 0

    var oppositeTeamName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { DataStoreSport().DataStoreFun(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGameVictoryBinding.inflate(layoutInflater)

        activity?.let {
            characterViewModel.spoyerResponse.observe(it) { spor ->

                var u = spor.games_live.size


                var randomTeam = Random().nextInt(spor.games_live.size)

                var spoyerModels = spor.games_live.elementAtOrNull(randomTeam)?.home

                var kata = spoyerModels?.image_id

                Glide.with(binding.root)
                    .load("https://spoyer.com/api/team_img/soccer/${spoyerModels?.image_id}.png")
                    .centerCrop()
                    .into(binding.textView9)

                oppositeTeamName = spoyerModels?.name ?: "Team 1"

                binding.textView10.text = oppositeTeamName
            }
        }

//        binding.backgroundFirst.setOnClickListener{
//            binding.backgroundFirst.setBackgroundColor(Color.parseColor("#FFE9BF"));
//            binding.backgroundSecond.setBackgroundColor(Color.parseColor("#FFFFFF"))
//            teamSelectNumber = 0
//        }
//
//        binding.backgroundSecond.setOnClickListener{
//            binding.backgroundSecond.setBackgroundColor(Color.parseColor("#FFE9BF"));
//            binding.backgroundFirst.setBackgroundColor(Color.parseColor("#FFFFFF"));
//            teamSelectNumber = 1
//
//        }

//        val date = Date((arguments.idModel?.game_start ?: 0) * 1000L)
//        val format: DateFormat = SimpleDateFormat("dd.MM")
//        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"))
//        val formatted: String = format.format(date)

//            binding.textviewCalender.text = formatted
//            binding.textFirstTeamName.text = arguments.idModel.opp_1_name_en
//            binding.textSecondTeamName.text = arguments.idModel.opp_2_name_en
//            binding.winFirstScore.text = arguments.idModel.game_oc_list.elementAtOrNull(0)?.oc_rate.toString()
//            binding.winSecondScore.text = arguments.idModel.game_oc_list.elementAtOrNull(1)?.oc_rate.toString()
////            binding.matchScore.text = arguments.idModel.score
//
//        Glide.with(activity!!).load("https://cdn.incub.space/v1/opp/icon/${arguments.idModel.opp_1_icon}.png").into(binding.imageTeamOne)
//        Glide.with(activity!!).load("https://cdn.incub.space/v1/opp/icon/${arguments.idModel.opp_2_icon}.png").into(binding.imageTeamSecond)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mProgressBar: ProgressBar
        val mCountDownTimer: CountDownTimer
        var i = 0

        randomOppositeTeam = Random().nextInt(500)



        lifecycleScope.launch {
//            val value = read("hello")
            val value = DataStoreSport().read("hello")

            binding.teamOneText.text = value ?: "Nickname"
        }


        lifecycleScope.launch {
//            val valueUri = read("saveuri")
            val valueUri = DataStoreSport().read("saveuri")

            if (valueUri != null) {
                binding.imageIcon.setImageURI(valueUri.toUri())
            }
        }


        binding.progressBarGameVictory.progress = i
        mCountDownTimer = object : CountDownTimer(16000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.v("Log_tag", "Tick of Progress$i$millisUntilFinished")
                i++
                binding.progressBarGameVictory.progress = i * 100 / (17000 / 1000)
            }

            override fun onFinish() {
                //Do what you want
                if(team1.value!! > team2.value!!){
                    resultTextDetail = "VICTORY!"
                    resultTextDetailforCat = "WIN"
                    binding.textView6.text = resultTextDetail
                    binding.imageNewGame.visibility = View.VISIBLE
                }

                else if(team1.value!! < team2.value!!){
                    resultTextDetail = "LOSE..."
                    resultTextDetailforCat = "LOSE"
                    binding.textView6.text = resultTextDetail
                    binding.imageGoToMenu.visibility = View.VISIBLE
                    binding.imageStart.visibility = View.VISIBLE
                }

                else {
                    resultTextDetail = "DRAW"
                    resultTextDetailforCat = "DRAW"
                    binding.textView6.text = resultTextDetail
                    binding.imageGoToMenu.visibility = View.VISIBLE
                    binding.imageStart.visibility = View.VISIBLE
                }


                i++
                binding.progressBarGameVictory.progress = 100

                lifecycleScope.launch {
//            val valueUri = read("saveuri")
                    var valueUri = DataStoreSport().read("hello").toString()

                    sportViewModel.insertEvents(
                        ListModel(
                            0,
                            valueUri,
                            oppositeTeamName,
                            team1.value.toString(),
                            team2.value.toString(),
                            resultTextDetailforCat
                        )
                    )
                }
            }
        }

        mCountDownTimer.start()

        Handler().postDelayed({
            var randomOne = (0..1).random()
            var randomTwo = (0..1).random()

            team1.value = team1.value?.plus(randomOne)
            team2.value = team2.value?.plus(randomTwo)

            binding.firstTeamResult.text = team1.value.toString()
            binding.SecondTeamResult.text = team2.value.toString()


        }, 3000)

        Handler().postDelayed({
            var randomOne = (0..1).random()
            var randomTwo = (0..1).random()

            team1.value = team1.value?.plus(randomOne)
            team2.value = team2.value?.plus(randomTwo)

            binding.firstTeamResult.text = team1.value.toString()
            binding.SecondTeamResult.text = team2.value.toString()

        }, 6000)

        Handler().postDelayed({
            var randomthree = (0..1).random()
            var randomfour = (0..1).random()

            team1.value = team1.value?.plus(randomthree)
            team2.value = team2.value?.plus(randomfour)

            binding.firstTeamResult.text = team1.value.toString()
            binding.SecondTeamResult.text = team2.value.toString()

        }, 9000)

        Handler().postDelayed({
            var randomfive = (0..1).random()
            var randomsix = (0..1).random()

            team1.value = team1.value?.plus(randomfive)
            team2.value = team2.value?.plus(randomsix)

            binding.firstTeamResult.text = team1.value.toString()
            binding.SecondTeamResult.text = team2.value.toString()

        }, 15000)

        binding.imageGoToMenu.setOnClickListener {

            findNavController().navigate(com.league2022of.proball.R.id.action_detailFragment_to_sportCategoryFragment)

        }

        binding.imageNewGame.setOnClickListener {

            findNavController().navigate(GameFragmentDirections.actionDetailFragmentToMyMatchesFragment(randomOppositeTeam.toString()))

        }

        binding.imageStart.setOnClickListener {

            findNavController().navigate(com.league2022of.proball.R.id.action_detailFragment_to_matchListFragment)
        }
    }
}