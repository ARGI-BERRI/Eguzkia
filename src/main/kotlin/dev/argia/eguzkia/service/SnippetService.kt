package dev.argia.eguzkia.service

import dev.argia.eguzkia.entity.SnippetMeta
import org.springframework.stereotype.Service

@Service
interface SnippetService {
    /**
     * Gets a snippet of the given slug.
     *
     * @param slug The content's slug
     *
     * @return Pair if the content exists, null otherwise
     */
    fun get(slug: String): Pair<SnippetMeta, ByteArray>?

    /**
     * Gets a list of slugs of available snippets.
     * This may be empty.
     */
    fun getAll(): List<SnippetMeta>

    /**
     * Creates a new snippet.
     * This generates a slug for the snippet automatically.
     *
     * @param meta The metadata of the content, may be partial
     * @param data The real content
     *
     * @return The full metadata of the content
     */
    fun create(meta: SnippetMeta, data: ByteArray): SnippetMeta

    /**
     * Deletes a snippet of the given slug.
     */
    fun delete(slug: String)
}