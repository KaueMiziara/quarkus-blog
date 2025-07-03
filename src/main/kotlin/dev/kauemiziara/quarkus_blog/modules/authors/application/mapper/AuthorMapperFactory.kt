package dev.kauemiziara.quarkus_blog.modules.authors.application.mapper

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class AuthorMapperFactory {
    @Inject
    lateinit var registerAuthorMapper: RegisterAuthorMapper

    @Inject
    lateinit var detailAuthorMapper: DetailAuthorMapper
}