package com.league2022of.proball.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.league2022of.proball.R
import com.league2022of.proball.adapter.CountriesAdapter
import com.league2022of.proball.databinding.FragmentPlayerInfoBinding
import com.league2022of.proball.viewmodel.CharacterViewModel
import com.league2022of.proball.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerInfoFragment : Fragment() {

    private lateinit var binding: FragmentPlayerInfoBinding

    private lateinit var countryAdapter: CountriesAdapter

    private val viewModel: CharacterViewModel by viewModels()

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val arguments : PlayerInfoFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerInfoBinding.inflate(layoutInflater)

        binding.textView4.text = arguments.playerModel.playerName

//        Glide.with(binding.root)
//            .load("https://spoyer.com/api/team_img/soccer/${arguments.playerModel.imageUrl}.png")
//            .centerCrop()
//            .into(binding.imageView4)

        binding.imageView4.setImageResource(arguments.playerModel.imageUrl)


        when (arguments.playerModel.attack?.toInt()) {
            1 -> binding.imageAttack1.setImageResource(R.drawable.ic_foot_green_ball)
            2 -> {
                binding.imageAttack1.setImageResource(R.drawable.ic_foot_green_ball)
                binding.imageAttack2.setImageResource(R.drawable.ic_foot_green_ball)
            }
            else -> {
                binding.imageAttack1.setImageResource(R.drawable.ic_foot_green_ball)
                binding.imageAttack2.setImageResource(R.drawable.ic_foot_green_ball)
                binding.imageAttack3.setImageResource(R.drawable.ic_foot_green_ball)
            }
        }

        when (arguments.playerModel.defence?.toInt()) {
            1 -> binding.imageDefence1.setImageResource(R.drawable.ic_foot_green_ball)
            2 -> {
                binding.imageDefence1.setImageResource(R.drawable.ic_foot_green_ball)
                binding.imageDefence2.setImageResource(R.drawable.ic_foot_green_ball)
            }
            else -> {
                binding.imageDefence1.setImageResource(R.drawable.ic_foot_green_ball)
                binding.imageDefence2.setImageResource(R.drawable.ic_foot_green_ball)
                binding.imageDefence3.setImageResource(R.drawable.ic_foot_green_ball)
            }
        }

        when (arguments.playerModel.goalie?.toInt()) {
            1 -> binding.imageGoalie1.setImageResource(R.drawable.ic_foot_green_ball)
            2 ->
            {
                binding.imageGoalie1.setImageResource(R.drawable.ic_foot_green_ball)
                binding.imageGoalie2.setImageResource(R.drawable.ic_foot_green_ball)
            }
            else -> {
                binding.imageGoalie1.setImageResource(R.drawable.ic_foot_green_ball)
                binding.imageGoalie2.setImageResource(R.drawable.ic_foot_green_ball)
                binding.imageGoalie3.setImageResource(R.drawable.ic_foot_green_ball)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}