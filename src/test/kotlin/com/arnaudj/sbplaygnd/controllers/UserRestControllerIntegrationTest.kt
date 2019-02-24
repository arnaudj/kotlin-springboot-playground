package com.arnaudj.sbplaygnd.controllers

import com.arnaudj.sbplaygnd.entities.User
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class UserRestControllerIntegrationTest constructor(@Autowired val mockMvc: MockMvc) {

    @Test
    fun `test create findOne findAll`() {
        mockMvc.perform(get("/api/users/create?login=root&name=suid0User")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", org.hamcrest.Matchers.equalTo("suid0User")))

        mockMvc.perform(get("/api/users/create?login=bill&name=msft")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", org.hamcrest.Matchers.equalTo("msft")))

        mockMvc.perform(get("/api/users/find/root")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", org.hamcrest.Matchers.equalTo("suid0User")))

        mockMvc.perform(get("/api/users/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", hasSize<User>(2)))
                .andExpect(jsonPath("$[0].login", org.hamcrest.Matchers.equalTo("root")))
                .andExpect(jsonPath("$[0].name", org.hamcrest.Matchers.equalTo("suid0User")))
                .andExpect(jsonPath("$[1].login", org.hamcrest.Matchers.equalTo("bill")))
    }
}