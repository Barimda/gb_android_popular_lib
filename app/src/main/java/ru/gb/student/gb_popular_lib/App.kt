package ru.gb.student.gb_popular_lib

import android.app.Application
import android.content.Context
import ru.gb.student.gb_popular_lib.data.FakeUsersRepoImpl
import ru.gb.student.gb_popular_lib.domain.repos.UsersRepo

class App : Application() {
    val usersRepo: UsersRepo by lazy { FakeUsersRepoImpl() }
}

val Context.app:App get() = applicationContext as App