package dev.argia.eguzkia.service

import dev.argia.eguzkia.entity.Snippet
import org.springframework.stereotype.Service

@Service
interface SnippetService {
    /**
     * Gets a snippet of the given slug.
     * If the slug has no content, this returns an empty content.
     */
    fun get(slug: String): Snippet

    /**
     * Gets a list of slugs of available snippets.
     * This may be empty.
     */
    fun getAll(): List<Snippet>

    /**
     * Creates a new snippet.
     * This generates a slug for the snippet automatically.
     */
    fun create(snippet: Snippet): Snippet

    /**
     * Deletes a snippet of the given slug.
     */
    fun delete(slug: String)
}