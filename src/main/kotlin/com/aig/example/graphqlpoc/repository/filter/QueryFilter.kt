package com.aig.example.graphqlpoc.repository.filter

import org.springframework.data.mongodb.core.query.Query

interface QueryFilter {
    fun toQuery(): Query
}