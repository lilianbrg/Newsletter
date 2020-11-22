package com.example.newsapp.models

import android.graphics.Color
import android.graphics.drawable.ColorDrawable

import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    var vibrantLightColorList = arrayOf(
            ColorDrawable(Color.parseColor("#ffeead")),
            ColorDrawable(Color.parseColor("#93cfb3")),
            ColorDrawable(Color.parseColor("#fd7a7a")),
            ColorDrawable(Color.parseColor("#faca5f")),
            ColorDrawable(Color.parseColor("#1ba798")),
            ColorDrawable(Color.parseColor("#6aa9ae")),
            ColorDrawable(Color.parseColor("#ffbf27")),
            ColorDrawable(Color.parseColor("#d93947"))
    )

    fun getRandomDrawbleColor(): ColorDrawable? {
        var idx: Int = Random().nextInt(vibrantLightColorList.size)
        return vibrantLightColorList[idx]
    }

    fun DateToTimeFormat(oldstringDate: String?): String? {
        var p = PrettyTime(Locale(getCountry()))
        var isTime: String? = null
        try {
            var sdf = SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm:ss'Z'",
                    Locale.ENGLISH
            )
            var date: Date = sdf.parse(oldstringDate)
            isTime = p.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return isTime
    }

    fun DateFormat(oldStringDate: String?): String? {
        var newDate: String
        var dateFormat = SimpleDateFormat("E, d MMM yyyy", Locale(getCountry()))
        newDate = try {
            val date: Date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(oldStringDate)
            dateFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
            oldStringDate!!
        }
        return newDate
    }

    fun getCountry(): String? {
        val locale: Locale = Locale.getDefault()
        val country: String = java.lang.String.valueOf(locale.country)
        return country.toLowerCase()
    }
}