package com.example.smartbookkeepingdemo.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartbookkeepingdemo.R
import com.example.smartbookkeepingdemo.viewmodels.AssetViewModel

class AssetFragment : Fragment() {

    companion object {
        fun newInstance() = AssetFragment()
    }

    private lateinit var viewModel: AssetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_asset, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AssetViewModel::class.java)
        // TODO: Use the ViewModel
    }

}