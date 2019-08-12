package com.sexton.example.graphqlpoc.repository

import com.sexton.example.graphqlpoc.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String>