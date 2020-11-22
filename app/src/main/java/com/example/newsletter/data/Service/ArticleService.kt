package com.example.newsletter.data.Service

import com.example.newsletter.models.Article
import com.example.newsletter.models.ArticleResponse

interface ArticleService {
    fun getArticles(subject : String): ArticleResponse
}