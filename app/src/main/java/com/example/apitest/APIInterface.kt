package com.example.apitest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIInterface {
    @GET("/svc/archive/v1/{year}/1.json?api-key=dn8LQr9sLQEqgdAeeYYZjOYFJbvI5VCg")
    fun getPhoto(@Path("year") year:Int): Call<BooksDetails?>?
}