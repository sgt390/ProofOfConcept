const AWS = require('aws-sdk');
let docClient = new AWS.DynamoDB.DocumentClient();

exports.handler = (e, ctx, callback) => {

    var params = {
        TableName: 'MegAlexa',
        Key: {
            "userID": e.userID,
        }
    }
    
    docClient.get(params, function(err, data) {
        if(err) {
            callback(err, null);
        }else {
            callback(null, data.Item.workflowList[e.workflow]);
            
        }
    })
}