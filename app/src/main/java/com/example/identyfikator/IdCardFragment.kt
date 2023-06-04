package com.example.identyfikator


import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.identyfikator.databinding.FragmentIdCardBinding
import org.json.JSONObject
import java.net.URL


class IdCardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentIdCardBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_id_card, container, false
        )
        val args = IdCardFragmentArgs.fromBundle(requireArguments())
        val codeQr = dataUnpack(args.data)

        try {
            val `in` = URL(codeQr).openStream()
            val image = BitmapFactory.decodeStream(`in`)
            binding.qrID.setImageBitmap(image)
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
        return binding.root
    }

    fun dataUnpack(data: String): String{
        val jsonObject = JSONObject(data)
        val url = jsonObject.getString("QR_code")
        return url
    }

}