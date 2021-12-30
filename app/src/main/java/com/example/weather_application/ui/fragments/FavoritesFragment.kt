package com.example.weather_application.ui.fragments

import android.content.Context
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.weather_application.data.base.BaseFragment
import com.example.weather_application.databinding.FragmentFavoritesBinding
import com.example.weather_application.domain.dto.City
import com.example.weather_application.domain.dto.Direct
import com.example.weather_application.ui.MainViewModel
import com.example.weather_application.ui.adapters.DirectAdapter
import com.example.weather_application.ui.adapters.FavoritesAdapter


class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    private val viewModel: MainViewModel by activityViewModels()
    private val cities = mutableListOf<Pair<City, Boolean>>()


    override fun getViewBinding(): FragmentFavoritesBinding =
        FragmentFavoritesBinding.inflate(layoutInflater)

    override fun setUpObservers() {

        viewModel.cities.observe(this, Observer { list ->
            cities.clear()
            list.forEach {
                cities.add(Pair(it, false))
            }
            (binding.recyclerView.adapter as FavoritesAdapter).submitList(cities)
            initialState()
        })

        viewModel.directions.observe(this, Observer {
            binding.recyclerViewSearch.visibility = View.VISIBLE
            binding.recyclerView.visibility = View.GONE
            (binding.recyclerViewSearch.adapter as DirectAdapter).submitList(it)
        })

    }

    override fun setUpViews() {

        binding.recyclerView.adapter = FavoritesAdapter(this@FavoritesFragment::onDeleteItem)
        binding.recyclerViewSearch.adapter = DirectAdapter(this@FavoritesFragment::onItemClick)

        binding.search.doOnTextChanged { text, _, _, _ ->
            text?.let {
                if (it.isNotEmpty()) {
                    viewModel.loadDirections(it.toString())
                } else {
                    hideSoftKeyboard()
                    initialState()
                }
            }

        }

        binding.search.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                hideSoftKeyboard()
                true
            } else {
                false
            }
        }

        binding.search.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                (binding.recyclerView.adapter as FavoritesAdapter).submitList(cities.map { Pair(it.first, false) }.toMutableList())

        }

        binding.imageButtonEdit.setOnClickListener {
            (binding.recyclerView.adapter as FavoritesAdapter).submitList(cities.map { Pair(it.first, true) }.toMutableList())
        }

        binding.recyclerView.setOnClickListener {
            binding.search.clearFocus()
            print("fjrihguirhgiurghuyghuygrgrhg")
        }

    }

    private fun onItemClick(direct: Direct) {
        (binding.recyclerView.adapter as FavoritesAdapter).submitList(cities.map { Pair(it.first, false) }.toMutableList())
        viewModel.addWeather(direct)
        binding.search.text.clear()
    }

    private fun onDeleteItem(city: City) {
        viewModel.deleteCity(city)
    }

    private fun hideSoftKeyboard() {
        binding.search.clearFocus()
        val windowToken = view?.rootView?.windowToken
        windowToken?.let {
            val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it, 0)
        }
    }


    private fun initialState() {
        binding.recyclerViewSearch.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
    }
}