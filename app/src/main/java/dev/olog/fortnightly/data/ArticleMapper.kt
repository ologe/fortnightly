package dev.olog.fortnightly.data

import dev.olog.fortnightly.core.Article

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