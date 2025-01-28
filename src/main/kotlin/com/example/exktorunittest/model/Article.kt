package com.example.exktorunittest.model

data class Article(
    var id: Long = 0,
    var title: String = "",
    var body: String = "",
    var authorId: Long? = null,
)