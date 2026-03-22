package com.dotcode.individualobsidian.controller

import com.dotcode.individualobsidian.domain.Article
import com.dotcode.individualobsidian.dto.ArticleCreateRequest
import com.dotcode.individualobsidian.dto.ArticleResponse
import com.dotcode.individualobsidian.service.ArticleService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/articles")
class ArticleController (
    private val articleService: ArticleService,
){
    @PostMapping
    fun create(@RequestBody request: ArticleCreateRequest): ArticleResponse {
        return articleService.create(request)
    }

    @GetMapping
    fun findById(@PathVariable id: Long): ArticleResponse {
        return articleService.findById(id)
    }

    @GetMapping
    fun findAll(): List<ArticleResponse> {
        return articleService.findAll()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        articleService.delete(id)
    }
}