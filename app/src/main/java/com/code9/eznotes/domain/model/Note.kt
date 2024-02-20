package com.code9.eznotes.domain.model

data class Note(
    val id: Int,
    val label: String,
    val content: String,
    val updatedDate: Long,
    val isFavorite: Boolean,
    val isArchived: Boolean,
)