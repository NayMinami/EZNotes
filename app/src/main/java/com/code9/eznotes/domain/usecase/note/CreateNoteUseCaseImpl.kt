package com.code9.eznotes.domain.usecase.note

import com.code9.eznotes.domain.model.Note
import com.code9.eznotes.domain.repository.NoteRepository
import com.code9.eznotes.domain.usecase.note.interfaces.CreateNoteUseCase

class CreateNoteUseCaseImpl(private val noteRepository: NoteRepository): CreateNoteUseCase {
    override suspend fun invoke(note: Note): Note {
        return noteRepository.create(note)
    }
}