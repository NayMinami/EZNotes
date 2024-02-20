package com.code9.eznotes.domain.usecase.note

import com.code9.eznotes.domain.model.Note
import com.code9.eznotes.domain.repository.NoteRepository
import com.code9.eznotes.domain.usecase.note.interfaces.DeleteNoteUseCase

class DeleteNoteUseCaseImpl(private val noteRepository: NoteRepository): DeleteNoteUseCase {
    override suspend fun invoke(note: Note) {
        noteRepository.delete(note)
    }
}