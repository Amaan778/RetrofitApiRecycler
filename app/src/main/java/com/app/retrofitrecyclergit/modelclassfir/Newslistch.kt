package com.app.newsappcreate.modelclassfir

data class Newslistch(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)