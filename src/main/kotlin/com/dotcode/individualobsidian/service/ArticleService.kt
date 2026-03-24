package com.dotcode.individualobsidian.service

import com.dotcode.individualobsidian.domain.Article
import com.dotcode.individualobsidian.dto.ArticleCreateRequest
import com.dotcode.individualobsidian.dto.ArticleResponse
import com.dotcode.individualobsidian.dto.ArticleUpdateRequest
import com.dotcode.individualobsidian.repository.ArticleRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

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
    fun findAll(pageable: Pageable): Page<ArticleResponse> {
        return articleRepository.findAll(pageable).map { ArticleResponse.from(it) }
    }

    // 글 수정
    @Transactional
    fun update(id: Long, request: ArticleUpdateRequest): ArticleResponse {
        val article = articleRepository.findById(id)
            .orElseThrow { NoSuchElementException("Article not found: $id") }

        article.update(
            request.title,
            request.content,
            request.tags,
            request.aliases,
            request.filePath
        )
        return ArticleResponse.from(article)
    }

    // 삭제
    fun delete(id: Long) {
        articleRepository.deleteById(id)
    }
}