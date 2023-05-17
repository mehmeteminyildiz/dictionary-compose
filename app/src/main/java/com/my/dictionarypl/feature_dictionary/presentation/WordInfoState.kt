package com.my.dictionarypl.feature_dictionary.presentation

import com.my.dictionarypl.feature_dictionary.domain.model.WordInfo

/**
created by Mehmet E. Yıldız
 **/
data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
) {

}