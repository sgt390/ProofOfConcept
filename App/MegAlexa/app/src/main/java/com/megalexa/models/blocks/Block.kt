package com.megalexa.models.blocks

import com.megalexa.models.workflow.Workflow
import org.json.JSONObject
import java.io.Serializable

interface Block : Serializable{

    fun getInformation():String

    fun toJSON() : JSONObject

}