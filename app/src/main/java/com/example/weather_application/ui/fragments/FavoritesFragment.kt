package com.example.weather_application.ui.fragments

import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.weather_application.data.base.BaseFragment
import com.example.weather_application.databinding.FragmentFavoritesBinding
import com.example.weather_application.ui.MainViewModel
import com.example.weather_application.ui.adapters.DirectAdapter
import com.example.weather_application.ui.adapters.FavoritesAdapter


class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    private val viewModel: MainViewModel by activityViewModels()


    override fun getViewBinding(): FragmentFavoritesBinding =
        FragmentFavoritesBinding.inflate(layoutInflater)

    override fun setUpObservers() {

        viewModel.cities.observe(this, Observer {
            binding.recyclerViewSearch.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            (binding.recyclerView.adapter as FavoritesAdapter).submitList(it)

        })

        viewModel.directions.observe(this, Observer {
            binding.recyclerViewSearch.visibility = View.VISIBLE
            binding.recyclerView.visibility = View.GONE

            (binding.recyclerViewSearch.adapter as DirectAdapter).submitList(it)
        })

    }

    override fun setUpViews() {

        binding.recyclerView.adapter = FavoritesAdapter()
        binding.recyclerViewSearch.adapter = DirectAdapter {

        }

        binding.search.doOnTextChanged { text, _, _, _ ->
            text?.let {
                if (it.length > 2)
                    viewModel.loadDirections(it.toString())
            }

        }

    }
}