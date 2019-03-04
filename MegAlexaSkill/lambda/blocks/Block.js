/*
* File: Block.js
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

class Block {
    constructor(blockConfig){
        this.blockConfiguration=blockConfig;
    }
    get text(){}

    parseBlock(blockConfig){}

    isElicit(){} // boolean for know if there is a interaction whith user

    get blockConfig(){
        return this.blockConfiguration
    }
    
}

module.exports =  Block;