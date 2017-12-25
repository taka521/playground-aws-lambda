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
    Item: {
        "year": year,
        "title": title,
        "info": {
            "plot": "Nothing happens at all.",
            "rating": 0
        }
    }
};

console.log("Adding a new item...");

docClient.put(params, (err, data) => {
    if (err) {
        console.error("Unable to add item. Error JSON:", JSON.stringify(err, null, 2));
    } else {
        console.log("Added item:", JSON.stringify(data, null, 2));
    }
});