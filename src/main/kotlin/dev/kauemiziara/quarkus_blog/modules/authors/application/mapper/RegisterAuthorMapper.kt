package dev.kauemiziara.quarkus_blog.modules.authors.application.mapper

import dev.kauemiziara.quarkus_blog.core.mapper.Mapper
import dev.kauemiziara.quarkus_blog.modules.authors.application.dto.RegisterAuthorRequest
import dev.kauemiziara.quarkus_blog.modules.authors.domain.entity.Author
import jakarta.enterprise.context.ApplicationScoped
import javax.naming.OperationNotSupportedException

@ApplicationScoped
class RegisterAuthorMapper : Mapper<RegisterAuthorRequest, Author> {
    override fun toEntity(dto: RegisterAuthorRequest): Author = Author().apply {
        name = dto.name
        email = dto.email
        bio = dto.bio
    }

    override fun toDto(entity: Author): RegisterAuthorRequest {
        throw OperationNotSupportedException(
            "Impossible to convert from Entity to Request DTO"
        )
    }
}