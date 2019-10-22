package dev.olog.fortnightly.data

import dev.olog.fortnightly.core.Article
import dev.olog.fortnightly.core.ArticlesGateway

class ArticleRepository : ArticlesGateway {

    override suspend fun topStories(): List<Article> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}