package com.my.dictionarypl.feature_dictionary.domain.repository

import com.my.dictionarypl.core.util.Resource
import com.my.dictionarypl.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

/**
created by Mehmet E. Yıldız
 **/
interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}