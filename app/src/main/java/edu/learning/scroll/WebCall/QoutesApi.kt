package edu.learning.scroll.WebCall

import edu.learning.scroll.Data.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface QoutesApi {
    @GET("/quotes")
    fun getQuotes() : Response<QuoteList>
}