package dev.kauemiziara.quarkus_blog.core.mapper

interface Mapper<D, E> {
    fun toEntity(dto: D): E
    fun toDto(entity: E): D
}