package dev.kauemiziara.quarkus_blog.modules.authors.application.service

import dev.kauemiziara.quarkus_blog.modules.authors.application.dto.RegisterAuthorRequest
import dev.kauemiziara.quarkus_blog.modules.authors.domain.entity.Author
import dev.kauemiziara.quarkus_blog.modules.authors.application.mapper.AuthorMapperFactory
import jakarta.enterprise.context.ApplicationScoped
import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validator

@ApplicationScoped
class AuthorService(
    private val validator: Validator,
    private val authorMapperFactory: AuthorMapperFactory,
) {
    fun createAuthor(registerAuthorRequest: RegisterAuthorRequest): Author {
        val violations = validator.validate(registerAuthorRequest)
        if (violations.isNotEmpty()) {
            throw ConstraintViolationException(violations)
        }

        val author = authorMapperFactory
            .registerAuthorMapper.toEntity(registerAuthorRequest)

        author.persist()
        return author
    }
}