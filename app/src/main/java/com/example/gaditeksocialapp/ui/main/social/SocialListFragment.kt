package com.example.gaditeksocialapp.ui.main.social

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
import com.example.gaditeksocialapp.databinding.FragmentSocialListBinding
import com.example.gaditeksocialapp.util.autoNotify
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SocialListFragment : Fragment() {

    val viewModel by viewModels<SocialListViewModel>()

    lateinit var binding: FragmentSocialListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_social_list, null, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        initializeAdapter()
        observeEvents()
        return binding.root
    }

    private fun initializeAdapter() {
        val adapter = SocialListAdapter(mutableListOf(), viewModel)
        binding.rvSocial.adapter = adapter
        lifecycleScope.launchWhenResumed {
            viewModel.socialList.collect {
                adapter.list.clear()
                adapter.list.addAll(it)
                adapter.autoNotify(adapter.list, emptyList()) { old, new -> old.name == new.name }
            }
        }
    }

    private fun observeEvents() {
        viewModel._event.observe(viewLifecycleOwner) {
            when (it) {
                is SocialEvent.OpenIntent -> {
                    startNewActivity(it.social.packageNameAndroid)
                }
                else -> {}
            }
        }
    }

    private fun startNewActivity(packageName: String?) {
        var intent = requireContext().packageManager.getLaunchIntentForPackage(packageName ?: "")
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            requireContext().startActivity(intent)
        } else {
            intent = Intent(Intent.ACTION_VIEW)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.data = Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
            requireContext().startActivity(intent)
        }
    }
}