package dev.olog.fortnightly.presentation.model

import dev.olog.fortnightly.R
import dev.olog.fortnightly.core.Article

data class ArticlePresentation(
    override val viewType: Int,
    val id: Long,
    val title: String,
    val summary: String,
    val section: String,
    val subSection: String,
    val url: String
) : PresentationModel

fun Article.toPresentation(): ArticlePresentation {
    return ArticlePresentation(
        R.layout.item,
        id = id,
        title = this.title,
        summary = this.summary,
        section = this.section,
        subSection = this.subSection,
        url = this.url
    )
}