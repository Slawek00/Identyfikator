package com.example.identyfikator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import androidx.databinding.DataBindingUtil
import com.example.identyfikator.databinding.FragmentIdCardBinding


class IdCardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentIdCardBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_id_card, container, false
        )
        return binding.root
    }

}