package com.league2022of.proball.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.league2022of.proball.adapter.SportAdapter
import com.league2022of.proball.model.ListModel
import com.league2022of.proball.viewmodel.CharacterViewModel
import com.league2022of.proball.viewmodel.SharedViewModel
import com.league2022of.proball.viewmodel.SportViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.navigation.fragment.findNavController
import com.league2022of.proball.R
import com.league2022of.proball.databinding.FragmentNewGameBinding

@AndroidEntryPoint
class NewGameFragment : Fragment() {

    private lateinit var binding: FragmentNewGameBinding
    var listNew = listOf<ListModel>()
    private lateinit var sportAdapter: SportAdapter
    private val viewModel: CharacterViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val sportViewModel: SportViewModel by viewModels()

//    val team1 = MutableLiveData<Int>(0)
//    val team2 = MutableLiveData<Int>(0)

    private lateinit var dataStore: DataStore<Preferences>


    companion object {
        val IMAGE_REQUEST_CODE = 1_000;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataStore = activity!!.createDataStore(name = "settings")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewGameBinding.inflate(layoutInflater)

//        viewModel.loadingSpor.observe(viewLifecycleOwner){
//
//            if(it == true){
//                binding.progressBar2.visibility = View.INVISIBLE
//            }
//        }

//        setupRecyclerView()

//        val df: DateFormat = SimpleDateFormat("dd/MM")
//        val date: String = df.format(Calendar.getInstance().time)

//        val date: String = SimpleDateFormat("dd/MM", Locale.getDefault()).format(Date())
//
//        binding.textCalendar.text = date
//
//        binding.progressBar.max = 100
//
//        textChangedForEdittext(binding.textEditName)
//
//        binding.textNickName.setOnClickListener {
//
//            binding.textEditName.visibility = View.VISIBLE
//            binding.textNickName.visibility = View.INVISIBLE
//        }

//        textChangedForEdittext(binding.textEditName)

//        sportViewModel.allEvents.observe(requireActivity()) { selectedsports ->
//            binding.levelText.text = "LVL : ${selectedsports.filter { it.win.toString() == "1" }.size/5}"
//            binding.progressBar.progress = selectedsports.filter { it.win.toString() == "1" }.size
//
//        }
//
//        sportViewModel.allEvents.observe(requireActivity()) { selectedsports ->
//            binding.matchesText.text = "Matches : ${selectedsports.size}"
//        }
//
//        sportViewModel.allEvents.observe(requireActivity()) { selectedsports ->
//            binding.winsText.text = "Wins : ${selectedsports.filter { it.win.toString() == "1" }.size}"
//        }
//
//        binding.imageView3.setOnClickListener {
//
//            pickImageFromGallery()
//        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Handler().postDelayed({
//            var randomOne = (0..2).random()
//            var randomTwo = (0..2).random()
//
//            team1.value = team1.value?.plus(randomOne)
//            team2.value = team2.value?.plus(randomTwo)
//
//            binding.
//
//
//        }, 1000)

        binding.startGameButtonVisible.setOnClickListener {

            findNavController().navigate(R.id.action_matchListFragment_to_detailFragment)


        }

//        lifecycleScope.launch {
//            val value = read("hello")
//            binding.textNickName.text = value ?: "Nickname"
//        }
//
//        lifecycleScope.launch {
//            val valueUri = read("saveuri")
//
//            if(valueUri != null){
//                binding.imageView3.setImageURI(valueUri.toUri())
//            }
//        }

//                    binding.textNickName.text = sharedViewModel.nickName.value
//
//
//        if(sharedViewModel.uri.value != ""){
//            binding.imageView3.setImageURI(sharedViewModel.uri.value?.toUri())
//        }

    }}

//    private fun setupRecyclerView() {
//
//        sportAdapter = SportAdapter()
//
//        binding.recyclerviewMatchList.apply {
//            layoutManager = LinearLayoutManager(requireContext())
//            adapter = sportAdapter
//        }
//
//        viewModel.getTournaments(sharedViewModel.sportId.value.toString(),sharedViewModel.countryId.value.toString())
//
//        viewModel.sportResponseTournament.observe(requireActivity()) { tournamet ->
//
//            var tournamentFirst = tournamet.body.elementAtOrNull(0)
//
////            sharedViewModel.sportId.value?.let { viewModel.getSpors(it,
////                tournamentFirst?.id.toString()
////            ) }
//
////            sharedViewModel.sportId.value?.let { viewModel.getSpors(it,
////                tournamentFirst?.id.toString()
////            ) }
//
//            if( sharedViewModel.countryId.value == "0" ){
//                viewModel.getSpors(sharedViewModel.sportId.value.toString(),"0")
//            }
//             else if (tournamentFirst != null) {
//                viewModel.getSpors(sharedViewModel.sportId.value.toString(),tournamentFirst.id.toString())
//            }
//            else{
//                viewModel.getSpors(sharedViewModel.sportId.value.toString(),"0")
//
//            }
//
////            viewModel.getSpors("0","0")
//
//        }
//
//        viewModel.sportResponse.observe(viewLifecycleOwner){
//
//            var y = it.body
//
//            if(it.body.size != null){
//                sportAdapter.sportList = it.body
//            }
//        }
//    }

//    private fun pickImageFromGallery() {
//        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
//        intent.type = "image/*"
//        intent.addCategory(Intent.CATEGORY_OPENABLE)
//        intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//        startActivityForResult(intent, IMAGE_REQUEST_CODE)
//    }

//    fun textChangedForEdittext(editText: EditText) {
//        editText.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
//            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                binding.textNickName.text = editText.text
//
//                sharedViewModel.nickName.value = editText.text.toString()
//
//                lifecycleScope.launch {
//                    save(
//                        "hello",
//                        editText.text.toString()
//                    )
//                }
//
//                binding.textNickName.visibility = View.VISIBLE
//                binding.textEditName.visibility = View.INVISIBLE
//                return@OnEditorActionListener true
//            }
//
//            false
//        })
//    }

//     suspend fun save(key: String, value: String) {
//        val dataStoreKey = preferencesKey<String>(key)
//        dataStore.edit { settings ->
//            settings[dataStoreKey] = value
//        }
//    }
//
//     suspend fun read(key: String): String? {
//        val dataStoreKey = preferencesKey<String>(key)
//        val preferences = dataStore.data.first()
//        return preferences[dataStoreKey]
//    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
//            data?.data?.let { activity?.getContentResolver()
//                ?.takePersistableUriPermission(it, Intent.FLAG_GRANT_READ_URI_PERMISSION) }
//            binding.imageView3.setImageURI(data?.data)
//            sharedViewModel.uri.value = data?.data.toString()
//
//            lifecycleScope.launch {
//                save(
//                    "saveuri",
//                    data?.data.toString()
//                )
//        }
//    }
//}}