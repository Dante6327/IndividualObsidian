package com.dotcode.individualobsidian.dto

import com.dotcode.individualobsidian.domain.Article
import java.time.LocalDateTime

data class ArticleResponse(
    val id: Long,
    val title: String,
    val content: String,
    val tags: List<String>,
    val aliases: List<String>,
    val filePath: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun from(article: Article): ArticleResponse {
            return ArticleResponse(
                id = article.id!!,
                title = article.title,
                content = article.content,
                tags = article.tags,
                aliases = article.aliases,
                filePath = article.filePath,
                createdAt = article.createdAt,
                updatedAt = article.updatedAt
            )
        }
    }
}
