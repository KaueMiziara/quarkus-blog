package dev.kauemiziara.quarkus_blog.modules.authors.application.mapper

import dev.kauemiziara.quarkus_blog.core.mapper.Mapper
import dev.kauemiziara.quarkus_blog.modules.authors.application.dto.DetailAuthor
import dev.kauemiziara.quarkus_blog.modules.authors.domain.entity.Author
import jakarta.enterprise.context.ApplicationScoped
import javax.naming.OperationNotSupportedException

@ApplicationScoped
class DetailAuthorMapper : Mapper<DetailAuthor, Author> {
    override fun toEntity(dto: DetailAuthor): Author {
        throw OperationNotSupportedException(
            "Impossible to convert from Response DTO to Entity"
        )
    }

    override fun toDto(entity: Author): DetailAuthor = DetailAuthor(
        name = entity.name,
        email = entity.email,
        bio = entity.bio,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt,
    )
}