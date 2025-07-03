package dev.kauemiziara.quarkus_blog.modules.authors.infrastructure.controller

import dev.kauemiziara.quarkus_blog.modules.authors.application.dto.RegisterAuthorRequest
import dev.kauemiziara.quarkus_blog.modules.authors.application.mapper.AuthorMapperFactory
import dev.kauemiziara.quarkus_blog.modules.authors.application.service.AuthorService
import jakarta.transaction.Transactional
import jakarta.ws.rs.*
import jakarta.ws.rs.core.Context
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.UriInfo

@Path("/api/authors")
@Produces(MediaType.APPLICATION_JSON)
class AuthorController(
    private val authorService: AuthorService,
    private val authorMapperFactory: AuthorMapperFactory,
) {
    @POST
    @Path("/new")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    fun registerAuthor(
        request: RegisterAuthorRequest,
        @Context uriInfo: UriInfo,
    ): Response {
        val createdAuthor = authorService.createAuthor(request)

        val response = authorMapperFactory
            .detailAuthorMapper.toDto(createdAuthor)

        return Response.created(uriInfo.absolutePath)
            .entity(response).build()
    }
}