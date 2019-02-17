package com.arnaudj.sbplaygnd.sbplayground.repositories

import com.arnaudj.sbplaygnd.sbplayground.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User
}