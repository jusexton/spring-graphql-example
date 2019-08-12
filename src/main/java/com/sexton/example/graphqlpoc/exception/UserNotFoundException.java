package com.sexton.example.graphqlpoc.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UserNotFoundException extends RuntimeException implements GraphQLError {
    private final String userId;

    public UserNotFoundException(final String userId) {
        super(String.format("User with the following ID could not be found: %s", userId));
        this.userId = userId;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @Override
    public List<Object> getPath() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("userId", userId);
    }

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    public String getUserId() {
        return this.userId;
    }
}
