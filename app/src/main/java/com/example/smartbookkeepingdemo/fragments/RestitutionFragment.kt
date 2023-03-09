package com.example.smartbookkeepingdemo.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartbookkeepingdemo.R
import com.example.smartbookkeepingdemo.viewmodels.RestitutionViewModel

class RestitutionFragment : Fragment() {

    companion object {
        fun newInstance() = RestitutionFragment()
    }

    private lateinit var viewModel: RestitutionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restitution, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RestitutionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}