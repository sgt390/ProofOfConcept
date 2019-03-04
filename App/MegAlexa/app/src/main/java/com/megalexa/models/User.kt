package com.megalexa.models

import org.json.JSONObject

class User(uID: String ,mail: String,value: String) {

    private val userID= uID
    private val email= mail
    private val name= value

    fun getMail():String{
        return email
    }
    fun getName():String{
        return name
    }
    fun getID():String{
        return userID
    }

    fun toJSON() : JSONObject{
        val userJ : JSONObject = JSONObject()
        userJ.put("userID", userID)
        userJ.put("name", name)
        userJ.put("email", email)
        return userJ
    }
}