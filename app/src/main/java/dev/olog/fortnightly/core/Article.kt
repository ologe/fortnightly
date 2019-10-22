package dev.olog.fortnightly.core

data class Article(
    val id: Int,
    val title: String,
    val summary: String,
    val category: String,
    val url: String
)