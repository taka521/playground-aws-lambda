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

// テーブル定義
const PARAMS = {
    TableName: "ToDo",
    KeySchema: [
        {AttributeName: "year", KeyType: "HASH"},      // パーティションキー
        {AttributeName: "dateTime", KeyType: "RANGE"}, // ソートキー
    ],
    AttributeDefinitions: [
        {AttributeName: "year", AttributeType: "N"},
        {AttributeName: "dateTime", AttributeType: "S"}
    ],
    ProvisionedThroughput: {
        ReadCapacityUnits: 10,
        WriteCapacityUnits: 10
    }
};

// テーブルの作成
DYNAMO_DB.createTable(PARAMS, (err, data) => {
    if (err) {
        console.error("Unable to create table. Error JSON:", JSON.stringify(err, null, 2));
    } else {
        console.log("Create table. Table description JSON:", JSON.stringify(data, null, 2));
    }
});