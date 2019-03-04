/*
* File: BlockFeedRss.kt
* Version: 1.0.0
* Date: 2019-02-16
* Author: Ludovico Brocca
*         Matteo Depascale
* License:
*
* History:
* Author                || Date         || Description
* Ludovico Brocca       || 2019-02-16   || Writing class BlockFeedRss
* Matteo Depascale      || 2019-02-23   || Verifying code
*/

package com.megalexa.models.blocks

import android.util.Log
import com.megalexa.adapters.connectors.Connector
import com.megalexa.adapters.connectors.ConnectorFeedRss
import org.json.JSONObject


class BlockFeedRss(val url: String): Block,Filtrable {
    init{
        val connector = generateConnector(url)

    }


    /** generateConnector(url) returns an object that represents the connector for the desidered feedRSS
     * @param url is the url for the feedRSS
     * @return ConnectorFeedRss for the url(if the URL is valid)
     */
    private fun generateConnector(url: String): Connector {

        val toReturn=ConnectorFeedRss(url= url)

        Log.d("genero idhfgidhgfgikhdszfkoighsdifhgiousdh", "eccomi")
        if(!toReturn.valid()){
            //throw InvalidBLockException() TODO("custom error handling required ")
        }

        return toReturn

    }


    /** getInformation()
     * @return  String that sums up the information for the given feedRSS
     *
     */
    override fun getInformation():String {
        return "Feed RSS block created for $url URL "
    }

    override fun toJSON() : JSONObject {
        val allBlock = JSONObject()
        allBlock.put("blockType", "FeedRSS" )
        val config = JSONObject()
        config.put("url" , url)
        allBlock.put("config", config)
        return allBlock
    }
}