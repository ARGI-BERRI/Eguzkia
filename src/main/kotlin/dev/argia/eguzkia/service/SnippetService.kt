package dev.argia.eguzkia.service

import dev.argia.eguzkia.entity.Snippet
import org.springframework.stereotype.Service

@Service
interface SnippetService {
    fun get(slug: String): Snippet

    fun getAll(): List<Snippet>

    fun create(snippet: Snippet): Snippet

    fun delete(slug: String)
}