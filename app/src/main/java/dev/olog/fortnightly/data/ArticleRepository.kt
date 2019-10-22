package dev.olog.fortnightly.data

import dev.olog.fortnightly.core.Article
import dev.olog.fortnightly.core.ArticlesGateway
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val service: ArticleService
) : ArticlesGateway {

    override suspend fun getTopStories(): List<Article> = withContext(Dispatchers.IO) {
        val result = networkCall { service.fetchTopStories() }
        result.results.map { it.toDomain() }
    }
}