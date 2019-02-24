package com.arnaudj.sbplaygnd.repositories

import com.arnaudj.sbplaygnd.entities.User
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RepositoriesTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val userRepository: UserRepository) {

    // any syntaxic-sugared @BeforeAll would require to go single instantiation per test: junit.jupiter.testinstance.lifecycle.default = per_class: junit.jupiter.testinstance.lifecycle.default = per_class

    @Test
    fun `find user by login`() {
        val user1 = User("root", "John Doe", "suid0 user")
        entityManager.persistAndFlush(user1)
        val findUser1 = userRepository.findByLogin("root")
        Assertions.assertThat(findUser1).isEqualTo(user1)
    }
}