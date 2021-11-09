package com.example.apitest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyVM(application: Application): AndroidViewModel(application) {
    private var contents: MutableLiveData<List<Doc>> = MutableLiveData()
    private var contents2: MutableLiveData<List<Person>> = MutableLiveData()

    var apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
    fun getContents() = contents
    fun getContents2() = contents2

    fun getData(year:Int){



        apiInterface?.getPhoto(year)?.enqueue(object: Callback<BooksDetails?> {
            override fun onResponse(call: Call<BooksDetails?>, response: Response<BooksDetails?>) {


                var list=response.body()!!.response.docs
                contents.postValue(list)


            }

            override fun onFailure(call: Call<BooksDetails?>, t: Throwable) {
                println(t.message)
            }
        }
        )

    }



}