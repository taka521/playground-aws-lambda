package com.example.aws.lambda.handlers;

import com.example.aws.lambda.handlers.Handler001.Request;
import com.example.aws.lambda.handlers.Handler001.Response;
import mocks.ContextMock;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Handler001Test {

    @Test
    public void handleRequest() throws Exception {
        final Handler001 target = new Handler001();

        Request request = new Request("田中", "太郎");
        Response response = target.handleRequest(request, ContextMock.get());

        assertThat(response.getFullName(), is("田中 太郎"));
    }

}