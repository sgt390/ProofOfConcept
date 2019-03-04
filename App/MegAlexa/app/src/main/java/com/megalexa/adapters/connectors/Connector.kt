package com.megalexa.adapters.connectors

import java.util.*

interface Connector {
    /**
     * Tries a connection using the URI with minimal parameters
     */
    /*
     variable uri may need a more specific type;
     return type may be less specific.
     */
    fun connect(uri:String):String

    /**
     * A connector is valid if connect(..) generates a valid result
     */
    fun valid():Boolean
}