package com.example.gaditeksocialapp.ui.main.channel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Channel
import com.example.gaditeksocialapp.R
import com.example.gaditeksocialapp.databinding.ItemChannelBinding

class ChannelListAdapter(val list: MutableList<Channel>,val viewModel: ChannelListViewModel) :
    RecyclerView.Adapter<ChannelListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemChannelBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemChannelBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_channel,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.item = list[position]
        holder.binding.viewModel = viewModel
    }

    override fun getItemCount() = list.size
}