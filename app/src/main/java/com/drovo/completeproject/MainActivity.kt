package com.drovo.completeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.drovo.completeproject.adapter.PostAdapter
import com.drovo.completeproject.databinding.ActivityMainBinding
import com.drovo.completeproject.util.ApiState
import com.drovo.completeproject.util.Constants.TAG
import com.drovo.completeproject.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        mainViewModel.getPost()
        lifecycleScope.launchWhenStarted {
            mainViewModel._postStateFlow.collect { it->
                when(it){
                    is ApiState.Loading->{
                        binding.recyclerview.isVisible = false
                        binding.progressbar.isVisible = true
                    }
                    is ApiState.Failure->{
                        binding.recyclerview.isVisible = false
                        binding.progressbar.isVisible = false
                        Log.d(TAG, "${it.msg}")
                    }
                    is ApiState.Success->{
                        binding.recyclerview.isVisible = true
                        binding.progressbar.isVisible = false
                        postAdapter.setData(it.data)
                    }
                    is ApiState.Empty->{

                    }
                    else -> {}
                }
            }
        }

    }

    private fun initRecyclerView() {
        postAdapter = PostAdapter(ArrayList())
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}