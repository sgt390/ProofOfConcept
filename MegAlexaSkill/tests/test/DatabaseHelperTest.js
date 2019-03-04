/*
* File: DatabaseHelperTest.js
* Version: 0.0.1
* Date: 2019-03-02
* Author:   Stefano Zanatta  
* License:
*
* History:
* Author                || Date         || Description
* Stefano Zanatta      || 2019-03-02   || Created file
*/

const {expect} = require('chai');
const DatabaseHelper = require("../../lambda/router/DataBaseHelper");

const oracle = JSON.stringify([ { config: { TextToSpeech: 'First block goes here' },
    blockType: 'TextToSpeech' },
  { config: { URL: 'https://www.ansa.it/sito/ansait_rss.xml' },
    blockType: 'FeedRSS' },
  { config: { TextToSpeech: 'Third block goes here' },
    blockType: 'TextToSpeech' },
  { config: { latitude: '45.40797', longitude: '11.88586' },
    blockType: 'Weather' },
  { config: { TextToSpeech: 'Fifth block goes here' },
    blockType: 'TextToSpeech' } ]);

describe('DatabaseHelper', function(){
    it('helper functions to interact with the database', function(){
        const user = new DatabaseHelper('AmazonUse56765000').blocks('Buongiorno');
        user.then(el => {
            expect(JSON.stringify(el)).to.equal(oracle);
        })
        .catch(function(error) {
            console.log(error);
        });
    });
});