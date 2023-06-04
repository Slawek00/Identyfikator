package com.example.identyfikator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.identyfikator.databinding.FragmentMainBinding


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )

        val args = MainFragmentArgs.fromBundle(requireArguments())
        binding.user.text = args.userName


        binding.qr.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_idCardFragment)
        }
        binding.raport.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_raportFragment)
        }
        return binding.root
    }
}