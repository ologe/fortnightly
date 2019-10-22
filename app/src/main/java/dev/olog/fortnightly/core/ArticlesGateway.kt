package dev.olog.fortnightly.core

interface ArticlesGateway {

    suspend fun topStories(): List<Article>

}