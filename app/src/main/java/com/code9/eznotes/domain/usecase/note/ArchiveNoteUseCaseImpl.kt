package com.code9.eznotes.domain.usecase.note

import com.code9.eznotes.domain.model.Note
import com.code9.eznotes.domain.repository.NoteRepository
import com.code9.eznotes.domain.usecase.note.interfaces.ArchiveNoteUseCase

class ArchiveNoteUseCaseImpl(private val noteRepository: NoteRepository): ArchiveNoteUseCase {
    override suspend fun invoke(note: Note): Note {
        return noteRepository.update(note.copy(isArchived = true))
    }
}