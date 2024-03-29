package com.droidsmith.mcunexus.util

import com.droidsmith.mcunexus.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {

    const val MARVEL_BASE_URL = "https://gateway.marvel.com/v1/public/"
    const val UPCOMING_BASEURL ="https://whenisthenextmcufilm.com/"
    val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
    const val API_KEY = BuildConfig.PUBLIC_KEY
    const val PRIVATE_KEY = BuildConfig.PRIVATE_KEY


    fun hash(): String {

        val input = "$timeStamp$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

}