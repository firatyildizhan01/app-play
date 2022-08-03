package com.league2022of.proball.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.core.net.toUri
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.league2022of.proball.adapter.PlayerListAdapter
import com.league2022of.proball.databinding.FragmentTeamPageBinding
import com.league2022of.proball.utils.DataStoreSport
import com.league2022of.proball.viewmodel.CharacterViewModel
import com.league2022of.proball.viewmodel.SharedViewModel
import com.league2022of.proball.viewmodel.SportViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamFragment : Fragment() {

    private lateinit var binding: FragmentTeamPageBinding

    private lateinit var playerListAdapter: PlayerListAdapter

    private val viewModel: CharacterViewModel by viewModels()
    private val sportViewModel: SportViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()


//    private lateinit var dataStore: DataStore<Preferences>

    companion object {
        val IMAGE_REQUEST_CODE = 1_000;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        dataStore = activity!!.createDataStore(name = "settings")
        activity?.let {DataStoreSport().DataStoreFun(it)}

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamPageBinding.inflate(layoutInflater)


        textChangedForEdittext(binding.enterTeamName)

        setupRecyclerView()



        binding.rosterButton.setOnClickListener {
            binding.rosterButton.setBackgroundColor(Color.parseColor("#00A027"))
            binding.reserveButton.setBackgroundColor(Color.parseColor("#C7C7C7"))
            sharedViewModel.roster.value = 1
            setupRecyclerView()
        }

        binding.reserveButton.setOnClickListener {
            binding.rosterButton.setBackgroundColor(Color.parseColor("#C7C7C7"))
            binding.reserveButton.setBackgroundColor(Color.parseColor("#00A027"))
            sharedViewModel.roster.value = 0
            setupRecyclerView()
        }

        playerListAdapter.setOnItemClickListenerString { roster ->
            playerListAdapter.setOnItemClickListenerStringId { id ->

                if(roster == "0"){
                    sportViewModel.updatePlayer(id.toInt(),"1")
                }
                else {
                    sportViewModel.updatePlayer(id.toInt(),"0")
                }
            }
        }

//        countryAdapter.setOnItemClickListenerIntCountry {
//
//            sharedViewModel.countryId.value = it.toString()
//        }

//        binding.selectAllCountries.setOnClickListener {
//
//            sharedViewModel.countryId.value = "0"
//            findNavController().navigate(CountryFragmentDirections.actionCountryFragmentToMatchListFragment())
//        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.imageAddTeam.setOnClickListener {
            pickImageFromGallery()
            binding.imageBackground.visibility = View.VISIBLE
            binding.imageCardView.visibility = View.VISIBLE
            binding.imageAddTeam.visibility = View.INVISIBLE
        }

        binding.teamName.setOnClickListener {
            binding.teamName.visibility = View.INVISIBLE
            binding.enterTeamName.visibility = View.VISIBLE

        }

        sportViewModel.allEvents.observe(requireActivity()) { selectedsports ->
            binding.winText.text = selectedsports.filter { it.resultText == "WIN" }.size.toString()
            binding.lostText.text = selectedsports.filter { it.resultText == "LOSE" }.size.toString()
            binding.drawText.text = selectedsports.filter { it.resultText == "DRAW" }.size.toString()
        }

        lifecycleScope.launch {
//            val value = read("hello")
            val value = DataStoreSport().read("hello")

            binding.teamName.text = value ?: "Nickname"
        }

        lifecycleScope.launch {
//            val valueUri = read("saveuri")
            val valueUri = DataStoreSport().read("saveuri")

            if (valueUri != null) {
                binding.imageIcon.setImageURI(valueUri.toUri())
            }
        }

        lifecycleScope.launch {
//            val valueUri = read("saveuri")
            val dataImage = DataStoreSport().read("saveuri")

            if (dataImage != null) {
                binding.imageAddTeam.visibility = View.INVISIBLE
                binding.imageBackground.visibility = View.VISIBLE
                binding.imageCardView.visibility = View.VISIBLE
            }
        }

        binding.imageCardView.setOnClickListener{

            pickImageFromGallery()
        }




//        binding.countriesLayout.setOnClickListener {
//
//            binding.countryRecyclerview.visibility = View.VISIBLE
//        }
    }

    private fun setupRecyclerView() {
        playerListAdapter = PlayerListAdapter()

        binding.teamRecyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = playerListAdapter
        }

        sportViewModel.allPlayer.observe(requireActivity()) { selectedsports ->

            if(sharedViewModel.roster.value == 0){
                playerListAdapter.sportList = selectedsports.filter { it.roster == "0" }
            }
            else{
                playerListAdapter.sportList = selectedsports.filter { it.roster == "1" }

            }

        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.type = "image/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivityForResult(intent, NewGameFragment.IMAGE_REQUEST_CODE)
    }

//    suspend fun save(key: String, value: String) {
//        val dataStoreKey = preferencesKey<String>(key)
//        dataStore.edit { settings ->
//            settings[dataStoreKey] = value
//        }
//    }
//
//    suspend fun read(key: String): String? {
//        val dataStoreKey = preferencesKey<String>(key)
//        val preferences = dataStore.data.first()
//        return preferences[dataStoreKey]
//    }

    fun textChangedForEdittext(editText: EditText) {
        editText.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.teamName.text = editText.text

                sharedViewModel.nickName.value = editText.text.toString()

                lifecycleScope.launch {
//                    save(
//                        "hello",
//                        editText.text.toString()
//                    )
                    DataStoreSport().save("hello",editText.text.toString())

                }

                binding.teamName.visibility = View.VISIBLE
                binding.enterTeamName.visibility = View.INVISIBLE
                return@OnEditorActionListener true
            }

            false
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NewGameFragment.IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.data?.let { activity?.getContentResolver()
                ?.takePersistableUriPermission(it, Intent.FLAG_GRANT_READ_URI_PERMISSION) }
            binding.imageIcon.setImageURI(data?.data)
            sharedViewModel.uri.value = data?.data.toString()

//            lifecycleScope.launch {
//                save(
//                    "saveuri",
//                    data?.data.toString()
//                )
//            }

            lifecycleScope.launch {
//                DataStore().save(
//                    "saveuri",
//                    data?.data.toString()
//                )
                DataStoreSport().save("saveuri",data?.data.toString())
            }

        }
    }}

