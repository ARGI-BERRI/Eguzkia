package dev.argia.eguzkia.controller

import dev.argia.eguzkia.entity.Snippet
import dev.argia.eguzkia.entity.SnippetDTO
import dev.argia.eguzkia.service.SnippetService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
class SnippetController {
    @Autowired
    lateinit var snippetService: SnippetService

    @GetMapping("/snippets")
    fun getSnippets(): List<SnippetDTO> {
        return snippetService.getAll().map { SnippetDTO(it.slug, it.createdAt) }
    }

    @PostMapping("/snippet")
    fun createSnippet(@RequestBody snippet: Snippet, request: HttpServletRequest): Snippet {
        return snippetService.create(Snippet(
            createdBy = request.remoteAddr ?: "unknown",
            snippet = snippet.snippet
        ))
    }

    @GetMapping("/snippet/{slug}")
    fun getSnippet(@PathVariable("slug") slug: String): Snippet {
        return snippetService.get(slug)
    }

    @DeleteMapping("/snippet/{slug}")
    fun deleteSnippet(@PathVariable("slug") slug: String) {
        snippetService.delete(slug)
    }
}