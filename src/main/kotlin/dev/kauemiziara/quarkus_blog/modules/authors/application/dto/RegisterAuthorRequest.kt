package dev.kauemiziara.quarkus_blog.modules.authors.application.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class RegisterAuthorRequest(
    @field:NotBlank(message = "The author must have an username.")
    @field:Size(max = 50, message = "The author name must have less than 50 characters.")
    val name: String,

    @field:NotBlank(message = "The author must have an email.")
    @field:Email(message = "The author must habe a valid email.")
    val email: String,

    @field:Size(max = 255, message = "The bio must have less than 255 characters.")
    val bio: String,
)