package dev.olog.fortnightly.core

interface ArticlesGateway {

    suspend fun getTopStories(): List<Article>

}