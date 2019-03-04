/*
* File: router.js
* Version: 0.0.1
* Date: Date: 2019-02-28
* Author: Stefano Zanatta
* License:
*
* History:
* Author            || Date         || Description
* Stefano Zanatta   || 2019-02-28   || Created file
*/
var axios = require("axios");

class Router {
    constructor(userID){
        this.userID = userID;
    }
    // #TODO implement a cache system 
    userData() {
        const body = {
            userID: this.userID
        }
        return axios.post('https://m95485wij9.execute-api.us-east-1.amazonaws.com/beta/user/read', body)
        .then(function (result) {
            console.log("fetched user from database with success.");
            return result.data;
        })
        .catch(function (error) {
            console.log(error);
        });
    }

}

module.exports = Router;