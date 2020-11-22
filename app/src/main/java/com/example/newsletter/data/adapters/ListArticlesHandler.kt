package com.example.newsletter.data.adapters

import com.example.newsletter.models.Article

interface ListArticlesHandler {
    fun showArticle(article: Article)
    fun back()
    fun showPage(url: String)
}