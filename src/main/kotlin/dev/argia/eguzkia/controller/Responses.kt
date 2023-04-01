package dev.argia.eguzkia.controller

import dev.argia.eguzkia.entity.SnippetMeta

class SnippetRecord(
    val slug: String,
    val createdAt: String
)

// NOTE: IntelliJ は private にして良いと宣っているが、そうすると Jackson のパースが死ぬ
@Suppress("MemberVisibilityCanBePrivate")
class SnippetContent(meta: SnippetMeta, data: ByteArray) {
    val slug: String
    val createdBy: String
    val createdAt: String
    val content: String

    init {
        slug = meta.slug
        createdBy = meta.createdBy
        createdAt = meta.createdAt
        content = data.decodeToString()
    }
}