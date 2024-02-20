package com.code9.eznotes.domain.usecase.note

import com.code9.eznotes.domain.model.Note
import com.code9.eznotes.domain.repository.NoteRepository
import com.code9.eznotes.domain.usecase.note.interfaces.GetAllNotesUseCase

class GetAllNotesUseCaseImpl(private val noteRepository: NoteRepository): GetAllNotesUseCase {
    override suspend fun invoke(): List<Note> {
        return noteRepository.getAll()
    }
}