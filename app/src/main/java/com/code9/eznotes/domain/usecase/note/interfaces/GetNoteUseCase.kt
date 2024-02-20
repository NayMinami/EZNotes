package com.code9.eznotes.domain.usecase.note.interfaces

import com.code9.eznotes.domain.model.Note

interface GetNoteUseCase {
    suspend operator fun invoke(id: Int): Note
}