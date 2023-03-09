package com.example.smartbookkeepingdemo.fragments

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.smartbookkeepingdemo.R
import com.example.smartbookkeepingdemo.activities.ManualBookkeepingActivity
import com.example.smartbookkeepingdemo.databinding.FragmentAddBinding
import com.example.smartbookkeepingdemo.databinding.FragmentLawinBinding
import com.example.smartbookkeepingdemo.viewmodels.AddViewModel


class AddFragment : DialogFragment() {

    companion object {
        fun newInstance() = AddFragment()
    }

    private lateinit var viewModel: AddViewModel
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onStart() {
        super.onStart()

//        设置弹窗对应大小
        val dm = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(dm)
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        dialog!!.window!!.setLayout(width, 1500)//dm.heightPixels

        requireActivity().windowManager.defaultDisplay.getMetrics(dm)
        dialog!!.window!!.setLayout(dm.widthPixels, dialog!!.window!!.attributes.height)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddViewModel::class.java)
        // TODO: Use the ViewModel

        binding.addByHand.setOnClickListener {
            val intent = Intent(requireContext(), ManualBookkeepingActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}