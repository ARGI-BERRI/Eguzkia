package dev.argia.eguzkia.controller

import dev.argia.eguzkia.entity.SnippetMeta
import dev.argia.eguzkia.service.SnippetService
import jakarta.servlet.http.HttpServletRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
class SnippetController {
    val logger: Logger = LoggerFactory.getLogger(SnippetController::class.java)

    @Autowired
    lateinit var snippetService: SnippetService

    @GetMapping("/snippets")
    fun getSnippets(): List<SnippetRecord> {
        return snippetService.getAll().map { SnippetRecord(it.slug, it.createdAt) }
    }

    @PostMapping("/snippet")
    fun createSnippet(@RequestBody body: NewSnippetRequest, request: HttpServletRequest): SnippetMeta {
        val meta = SnippetMeta(createdBy = request.remoteAddr)
        val bytes = body.content.encodeToByteArray()

        return snippetService.create(meta, bytes)
    }

    @GetMapping("/snippet/{slug}")
    fun getSnippet(@PathVariable("slug") slug: String): SnippetContent? {
        logger.info("Getting $slug")

        val content = snippetService.get(slug)

        content?.let {
            logger.info("Slug $slug found.")
            val meta = it.first
            val data = it.second

            return SnippetContent(meta, data)
        }

        logger.warn("Slug $slug not found.")

        return null
    }

    @DeleteMapping("/snippet/{slug}")
    fun deleteSnippet(@PathVariable("slug") slug: String) {
        snippetService.delete(slug)
    }
}