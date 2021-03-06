package com.arnaudj.sbplaygnd

import com.arnaudj.sbplaygnd.entities.Employee
import com.arnaudj.sbplaygnd.repositories.EmployeeRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class SbplaygroundApplication {
    @Autowired
    lateinit var employeeRepository: EmployeeRepository
    @Autowired
    lateinit var configService: ConfigService

    // <=>  @Bean fun init() = CommandLineRunner { }
    // <=> dedicated @Component class implementing CommandLineRunner, cf https://github.com/spring-guides/tut-react-and-spring-data-rest/blob/master/basic/src/main/java/com/greglturnquist/payroll/DatabaseLoader.java
    @PostConstruct
    fun init() {//} = CommandLineRunner {
        val log = LoggerFactory.getLogger(SbplaygroundApplication::class.java)
        log.info(configService.getInitInfoMessage())
        employeeRepository.save(Employee("employee1", "employeeName1", "employee description 1", 1001))
        employeeRepository.save(Employee("employee2", "employeeName2", "employee description 2", 1002))
    }
}

fun main(args: Array<String>) {
    runApplication<SbplaygroundApplication>(*args)
}
