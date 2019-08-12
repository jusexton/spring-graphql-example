package com.sexton.example.graphqlpoc.exception

import graphql.ExceptionWhileDataFetching
import graphql.GraphQLError
import graphql.servlet.GraphQLErrorHandler
import org.springframework.stereotype.Component

@Component
class ErrorHandler : GraphQLErrorHandler {
    override fun processErrors(errors: MutableList<GraphQLError>?): MutableList<GraphQLError> =
            errors?.map { getNested(it) }?.toMutableList() ?: mutableListOf()

    private fun getNested(error: GraphQLError): GraphQLError =
            if (error is ExceptionWhileDataFetching && error.exception is GraphQLError) error.exception as GraphQLError else error
}