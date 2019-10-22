package dev.olog.fortnightly.presentation.main

import coil.api.load
import dev.olog.fortnightly.presentation.base.AbsAdapter
import dev.olog.fortnightly.presentation.base.DataBoundViewHolder
import dev.olog.fortnightly.presentation.model.ArticlePresentation
import dev.olog.fortnightly.presentation.model.BigArticle
import dev.olog.fortnightly.presentation.model.DiffCallbackArticlePresentation
import dev.olog.fortnightly.presentation.model.SmallArticle
import dev.olog.fortnightly.utils.exhaustive
import kotlinx.android.synthetic.main.item_article_big.view.*

class MainActivityAdapter : AbsAdapter<ArticlePresentation>(DiffCallbackArticlePresentation) {

    override fun initViewHolderListeners(viewHolder: DataBoundViewHolder, viewType: Int) {

    }

    override fun bind(holder: DataBoundViewHolder, item: ArticlePresentation, position: Int) {
        when (item) {
            is BigArticle -> bindBigArticle(holder, item)
            is SmallArticle -> bindSmallArticle(holder, item)
        }.exhaustive
    }

    private fun bindBigArticle(holder: DataBoundViewHolder, item: BigArticle) {
        holder.itemView.apply {
            image.load(item.image)
            section.text = item.section
            title.text = item.title
        }
    }

    private fun bindSmallArticle(holder: DataBoundViewHolder, item: SmallArticle) {
        holder.itemView.apply {
            image.load(item.image)
            section.text = item.section
            title.text = item.title
        }
    }

}