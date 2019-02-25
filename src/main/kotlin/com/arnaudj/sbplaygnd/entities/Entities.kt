package com.arnaudj.sbplaygnd.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/*
https://spring.io/guides/tutorials/spring-boot-kotlin/:
"Here we don’t use data classes with val properties because JPA is not designed to work with immutable classes
 or the methods generated automatically by data classes. If you are using other Spring Data flavor, most of them
  are designed to support such constructs so you should use classes like data class User(val login: String, …​)
  when using Spring Data MongoDB, Spring Data JDBC, etc."
 */
@Entity
class User(
        var login: String,
        var name: String,
        var description: String? = null,
        @Id @GeneratedValue var id: Long? = null)

@Entity
class Employee(
        var login: String,
        var name: String,
        var description: String? = null,
        var badgeNumber: Int,
        @Id @GeneratedValue var id: Long? = null)