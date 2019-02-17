package com.arnaudj.sbplaygnd.repositories

import com.arnaudj.sbplaygnd.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User
}