package com.example.demo.controllers

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customer")
class CustomerController {


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    fun getCustomer(): String {
        return "HEllO"
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    fun createCustomer(): String {
        return "CREATED"
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    fun deleteCustomer(): String {
        return "DELETED"
    }
}