package com.megalexa.models.blocks

import com.megalexa.adapters.connectors.Connector
import org.json.JSONObject

class BlockCalendar(private val userCredential:String): Block {
    override fun getInformation() :String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun testConnection(): Boolean{
        TODO("not implemented")
    }

    override fun toJSON(): JSONObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}