let AWS = require("aws-sdk");

AWS.config.update({
    region: "us-east-1",
    endpoint: "http://localhost:4569",
    accessKeyId: "dummy",
    secretAccessKey: "dummy"
});

let dynamodb = new AWS.DynamoDB();

let params = {
    TableName: "Movies"
};

dynamodb.deleteTable(params, (err, data) => {
    if (err) {
        console.error("Unable to delete table. Error JSON:", JSON.stringify(err, null, 2));
    } else {
        console.log("Deleted table. Table description JSON:", JSON.stringify(data, null, 2));
    }
});