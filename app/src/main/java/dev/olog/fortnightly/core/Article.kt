package dev.olog.fortnightly.core

data class Article(
    val id: Long,
    val title: String,
    val summary: String,
    val section: String,
    val subSection: String,
    val url: String
)