package com.code9.eznotes.domain.usecase.note

import com.code9.eznotes.domain.model.Note
import com.code9.eznotes.domain.repository.NoteRepository
import com.code9.eznotes.domain.usecase.note.interfaces.UpdateNoteUseCase

class UpdateNoteUseCaseImpl(private val noteRepository: NoteRepository): UpdateNoteUseCase {
    override suspend fun invoke(note: Note): Note {
        return noteRepository.update(note)
    }
}