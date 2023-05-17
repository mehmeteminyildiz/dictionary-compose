package com.my.dictionarypl.feature_dictionary.domain.use_case

import com.my.dictionarypl.core.util.Resource
import com.my.dictionarypl.feature_dictionary.domain.model.WordInfo
import com.my.dictionarypl.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
created by Mehmet E. Yıldız
 **/
class GetWordInfo(
    private val repository: WordInfoRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {

        if (word.isBlank()) {
            return flow { }
        }

        return repository.getWordInfo(word = word)

    }

}