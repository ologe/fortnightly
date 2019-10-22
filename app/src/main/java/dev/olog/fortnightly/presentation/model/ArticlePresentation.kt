package dev.olog.fortnightly.presentation.model

import dev.olog.fortnightly.R
import dev.olog.fortnightly.core.Article

sealed class ArticlePresentation(
    override val id: Long,
    override val viewType: Int
) : PresentationModel

data class BigArticle(
    override val id: Long,
    val title: String,
    val summary: String,
    val section: String,
    val subSection: String,
    val url: String,
    val image: String
) : ArticlePresentation(id, R.layout.item_article_big)

data class SmallArticle(
    override val id: Long,
    val title: String,
    val summary: String,
    val section: String,
    val subSection: String,
    val url: String,
    val image: String
) : ArticlePresentation(id, R.layout.item_article_small)

fun Article.toBigArticle(): ArticlePresentation {
    return BigArticle(
        id = id,
        title = this.title,
        summary = this.summary,
        section = this.section,
        subSection = this.subSection,
        url = this.url,
        image = this.image
    )
}

fun Article.toSmallArticle(): ArticlePresentation {
    return SmallArticle(
        id = id,
        title = this.title,
        summary = this.summary,
        section = this.section,
        subSection = this.subSection,
        url = this.url,
        image = this.image
    )
}