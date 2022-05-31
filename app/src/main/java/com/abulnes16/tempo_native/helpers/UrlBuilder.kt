package com.abulnes16.tempo_native.helpers

import com.abulnes16.tempo_native.BuildConfig

object UrlBuilder {

    fun createWeatherUrl(resource: String, query: String): String{
        return "${resource}?${query}&appId=${BuildConfig.WEATHER_API_KEY}"
    }

}