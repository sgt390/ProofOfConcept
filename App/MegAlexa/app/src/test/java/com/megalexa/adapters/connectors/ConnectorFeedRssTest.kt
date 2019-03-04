package com.megalexa.adapters.connectors

import org.junit.Test

import org.junit.Assert.*

class ConnectorFeedRssTest {

    @Test
    fun valid() {
        val uri = "https://feedforall.com/sample.xml"
        val uriIsValid = ConnectorFeedRss(uri).valid()
        assertEquals("ConnectorFeedRss connect test", uriIsValid, true)
    }


}