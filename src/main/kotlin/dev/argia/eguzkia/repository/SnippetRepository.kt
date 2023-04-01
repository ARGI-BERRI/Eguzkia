package dev.argia.eguzkia.repository

import dev.argia.eguzkia.entity.SnippetMeta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SnippetRepository: JpaRepository<SnippetMeta, String>