package com.my.dictionarypl.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.my.dictionarypl.feature_dictionary.data.util.JsonParser
import com.my.dictionarypl.feature_dictionary.domain.model.Meaning

/**
created by Mehmet E. Yıldız
 **/

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json = json,
            type = object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            type = object : TypeToken<ArrayList<Meaning>>() {}.type

        ) ?: "[]"
    }

}