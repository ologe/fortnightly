package dev.olog.fortnightly.presentation.model

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

object DiffCallbackArticlePresentation : DiffUtil.ItemCallback<ArticlePresentation>() {

    override fun areItemsTheSame(
        oldItem: ArticlePresentation,
        newItem: ArticlePresentation
    ): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: ArticlePresentation,
        newItem: ArticlePresentation
    ): Boolean {
        return oldItem == newItem
    }
}