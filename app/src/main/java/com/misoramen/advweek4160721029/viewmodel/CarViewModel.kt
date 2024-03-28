package com.misoramen.advweek4160721029.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.misoramen.advweek4160721029.model.Car
import com.misoramen.advweek4160721029.model.Student

class CarViewModel(application: Application): AndroidViewModel(application) {
    val carsLD = MutableLiveData<ArrayList<Car>>()
    val carLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        carLoadErrorLD.value = false
        loadingLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.137.185/anmp/cars.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                loadingLD.value = false
                Log.d("show_volley", it)
                val sType = object : TypeToken<List<Car>>(){}.type
                val result = Gson().fromJson<List<Car>>(it, sType)
                carsLD.value = result as ArrayList<Car>?
            },
            {
                Log.e("show_voley", it.toString())
                carLoadErrorLD.value = false
                loadingLD.value = false
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}