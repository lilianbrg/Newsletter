package com.example.newsletter.data.service

import com.example.newsletter.models.ArticleResponse

interface ArticleService {
    fun getArticles(subject : String): ArticleResponse
}