package com.sexton.example.graphqlpoc.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(
        val username: String,
        val address: Address,
        @Id val id: ObjectId = ObjectId())