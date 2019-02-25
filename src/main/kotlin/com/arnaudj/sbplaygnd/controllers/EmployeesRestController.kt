package com.arnaudj.sbplaygnd.controllers

import com.arnaudj.sbplaygnd.entities.Employee
import com.arnaudj.sbplaygnd.repositories.EmployeeRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employees")
class EmployeesRestController(val employeeRepository: EmployeeRepository) {

    @GetMapping("")
    fun all(): Iterable<Employee> = employeeRepository.findAll()

    @GetMapping("/{login}")
    fun one(@PathVariable login: String): Employee = employeeRepository.findByLogin(login).orElseThrow { ElementNotFoundException("employee") }
}