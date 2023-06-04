package com.example.identyfikator

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.identyfikator.databinding.FragmentLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.json.JSONObject


class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Pompowanie layoutu za pomocą dataBinding
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.signIn.setOnClickListener {
            lateinit var data: String
            val userName: String = binding.textLogin.text.toString()
            val userPassword: String = binding.textPassword.text.toString()
            //obsługa zapytania post do serwera, zrobione na osobnym wątku za pomocą countries
            runBlocking(Dispatchers.IO) {
                val requests = Requests()
                data = requests.sendPOSTLogin(userName, userPassword)
            }
            //nawigacja z przekazaniem danych pomiędzy
            if(data != "Wrong data!")
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment(data))
            else binding.inputErrors.visibility = View.VISIBLE
            hideKeyboard()
        }
        return binding.root
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}