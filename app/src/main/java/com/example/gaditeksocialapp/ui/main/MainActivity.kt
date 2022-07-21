package com.example.gaditeksocialapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.gaditeksocialapp.R
import com.example.gaditeksocialapp.databinding.ActivityMainBinding
import com.example.gaditeksocialapp.ui.main.adapter.MainPagerAdapter
import com.example.gaditeksocialapp.ui.main.channel.ChannelListFragment
import com.example.gaditeksocialapp.ui.main.social.SocialListFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<MainViewModel>()

    lateinit var pagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel.fetchData()
        initializeViews()
    }

    private fun initializeViews() {
        val tabNameList = listOf(getString(R.string.channel), getString(R.string.social))

        pagerAdapter = MainPagerAdapter(
            listOf(ChannelListFragment(), SocialListFragment()),
            supportFragmentManager,
            this.lifecycle
        )
        binding.pager.adapter = pagerAdapter

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, binding.pager) { tab, position ->
            tab.text = tabNameList[position]
        }.attach()


    }


}