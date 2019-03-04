/*
* File: BlockTextToSpeech.js
* Version: 0.0.1
* Date: 2019-02-25
* Author: Matteo Depascale
* License:
*
* History:
* Author                || Date         || Description
* Matteo Depascale      || 2019-02-25   || Created file
*/
'use strict';

const Block = require("./Block");

class BlockTextToSpeech extends Block{
    constructor(blockConfig) {
        super(blockConfig);
    }

    get text() {
        return this.blockConfig.TextToSpeech;
    }

    isElicit(){
        return false;
    }

}

module.exports = BlockTextToSpeech;