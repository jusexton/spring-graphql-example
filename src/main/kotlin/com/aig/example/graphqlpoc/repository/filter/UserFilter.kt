package com.aig.example.graphqlpoc.repository.filter

import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo

data class UserFilter(val username: String? = null,
                      val postal: String? = null,
                      val mailing: String? = null,
                      val city: String? = null,
                      val state: String? = null) : QueryFilter {
    override fun toQuery(): Query {
        val query = Query()

        if (username != null) {
            query.addCriteria(Criteria.where("username").isEqualTo(username))
        }

        if (postal != null) {
            query.addCriteria(Criteria.where("address.postal").isEqualTo(postal))
        }

        if (mailing != null) {
            query.addCriteria(Criteria.where("address.mailing").isEqualTo(mailing))
        }

        if (city != null) {
            query.addCriteria(Criteria.where("address.city").isEqualTo(city))
        }

        if (state != null) {
            query.addCriteria(Criteria.where("address.state").isEqualTo(state))
        }

        return query
    }
}