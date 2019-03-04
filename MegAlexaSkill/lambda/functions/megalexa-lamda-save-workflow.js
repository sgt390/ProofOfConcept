const AWS = require('aws-sdk');
let docClient = new AWS.DynamoDB.DocumentClient();

exports.handler = (e, ctx, callback) => {
    
    var params = {
        TableName: 'MegAlexa',
        Key: {
            'userID': e.userID
        },
        UpdateExpression: "set workflowList.#key= :wf",
        ExpressionAttributeNames:{
            "#key" : e.workflowName
        },
        ExpressionAttributeValues:{
            ":wf":e.workflow
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