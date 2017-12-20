package com.example.aws.lambda.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.io.Serializable;

public class Handler001 implements RequestHandler<Handler001.Request, Handler001.Response>, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public Response handleRequest(Request input, Context context) {
        return new Response(input.firstName + " " + input.lastName);
    }

    static class Request {
        private final String firstName;
        private final String lastName;

        public Request(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

    }

    static class Response {
        private final String fullName;

        public Response(String fullName) {
            this.fullName = fullName;
        }

        public String getFullName() {
            return fullName;
        }
    }
}
