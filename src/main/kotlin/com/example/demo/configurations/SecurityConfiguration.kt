package com.example.demo.configurations

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity

@Configuration
@EnableMethodSecurity
//@EnableWebFluxSecurity
@EnableWebSecurity
class SecurityConfiguration