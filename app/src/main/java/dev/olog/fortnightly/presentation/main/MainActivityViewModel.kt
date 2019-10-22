package dev.olog.fortnightly.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.olog.fortnightly.core.ArticlesGateway
import dev.olog.fortnightly.presentation.model.ArticlePresentation
import dev.olog.fortnightly.presentation.model.toPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val gateway: ArticlesGateway
) : ViewModel() {

    private val liveData = MutableLiveData<List<ArticlePresentation>>()

    init {
        viewModelScope.launch {
            val articles = gateway.getTopStories()
            val result = withContext(Dispatchers.Default) {
                articles.map { it.toPresentation() }
            }
            liveData.value = result
        }
    }

    val observeData: LiveData<List<ArticlePresentation>> = liveData

}