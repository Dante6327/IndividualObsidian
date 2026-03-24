package com.dotcode.individualobsidian.controller

import com.dotcode.individualobsidian.common.ApiResponse
import com.dotcode.individualobsidian.domain.Article
import com.dotcode.individualobsidian.dto.ArticleCreateRequest
import com.dotcode.individualobsidian.dto.ArticleResponse
import com.dotcode.individualobsidian.dto.ArticleUpdateRequest
import com.dotcode.individualobsidian.service.ArticleService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/articles")
class ArticleController (
    private val articleService: ArticleService,
){
    @PostMapping
    fun create(@Valid @RequestBody request: ArticleCreateRequest): ApiResponse<ArticleResponse> {
        return ApiResponse("success", data = articleService.create(request))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ApiResponse<ArticleResponse> {
        return ApiResponse("success", data = articleService.findById(id))
    }

    @GetMapping
    fun findAll(pageable: Pageable): ApiResponse<Page<ArticleResponse>> {
        return ApiResponse("success", data = articleService.findAll(pageable))
    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: Long, @Valid @RequestBody request: ArticleUpdateRequest): ApiResponse<ArticleResponse> {
        return ApiResponse("success", data = articleService.update(id, request))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ApiResponse<Nothing> {
        articleService.delete(id)
        return ApiResponse("success", "success")
    }
}