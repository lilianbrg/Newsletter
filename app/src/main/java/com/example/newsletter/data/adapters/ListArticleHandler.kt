package com.example.newsletter.data.adapters

import com.example.newsletter.models.Article

interface ListArticleHandler {
    fun showArticle(article: Article)
    fun back()
    fun showPage(url: String)
}