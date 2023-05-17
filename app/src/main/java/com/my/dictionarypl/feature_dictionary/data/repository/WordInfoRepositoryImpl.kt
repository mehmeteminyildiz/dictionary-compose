package com.my.dictionarypl.feature_dictionary.data.repository

import com.my.dictionarypl.core.util.Resource
import com.my.dictionarypl.feature_dictionary.data.local.WordInfoDao
import com.my.dictionarypl.feature_dictionary.data.remote.DictionaryApi
import com.my.dictionarypl.feature_dictionary.domain.model.WordInfo
import com.my.dictionarypl.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

/**
created by Mehmet E. Yıldız
 **/
class WordInfoRepositoryImpl(
    private val api: DictionaryApi, private val dao: WordInfoDao
) : WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfos(word = word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordsInfos = api.getWordInfo(word = word)
            dao.deleteWordInfos(remoteWordsInfos.map { it.word })
            dao.insertWordInfos(remoteWordsInfos.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong",
                    data = wordInfos
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection.",
                    data = wordInfos
                )
            )

        }

        val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }

        emit(Resource.Success(data = newWordInfos))

    }
}