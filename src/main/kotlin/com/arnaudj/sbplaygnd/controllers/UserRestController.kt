package com.arnaudj.sbplaygnd.controllers

import com.arnaudj.sbplaygnd.entities.User
import com.arnaudj.sbplaygnd.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/users")
class UserRestController(val userRepository: UserRepository) {

    @GetMapping("")
    fun findAll(): Iterable<User> = userRepository.findAll()

    @GetMapping("/find/{login}")
    fun findOne(@PathVariable login: String): User { // nb: @RequestParam() is for query string parameters
        return userRepository.findByLogin(login).orElseThrow { ElementNotFoundException("user") }
    }

    // ResponseEntity based error handling to return a pure Status-code:404 in absence of a @ControllerAdvice+@ExceptionHandler (else, servlet container will print an enriched 404 page)
    @GetMapping("/find2/{login}")
    fun findOne2(@PathVariable login: String): ResponseEntity<User> { // nb: @RequestParam() is for query string parameters
        return userRepository.findByLogin(login)
                .map { user -> ResponseEntity(user, HttpStatus.OK) }
                .orElse(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @GetMapping("/create") // should be @PutMapping
    fun createUser(@RequestParam("login") login: String, @RequestParam("name") name: String): User {
        return userRepository.save(User(login, name, "Created from REST api"))
    }
}