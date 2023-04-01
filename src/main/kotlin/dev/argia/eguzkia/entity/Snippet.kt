package dev.argia.eguzkia.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "snippets")
class Snippet(
    /**
     * The ID of a snippet, used for external use.
     */
    @Id
    @Column(nullable = false)
    var slug: String = "",

    /**
     * The main content of a snippet.
     */
    @Column(nullable = false)
    var snippet: String,

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
    var createdAt: Date = Date()
) {
    companion object {
        val EMPTY_SNIPPET = Snippet(
            snippet = "NO DATA",
            createdBy = ""
        )
    }

    @PrePersist
    fun preInsert() {
        this.slug = UUID.randomUUID().toString().slice(IntRange(0, 7))
        this.createdAt = Date()
    }
}

class SnippetDTO(
    val slug: String,
    val createdAt: Date
)