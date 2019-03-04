package com.megalexa.models.blocks

import org.json.JSONObject

/*
    Check if predecessor is Filtrable in Workflow class!
 */
internal class Filter(private val cardinality:Short):Block {
    override fun getInformation() :String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun cardinality() = cardinality

    override fun toJSON(): JSONObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}