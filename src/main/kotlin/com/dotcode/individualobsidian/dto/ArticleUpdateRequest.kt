package com.dotcode.individualobsidian.dto

import jakarta.validation.constraints.NotBlank

data class ArticleUpdateRequest(
    @field:NotBlank
    val title: String,
    val content: String,
    val tags: List<String> = listOf(),
    val aliases: List<String> = listOf(),
    @field:NotBlank
    val filePath: String,
)