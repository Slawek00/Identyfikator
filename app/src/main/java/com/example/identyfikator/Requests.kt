package com.example.identyfikator

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException
import org.json.JSONObject


class Requests {
    private val client = OkHttpClient()

    fun sendPOSTLogin(userName: String, userPassword: String): String{
        val jsonObject = JSONObject()
        jsonObject.apply {
            put("Login", userName)
            put("Password", userPassword)
        }

        lateinit var serverResponse: String
        val postBody= jsonObject.toString()
        val request = Request.Builder()
            .url("Server API IP")
            .post(postBody.toRequestBody(MEDIA_TYPE_MARKDOWN))
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            serverResponse = response.body!!.string()
        }

        return serverResponse
    }

    fun sendRaport(raport: String):String{
        val jsonObject = JSONObject()
        jsonObject.apply {
            put("Raport", raport)
        }

        lateinit var serverResponse: String
        val postBody= jsonObject.toString()
        val request = Request.Builder()
            .url("Server API IP")
            .post(postBody.toRequestBody(MEDIA_TYPE_MARKDOWN))
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            serverResponse = response.body!!.string()
        }

        return serverResponse
    }

    companion object {
        val MEDIA_TYPE_MARKDOWN = "application/json; charset=utf-8".toMediaType()
    }
}