package com.arnaudj.sbplaygnd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SbplaygroundApplication

fun main(args: Array<String>) {
	runApplication<SbplaygroundApplication>(*args)
}
