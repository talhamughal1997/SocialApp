package com.example.gaditeksocialapp.ui.main.social

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Channel
import com.example.domain.model.Social
import com.example.gaditeksocialapp.R
import com.example.gaditeksocialapp.databinding.ItemChannelBinding
import com.example.gaditeksocialapp.databinding.ItemSocialBinding

class SocialListAdapter(val list: MutableList<Social>,val viewModel : SocialListViewModel) :
    RecyclerView.Adapter<SocialListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemSocialBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemSocialBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_social,
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