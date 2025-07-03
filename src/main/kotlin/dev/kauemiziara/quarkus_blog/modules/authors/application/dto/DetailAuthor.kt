package dev.kauemiziara.quarkus_blog.modules.authors.application.dto

import java.time.Instant

data class DetailAuthor(
    val name: String,
    val email: String,
    val bio: String,
    val createdAt: Instant,
    val updatedAt: Instant,
)