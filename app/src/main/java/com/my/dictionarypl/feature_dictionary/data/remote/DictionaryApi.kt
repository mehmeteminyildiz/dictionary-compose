package com.my.dictionarypl.feature_dictionary.data.remote

import com.my.dictionarypl.feature_dictionary.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
created by Mehmet E. Yıldız
 **/
interface DictionaryApi {

    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word: String
    ): List<WordInfoDto>

    companion object{
        val BASE_URL = "https://api.dictionaryapi.dev/"
    }


}