package com.example.identyfikator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.identyfikator.databinding.FragmentMainBinding
import org.json.JSONObject


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )

        val args = MainFragmentArgs.fromBundle(requireArguments())
        val name = args.data?.let { dataUnpack(it) }
        binding.user.text = "Witaj ${name}!"


        binding.qr.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToIdCardFragment(data = args.data))
        }
        binding.raport.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToRaportFragment(data = args.data))
        }
        return binding.root
    }

    fun dataUnpack(data: String): String{
        val jsonObject = JSONObject(data)
        val name = jsonObject.getString("First_name")
        return name
    }
}