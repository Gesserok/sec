package com.example.demo.controllers

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(CustomerController::class)
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    // Test for GET /customer
    @Test
    @WithMockUser(roles = ["ADMIN"]) // Simulating an authenticated user with the ADMIN role
    fun `GET customer should return status OK and customer data`() {
        mockMvc.perform(get("/customer"))
            .andExpect(status().isOk)
            .andExpect(content().string("HEllO"))
    }

    // Test for POST /customer
    @Test
    @WithMockUser(roles = ["ADMIN"]) // Simulating an authenticated user with the ADMIN role
    fun `POST customer should return status CREATED and message`() {
        mockMvc.perform(
            post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")
        ) // Empty body for the test
            .andExpect(status().isOk)
            .andExpect(content().string("CREATED"))
    }

    // Test for DELETE /customer
    @Test
    @WithMockUser(roles = ["ADMIN"]) // Simulating an authenticated user with the ADMIN role
    fun `DELETE customer should return status OK and delete message`() {
        mockMvc.perform(delete("/customer"))
            .andExpect(status().isOk)
            .andExpect(content().string("DELETED"))
    }

    // Test for unauthorized access without the ADMIN role
    @Test
    @WithMockUser(roles = ["USER"]) // Simulating an authenticated user with the USER role
    fun `GET customer should return status FORBIDDEN for non-ADMIN user`() {
        mockMvc.perform(get("/customer"))
            .andExpect(status().isForbidden)
    }

    @Test
    @WithMockUser(roles = ["USER"]) // Simulating an authenticated user with the USER role
    fun `POST customer should return status FORBIDDEN for non-ADMIN user`() {
        mockMvc.perform(
            post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")
        )
            .andExpect(status().isForbidden)
    }

    @Test
    @WithMockUser(roles = ["USER"]) // Simulating an authenticated user with the USER role
    fun `DELETE customer should return status FORBIDDEN for non-ADMIN user`() {
        mockMvc.perform(delete("/customer"))
            .andExpect(status().isForbidden)
    }
}
