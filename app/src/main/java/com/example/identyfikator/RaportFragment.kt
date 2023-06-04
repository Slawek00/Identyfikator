package com.example.identyfikator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.identyfikator.databinding.FragmentRaportBinding


class RaportFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentRaportBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_raport, container, false
        )
        return binding.root
    }
}