package com.example.weather_application.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_application.databinding.SearchItemBinding
import com.example.weather_application.domain.dto.Direct
import com.example.weather_application.util.DirectDiffCallback


class DirectAdapter(
    private val onItemClickListener: (Direct) -> Unit
) : ListAdapter<Direct, DirectAdapter.ViewHolder>(DirectDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {
            val currentItem = currentList[position]
            binding.title.text = currentItem.fullName

            binding.root.setOnClickListener {
                onItemClickListener.invoke(currentItem)
            }
        }
    }

    class ViewHolder(val binding: SearchItemBinding) : RecyclerView.ViewHolder(binding.root)
}

