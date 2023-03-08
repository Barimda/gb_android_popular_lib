package ru.gb.student.gb_popular_lib.domain.repos

import ru.gb.student.gb_popular_lib.domain.entities.UserEntity

interface UsersRepo {
    fun getUsers(
        onSuccess: (List<UserEntity>) -> Unit,
        onError: ((Throwable) -> Unit)? = null)
}