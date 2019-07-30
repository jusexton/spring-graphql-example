package com.aig.example.graphqlpoc.repository

import com.aig.example.graphqlpoc.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String>