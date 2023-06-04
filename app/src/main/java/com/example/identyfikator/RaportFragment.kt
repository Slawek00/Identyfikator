package com.example.identyfikator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.identyfikator.databinding.FragmentRaportBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking


class RaportFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentRaportBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_raport, container, false
        )
        val text = binding.textRaport.text.toString()
        val args = RaportFragmentArgs.fromBundle(requireArguments())
        lateinit var response: String

        binding.raport.setOnClickListener {
            runBlocking(Dispatchers.IO){
                val requests = Requests()
                response = requests.sendRaport(text)
            }
            Toast.makeText(context, response, Toast.LENGTH_SHORT).show()
            findNavController().navigate(RaportFragmentDirections.actionRaportFragmentToMainFragment(data = args.data))
        }

        return binding.root
    }
}