package dev.argia.eguzkia.entity

import jakarta.persistence.*
import java.time.Instant
import java.util.*

@Entity
@Table(name = "snippets_meta")
open class SnippetMeta(
    /**
     * The ID of a snippet, used for external use.
     */
    @Id
    @Column(nullable = false)
    var slug: String = UUID.randomUUID().toString().slice(IntRange(0, 7)),

    /**
     * The IP address who made a snippet.
     */
    @Column(nullable = false)
    var createdBy: String = "",

    /**
     * The date when a snippet is made.
     */
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    var createdAt: String = Instant.now().toString()
) {
    companion object {
        val EMPTY_SNIPPET = SnippetMeta(
            createdBy = ""
        )
    }
}