let AWS = require("aws-sdk");

AWS.config.update({
    region: "us-east-1",
    endpoint: "http://localhost:4569",
    accessKeyId: "dummy",
    secretAccessKey: "dummy"
});

let docClient = new AWS.DynamoDB.DocumentClient();

console.log("Querying for movies for 1985.");

let params = {
    TableName: "Movies",
    KeyConditionExpression: "#yr = :yyyy",
    ExpressionAttributeNames: {
        "#yr": "year"
    },
    ExpressionAttributeValues: {
        ":yyyy": 1985
    }
};

docClient.query(params, (err, data) => {
    if (err) {
        console.error("Unable to query. Error:", JSON.stringify(err, null, 2));
    } else {
        console.log("Query succeeded.");
        data.Items.forEach(item => console.log(" -", item.year + ": ", item.title));
    }
});