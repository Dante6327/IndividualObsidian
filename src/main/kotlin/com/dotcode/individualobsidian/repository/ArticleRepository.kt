package com.dotcode.individualobsidian.repository

import com.dotcode.individualobsidian.domain.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ArticleRepository : JpaRepository<Article, Long> {
    fun findByTitle(title: String): List<Article>

    @Query("SELECT a FROM Article a JOIN a.tags t WHERE t = :tag")
    fun findByTags(tag: String): List<Article>
}