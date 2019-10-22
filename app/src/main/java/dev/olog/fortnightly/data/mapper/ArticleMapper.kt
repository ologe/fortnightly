package dev.olog.fortnightly.data.mapper

import dev.olog.fortnightly.core.Article
import dev.olog.fortnightly.data.entity.Result

fun Result.toDomain(): Article {
    return Article(
        id = this.url.hashCode().toLong(), // TODO hacky
        title = this.title,
        summary = this.abstract,
        section = this.section,
        subSection = this.subsection,
        url = this.url
    )
}