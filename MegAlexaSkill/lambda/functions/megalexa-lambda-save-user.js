const AWS = require('aws-sdk');
let docClient = new AWS.DynamoDB.DocumentClient();

exports.handler = (e, ctx, callback) => {
    var params = {
        Item: {
            "userID": e.userID,
            "email": e.email,
            "name": e.name,
            "workflowList": {}
        },
        TableName: 'MegAlexa'
    };
    
    docClient.put(params, function(err, data) {
        if(err) {
            callback(err, null);
        }else {
            callback(null, data);
        }
    });
}