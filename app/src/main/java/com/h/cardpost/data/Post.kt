package com.h.cardpost.data

data class Post(
    private var text: String,
    private var date: String,
    private var like: Like,
    private var comment: Comment,
    private var reply: Repost) {
}