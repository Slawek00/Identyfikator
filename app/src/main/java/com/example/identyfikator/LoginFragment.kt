package com.example.identyfikator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.identyfikator.databinding.FragmentLoginBinding



class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Pompowanie layoutu za pomocą dataBinding
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        val userName: String = binding.textLogin.text.toString()

        binding.signIn.setOnClickListener {

            //findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment())

        }
        return binding.root
    }

    fun sendRequest() {

    }

}