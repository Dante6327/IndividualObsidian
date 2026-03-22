package com.dotcode.individualobsidian.dto

import com.dotcode.individualobsidian.domain.Article
import java.time.LocalDateTime

data class ArticleCreateRequest(
    val title: String,
    val content: String,
    val tags: List<String> = listOf(),
    val aliases: List<String> = listOf(),
    val filePath: String,
)