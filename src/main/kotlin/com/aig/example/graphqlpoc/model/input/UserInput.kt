package com.aig.example.graphqlpoc.model.input

import com.aig.example.graphqlpoc.model.Address

data class UserInput(
        val username: String,
        val address: Address
)