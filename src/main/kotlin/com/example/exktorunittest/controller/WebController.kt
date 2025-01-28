package com.example.exktorunittest.controller

import com.example.exktorunittest.model.Article
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import kotlin.contracts.contract

@RestController
@RequestMapping("/article")
class WebController {
    val logger = KotlinLogging.logger {}
    val dataSource = mutableListOf(
        Article(
            id = 1,
            title = "title1",
            body = "body1",
            authorId = 1
        ),
        Article(
            id = 2,
            title = "title2",
            body = "body2",
            authorId = 2
        )
    )

    data class RegCreate(
        val title: String,
        val body: String,
        val authorId: Long
    )

    data class RegUpdate(
        val title: String,
        val body: String
    )

    @GetMapping("/all")
    fun getAll(@RequestParam title: String?): List<Article> {
        logger.info("get all article")
        return dataSource.filter { it.title.contains(title ?: "", ignoreCase = true) }
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): Article {
        logger.info("get article id: $id")
        return dataSource.first { it.id == id }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: RegCreate): Article {
        logger.info("create article")
        val new = Article(
            id = dataSource.size.toLong() + 1,
            title = request.title,
            body = request.body,
            authorId = request.authorId
        )
        dataSource.add(new)
        return new
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: RegUpdate): Article {
        logger.info("update article id: $id")
        val target = dataSource.first { it.id == id }
        target.title = request.title
        target.body = request.body
        return target
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        logger.info("delete article id: $id")
        dataSource.removeIf { it.id == id }
    }
}