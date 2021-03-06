'use strict';

let AWS = require('aws-sdk');

AWS.config.update({
    region: "us-east-1",
    endpoint: "http://localhost:4569",
    accessKeyId: "dummy",
    secretAccessKey: "dummy"
});

let docClient = new AWS.DynamoDB.DocumentClient();

let table = "Movies";

let year = 2015;
let title = "The Big New Movie";

let params = {
    TableName: table,
    Key: {
        "year": year,
        "title": title
    },
    UpdateExpression: "remove info.actors[0]",
    ConditionExpression: "size(info.actors) >= :num",
    ExpressionAttributeValues: {
        ":num": 3
    },
    ReturnValues: "UPDATED_NEW"
};

console.log("Attempting a conditional update...");

docClient.update(params, (err, data) => {
    if (err) {
        console.error("Unable to update item. Error JSON:", JSON.stringify(err, null, 2));
    } else {
        console.log("UpdateItem succeeded:", JSON.stringify(data, null, 2));
    }
});