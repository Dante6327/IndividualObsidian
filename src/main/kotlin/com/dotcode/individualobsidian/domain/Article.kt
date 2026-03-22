package com.dotcode.individualobsidian.domain

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import java.time.LocalDateTime

@Entity
class Article (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var title: String,
    var content: String,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "article_tags",
        joinColumns = [JoinColumn(name = "article_id")]
    )
    var tags: List<String> = listOf(),
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "article_aliases",
        joinColumns = [JoinColumn(name = "article_id")]
    )
    @Column(name = "alias")
    var aliases: List<String> = listOf(),

    var filePath: String
): BaseEntity() {

}