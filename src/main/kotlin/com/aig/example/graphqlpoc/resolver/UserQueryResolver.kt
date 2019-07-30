package com.aig.example.graphqlpoc.resolver

import com.aig.example.graphqlpoc.exception.UserNotFoundException
import com.aig.example.graphqlpoc.repository.filter.UserFilter
import com.aig.example.graphqlpoc.service.UserService
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class UserQueryResolver(private val userService: UserService) : GraphQLQueryResolver {
    fun userById(id: String) = userService.repository.findById(id).orElseThrow { UserNotFoundException(id) }

    fun allUsers(filter: UserFilter?) = userService.findAll(filter)
}