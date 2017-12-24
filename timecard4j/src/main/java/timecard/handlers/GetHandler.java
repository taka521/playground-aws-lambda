package timecard.handlers;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import timecard.tables.TimeCard;

import java.util.List;
import java.util.stream.Collectors;

public class GetHandler implements RequestHandler<List<TimeCard>, List<TimeCard>> {

    @Override
    public List<TimeCard> handleRequest(List<TimeCard> input, Context context) {

        // Get logger.
        final LambdaLogger logger = context.getLogger();
        logger.log(String.format("Start [%s]. requestId = [%s]", context.getFunctionName(), context.getAwsRequestId()));

        // Get DynamoDB Client.
        final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
        final DynamoDBMapper mapper = new DynamoDBMapper(client);

        return input.stream().parallel().map(t -> mapper.load(TimeCard.class, t.getId(), t.getDate()))
                    .collect(Collectors.toList());

    }
}
