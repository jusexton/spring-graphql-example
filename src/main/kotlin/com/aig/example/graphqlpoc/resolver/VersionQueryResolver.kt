package com.aig.example.graphqlpoc.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class VersionQueryResolver : GraphQLQueryResolver {
    fun version() = "v1.0"
}