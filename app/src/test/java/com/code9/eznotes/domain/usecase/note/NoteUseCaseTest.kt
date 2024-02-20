package com.code9.eznotes.domain.usecase.note

import com.code9.eznotes.domain.model.Note
import com.code9.eznotes.domain.repository.NoteRepository
import com.code9.eznotes.domain.usecase.note.AddNoteToFavoritesUseCaseImpl
import com.code9.eznotes.domain.usecase.note.ArchiveNoteUseCaseImpl
import com.code9.eznotes.domain.usecase.note.CreateNoteUseCaseImpl
import com.code9.eznotes.domain.usecase.note.DeleteNoteUseCaseImpl
import com.code9.eznotes.domain.usecase.note.GetAllNotesUseCaseImpl
import com.code9.eznotes.domain.usecase.note.GetNoteUseCaseImpl
import com.code9.eznotes.domain.usecase.note.UpdateNoteUseCaseImpl
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class NoteUseCaseTest {

    private val repository = mockk<NoteRepository>(relaxed = true)
    private val note = Note(
        id = 1,
        label = "Test",
        content = "Test test",
        updatedDate = 123456123L,
        isFavorite = false,
        isArchived = false,
    )
    private val notes = listOf(
        note,
        note.copy(label = "Test2"),
        note.copy(label = "Test3"),
        note.copy(label = "Test4"),
    )

    @Test
    fun addNoteToFavoriteUseCase() = runTest {
        every { repository.update(any()) } returnsArgument 0

        val useCase = AddNoteToFavoritesUseCaseImpl(repository)

        Assert.assertEquals(note.copy(isFavorite = true), useCase(note))
    }

    @Test
    fun archiveNoteUseCase() = runTest {
        every { repository.update(any()) } returnsArgument 0

        val useCase = ArchiveNoteUseCaseImpl(repository)

        Assert.assertEquals(note.copy(isArchived = true), useCase(note))
    }

    @Test
    fun createNoteUseCase() = runTest {
        every { repository.create(any()) } returnsArgument 0

        val useCase = CreateNoteUseCaseImpl(repository)

        Assert.assertEquals(note, useCase(note))
    }

    @Test
    fun deleteNoteUseCase() = runTest {
        val useCase = DeleteNoteUseCaseImpl(repository)
        useCase(note)

        verify { repository.delete(note) }
    }

    @Test
    fun getAllNoteUseCase() = runTest {
        every { repository.getAll() } returns notes

        val useCase = GetAllNotesUseCaseImpl(repository)

        Assert.assertEquals(notes, useCase())
    }

    @Test
    fun getNoteUseCase() = runTest {
        every { repository.get(note.id) } returns note

        val useCase = GetNoteUseCaseImpl(repository)

        Assert.assertEquals(note, useCase(note.id))
    }

    @Test
    fun updateNoteUseCase() = runTest {
        every { repository.update(any()) } returnsArgument 0

        val useCase = UpdateNoteUseCaseImpl(repository)

        Assert.assertEquals(note, useCase(note))
    }
}