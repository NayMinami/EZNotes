package com.code9.eznotes.domain.usecase.note.interfaces

import com.code9.eznotes.domain.model.Note

interface ArchiveNoteUseCase {
    suspend operator fun invoke(note: Note): Note
}