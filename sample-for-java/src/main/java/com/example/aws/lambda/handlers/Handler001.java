package com.example.aws.lambda.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.io.Serializable;

public class Handler001 implements RequestHandler<Handler001.Request, Handler001.Response>, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public Response handleRequest(Request input, Context context) {
        Response response = new Response();
        response.setFullName(input.firstName + " " + input.lastName);
        return response;
    }

    static class Request {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    static class Response {
        private String fullName;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    }
}
