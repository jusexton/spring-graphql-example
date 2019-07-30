package com.aig.example.graphqlpoc.service

import com.aig.example.graphqlpoc.model.User
import com.aig.example.graphqlpoc.repository.UserRepository
import com.aig.example.graphqlpoc.repository.filter.UserFilter
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class UserService(private val template: MongoTemplate,
                  val repository: UserRepository) {
    fun findAll(filter: UserFilter?): Iterable<User> =
            if (filter != null) template.find(filter.toQuery(), User::class.java) else repository.findAll()
}