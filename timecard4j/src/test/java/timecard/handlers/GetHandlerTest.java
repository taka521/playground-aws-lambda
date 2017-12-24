package timecard.handlers;

import cloud.localstack.LocalstackTestRunner;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import timecard.mocks.ContextMock;
import timecard.tables.TimeCard;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(LocalstackTestRunner.class)
public class GetHandlerTest {

    private GetHandler handler;
    private Context context;

    @Before
    public void before() {
        handler = new GetHandler();
        context = new ContextMock();
    }

    @Test
    public void handleRequest() throws Exception {
        List<TimeCard> timeCards = new ArrayList<>();
        TimeCard tc1 = new TimeCard();
        tc1.setId(Long.valueOf(0));
        tc1.setDate(LocalDate.of(2017, 1, 1));

        List<TimeCard> result = handler.handleRequest(timeCards, context);

        result.forEach(System.out::println);
    }

}