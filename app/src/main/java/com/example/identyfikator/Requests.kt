package com.example.identyfikator

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException
import org.json.JSONObject
import java.net.URL

class Requests {
    private val client = OkHttpClient()
    private val stringURL = "Server IP"

    fun sendGET(){
        val request = Request.Builder()
            .url(stringURL)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            println(response.body!!.string())
        }
    }

    fun sendPOST(userName: String, userPassword: String){
        val jsonObject = JSONObject()
        jsonObject.apply {
            put("Login", userName)
            put("Password", userPassword)
        }

        val postBody= jsonObject.toString()
        val request = Request.Builder()
            .url(stringURL)
            .post(postBody.toRequestBody(MEDIA_TYPE_MARKDOWN))
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            println(response.body!!.string())
        }
    }

    companion object {
        val MEDIA_TYPE_MARKDOWN = "text/x-markdown; charset=utf-8".toMediaType()
    }
}