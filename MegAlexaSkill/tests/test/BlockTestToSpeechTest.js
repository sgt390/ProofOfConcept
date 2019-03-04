/*
* File: BlockTestToSpeechTest.js
* Version: 0.0.1
* Date: Date: 2019-02-26
* Author: Stefano Zanatta
* License:
*
* History:
* Author            || Date         ||  descriptor
* Stefano Zanatta   || 2019-02-26   || Created file
*/
const assert = require('chai').assert;
const blockTextToSpeech = require("../../lambda/blocks/BlockTextToSpeech");

describe('BlockTextToSpeech', function(){
    it('text return string', function(){
        objectBlock = {textToSpeech : 'this is a text block'};
        tts = new blockTextToSpeech(objectBlock);
        oracle = 'this is a text block';
        assert.equal(tts.text,oracle);

    });
});
