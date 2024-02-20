package com.code9.eznotes.domain.repository

import com.code9.eznotes.domain.model.Note

interface NoteRepository: BaseRepository<Note> {

    fun search(search: String): List<Note>
}