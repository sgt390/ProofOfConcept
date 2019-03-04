const AWS = require('aws-sdk');
let docClient = new AWS.DynamoDB.DocumentClient();

/* TODO
* - connect e.workflowList to DB without requesting entire DB
* - update all block informations, configuration 
*/

exports.handler = (e, ctx, callback) => {
    let newWorkflow = e.workflow;
    const blockIndex = e.blockIndex;
    const addingBlock = e.block;
    newWorkflow.splice(blockIndex, 0, addingBlock);
    
    var params = {
        
        TableName: 'MegAlexa',
        Key: {
            'userID': e.userID
        },
        UpdateExpression: "SET workflowList.#wfName= :n",
        ExpressionAttributeNames: {
          "#wfName": e.workflowName  
        },
        ExpressionAttributeValues:{
            ":n": newWorkflow
        },
        ReturnValues:"UPDATED_NEW"
    };
    
    docClient.update(params, function(err, data) {
        if(err) {
            callback(err, null);
        }else {
            callback(null, data);
        }
    });
}

