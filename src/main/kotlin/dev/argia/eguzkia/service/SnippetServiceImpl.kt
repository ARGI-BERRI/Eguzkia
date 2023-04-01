package dev.argia.eguzkia.service

import dev.argia.eguzkia.entity.Snippet
import dev.argia.eguzkia.repository.SnippetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SnippetServiceImpl: SnippetService {
    @Autowired
    lateinit var snippetRepository: SnippetRepository

    override fun get(slug: String): Snippet {
        return snippetRepository.findById(slug)
            .orElse(Snippet.EMPTY_SNIPPET.also { it.slug = slug })
    }

    override fun getAll(): List<Snippet> {
        return snippetRepository.findAll()
    }

    override fun create(snippet: Snippet): Snippet {
        return snippetRepository.save(snippet)
    }

    override fun delete(slug: String) {
        return snippetRepository.deleteById(slug)
    }
}