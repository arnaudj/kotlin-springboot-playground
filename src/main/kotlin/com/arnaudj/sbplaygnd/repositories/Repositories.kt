package com.arnaudj.sbplaygnd.repositories

import com.arnaudj.sbplaygnd.entities.User
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): Optional<User>
}