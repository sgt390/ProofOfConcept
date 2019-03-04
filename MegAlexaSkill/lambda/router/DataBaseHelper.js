/*
* File: DataBaseHelper.js
* Version: 0.0.1
* Date: Date: 2019-03-02
* Author: Stefano Zanatta
* License:
*
* History:
* Author            || Date         || Description
* Stefano Zanatta   || 2019-03-02   || Created file
*/
const Router = require("./router");

class DataBaseHelper {

    constructor(userID){
        this.userInfo = new Router(userID).userData(); 
    }
    /**
     * @returns array of objects rappresenting blocks
     */
    workflowByName(workflowName){
        return this.userInfo.then(result => {
            return result.Item.workflowList[workflowName];
        })
        .catch(function(error){
            console.log(error);
        });
    }

}

module.exports = DataBaseHelper;