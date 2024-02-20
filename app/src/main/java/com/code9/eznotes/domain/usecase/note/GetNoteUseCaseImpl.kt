package com.code9.eznotes.domain.usecase.note

import com.code9.eznotes.domain.model.Note
import com.code9.eznotes.domain.repository.NoteRepository
import com.code9.eznotes.domain.usecase.note.interfaces.GetNoteUseCase

class GetNoteUseCaseImpl(private val noteRepository: NoteRepository): GetNoteUseCase {
    override suspend fun invoke(id: Int): Note {
        return noteRepository.get(id)
    }
}