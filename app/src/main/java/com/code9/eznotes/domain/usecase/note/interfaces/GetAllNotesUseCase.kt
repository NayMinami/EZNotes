package com.code9.eznotes.domain.usecase.note.interfaces

import com.code9.eznotes.domain.model.Note

interface GetAllNotesUseCase {
    suspend operator fun invoke(): List<Note>
}