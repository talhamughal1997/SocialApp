package com.example.gaditeksocialapp.ui.main.channel

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.gaditeksocialapp.R
import com.example.gaditeksocialapp.databinding.FragmentChannelListBinding
import com.example.gaditeksocialapp.util.autoNotify
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.map


@AndroidEntryPoint
class ChannelListFragment : Fragment() {

    val viewModel by viewModels<ChannelListViewModel>()

    lateinit var binding: FragmentChannelListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_channel_list, null, false)
        binding.lifecycleOwner = this
        initializeAdapter()
        observeEvents()
        return binding.root
    }

    private fun initializeAdapter() {
        val adapter = ChannelListAdapter(mutableListOf(),viewModel)
        binding.rvChannel.adapter = adapter

        lifecycleScope.launchWhenResumed {
            viewModel.channelList.map { it.toMutableList() }.collect {
                adapter.list.clear()
                adapter.list.addAll(it)
                adapter.autoNotify(adapter.list, emptyList()){ old, new -> old.name == new.name}
            }
        }

    }

    private fun observeEvents(){
        viewModel._event.observe(viewLifecycleOwner){
            when (it) {
               is ChannelEvent.OpenIntent -> {
                   startNewActivity(it.channel.packageNameAndroid)
                }
                else -> {}
            }
        }
    }

    private fun startNewActivity(packageName: String?) {
        var intent =  requireContext().packageManager.getLaunchIntentForPackage(packageName?:"")
        if (intent != null) {
            // We found the activity now start the activity
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            requireContext().startActivity(intent)
        } else {
            // Bring user to the market or let them choose an app?
            intent = Intent(Intent.ACTION_VIEW)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.data = Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
            requireContext().startActivity(intent)
        }
    }


}