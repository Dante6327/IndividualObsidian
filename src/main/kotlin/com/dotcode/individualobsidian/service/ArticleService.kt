package com.dotcode.individualobsidian.service

import com.dotcode.individualobsidian.domain.Article
import com.dotcode.individualobsidian.dto.ArticleCreateRequest
import com.dotcode.individualobsidian.dto.ArticleResponse
import com.dotcode.individualobsidian.repository.ArticleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ArticleService (
    private val articleRepository: ArticleRepository
) {
    // 글 생성
    @Transactional
    fun create(request: ArticleCreateRequest): ArticleResponse {
        val article = Article(
            title = request.title,
            content = request.content,
            tags = request.tags,
            aliases = request.aliases,
            filePath = request.filePath
        )

        return ArticleResponse.from(articleRepository.save(article))
    }

    // 글 단건 조회
    fun findById(id: Long): ArticleResponse {
        val article = articleRepository.findById(id)
            .orElseThrow { NoSuchElementException("Article not found: $id") }
        return ArticleResponse.from(article)
    }

    // 글 전체 조회
    fun findAll(): List<ArticleResponse> {
        return articleRepository.findAll().map { ArticleResponse.from(it) }
    }

    // 삭제
    fun delete(id: Long) {
        articleRepository.deleteById(id)
    }
}