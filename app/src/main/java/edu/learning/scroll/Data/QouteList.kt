package edu.learning.scroll.Data

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Qoute>,
    val totalCount: Int,
    val totalPages: Int
)