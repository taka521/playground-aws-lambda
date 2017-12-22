package timecard.handlers;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import timecard.tables.TimeCard;

import java.time.LocalDate;
import java.util.List;

public class GetHandler implements RequestHandler<List<TimeCard>, List<TimeCard>>{

    @Override
    public List<TimeCard> handleRequest(List<TimeCard> timeCards, Context context) {

//        // Get logger.
//        final LambdaLogger logger = context.getLogger();
//        logger.log(String.format("Start [%s]. requestId = [%s]", context.getFunctionName(), context.getAwsRequestId()));
//
//        // Get DynamoDB Client.
//        final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
//        DynamoDBMapper mapper = new DynamoDBMapper(client);
//
//        // set find key.
//        final LocalDate findKey = LocalDate.parse(date);
//        TimeCard timeCard = new TimeCard();
//        timeCard.setDate(findKey);
//
//        DynamoDBQueryExpression<TimeCard> queryExpression = new DynamoDBQueryExpression<>();
//        queryExpression.withHashKeyValues(timeCard);

        return null;
    }
}
