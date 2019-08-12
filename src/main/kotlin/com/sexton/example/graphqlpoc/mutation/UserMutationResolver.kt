package com.sexton.example.graphqlpoc.mutation

import com.sexton.example.graphqlpoc.model.User
import com.sexton.example.graphqlpoc.model.input.UserInput
import com.sexton.example.graphqlpoc.repository.UserRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Component
class UserMutationResolver(private val userRepository: UserRepository) : GraphQLMutationResolver {
    fun createUser(userInput: UserInput) = userRepository.save(User(userInput.username, userInput.address))
}