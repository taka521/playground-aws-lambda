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
    }
};

console.log("Attempting a conditional delete...");
docClient.delete(params, (err, data) => {
    if (err) {
        console.error("Unable to delete item. Error JSON:", JSON.stringify(err, null, 2));
    } else {
        console.info("DeleteItem succeeded:", JSON.stringify(data, null, 2));
    }
});
