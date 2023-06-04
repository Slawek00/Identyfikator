package com.example.identyfikator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.identyfikator.databinding.FragmentLoginBinding
import kotlin.concurrent.thread


class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Pompowanie layoutu za pomocą dataBinding
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)



        binding.signIn.setOnClickListener {
            val userName: String = binding.textLogin.text.toString()
            val userPassword: String = binding.textPassword.text.toString()

            thread(start = true){
                sendRequest(userName, userPassword)
            }
            findNavController().navigate(/*LoginFragmentDirections.actionLoginFragmentToMainFragment()*/R.id.action_loginFragment_to_mainFragment)

        }
        return binding.root
    }

    fun sendRequest(userName: String, userPassword: String) {
        val requests = Requests()
        //requests.sendGET()
        requests.sendPOST(userName, userPassword)
    }

}