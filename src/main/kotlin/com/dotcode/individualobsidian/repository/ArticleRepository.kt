package com.dotcode.individualobsidian.repository

import com.dotcode.individualobsidian.domain.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Long> {
    fun findByTitle(title: String): List<Article>
    fun findByTagsContaining(tag: String): List<Article>
}