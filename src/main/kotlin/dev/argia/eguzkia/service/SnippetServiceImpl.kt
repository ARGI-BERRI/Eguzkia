package dev.argia.eguzkia.service

import dev.argia.eguzkia.entity.SnippetMeta
import dev.argia.eguzkia.repository.SnippetRepository
import dev.argia.eguzkia.storage.StorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SnippetServiceImpl: SnippetService {
    @Autowired
    lateinit var snippetRepository: SnippetRepository

    @Autowired
    lateinit var storageService: StorageService

    override fun get(slug: String): Pair<SnippetMeta, ByteArray>? {
        val meta = snippetRepository.findById(slug)

        if (meta.isPresent) {
            val data = storageService.read(slug)
            return Pair(meta.get(), data)
        }

        return null
    }

    override fun getAll(): List<SnippetMeta> {
        return snippetRepository.findAll()
    }

    override fun create(meta: SnippetMeta, data: ByteArray): SnippetMeta {
        storageService.write(meta.slug, data)

        return snippetRepository.save(meta)
    }

    override fun delete(slug: String) {
        return snippetRepository.deleteById(slug)
    }
}