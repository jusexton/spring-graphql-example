package com.sexton.example.graphqlpoc.model.input

import com.sexton.example.graphqlpoc.model.Address

data class UserInput(
        val username: String,
        val address: Address
)