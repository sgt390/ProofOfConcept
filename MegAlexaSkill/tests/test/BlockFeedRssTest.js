/*
* File: BlockFeedRSSTest.js
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
const blockFeedRSS = require("../../lambda/blocks/BlockFeedRSS");

describe('BlockFeedRSS', function(){
    it('test on FeedRSS', function(){
        objectBlock = {feedRSS : ''};
        fRSS = new blockFeedRSS(objectBlock);
        oracle = 'this is a feedRSS block';
        assert.equal(fRSS.text,oracle);
    });
});
