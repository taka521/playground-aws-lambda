"use strict";

const AWS = require("aws-sdk");

// 接続先のDynamoDBの設定
AWS.config.update({
    region: "us-east-1",
    endpoint: "http://localhost:4569",
    accessKeyId: "dummy",
    secretAccessKey: "dummy"
});

const DYNAMO_DB = new AWS.DynamoDB();

const PARAMS = {
    TableName: "ToDo"
};

// テーブルの削除
DYNAMO_DB.deleteTable(PARAMS, (err, data) => {
    if (err) {
        console.error("Unable to delete table. Error JSON:".JSON.stringify(err, null, 2));
    } else {
        console.log("Delete table. Table description JSON:", JSON.stringify(data, null, 2));
    }
});