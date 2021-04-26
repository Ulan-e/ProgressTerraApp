package com.ulanapp.network.client

import android.annotation.SuppressLint
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.jvm.Throws

class DateDeserializer : JsonDeserializer<Date?> {

    @SuppressLint("SimpleDateFormat")
    @Throws(JsonParseException::class)
    override fun deserialize(element: JsonElement, arg1: Type?, arg2: JsonDeserializationContext?): Date? {
        val date = element.asString
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        format.timeZone = TimeZone.getTimeZone("GMT")
        return try {
            format.parse(date)
        } catch (exp: ParseException) {
            System.err.println(exp.localizedMessage)
            null
        }
    }
}