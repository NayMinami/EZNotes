package com.code9.eznotes.domain.repository

interface BaseRepository<T> {

    fun get(id: Int): T

    fun getAll(): List<T>

    fun create(thing: T): T

    fun update(thing: T): T

    fun delete(thing: T)
}