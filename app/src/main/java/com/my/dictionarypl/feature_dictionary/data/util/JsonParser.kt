package com.my.dictionarypl.feature_dictionary.data.util

import java.lang.reflect.Type

/**
created by Mehmet E. Yıldız
 **/
interface JsonParser {

    fun <T> fromJson(json: String, type: Type): T?

    fun <T> toJson(obj: T, type: Type): String?

}