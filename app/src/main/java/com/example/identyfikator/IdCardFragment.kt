package com.example.identyfikator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.identyfikator.databinding.FragmentIdCardBinding
import com.squareup.picasso.Picasso
import org.json.JSONObject


class IdCardFragment : Fragment() {
    companion object{
        private lateinit var args: IdCardFragmentArgs
        private lateinit var codeQr: String
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentIdCardBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_id_card, container, false
        )

        try{
            valueInit()
            Picasso.get().load(codeQr).into(binding.qrID);
        }catch (e: Exception){
            println(e)
        }


        return binding.root
    }

    private fun dataUnpack(data: String): String{
        val jsonObject = JSONObject(data)
        val url = jsonObject.getString("QR_code")
        return url
    }

    private fun valueInit(){
        args = IdCardFragmentArgs.fromBundle(requireArguments())
        codeQr = dataUnpack(args.data)
    }
}