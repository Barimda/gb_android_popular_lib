package ru.gb.student.gb_popular_lib.ui.users

import ru.gb.student.gb_popular_lib.domain.entities.UserEntity

interface UsersContract {

    interface View {
        fun showUsers(data:List<UserEntity>)
        fun showError(throwable: Throwable)
        fun showProgress(inProgress: Boolean)
    }

    interface Presenter {
        fun attach(view: View)
        fun detach()

        fun onRefresh()
    }
}