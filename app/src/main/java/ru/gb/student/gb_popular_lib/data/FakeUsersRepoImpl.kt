package ru.gb.student.gb_popular_lib.data

import android.os.Handler
import android.os.Looper
import ru.gb.student.gb_popular_lib.domain.entities.UserEntity
import ru.gb.student.gb_popular_lib.domain.repos.UsersRepo
private const val DATA_LOADING_FAKE_DELAY = 3_000L
class FakeUsersRepoImpl : UsersRepo {
    private val data: List<UserEntity> = listOf(
        UserEntity(
            "login 1",
            1,
            "https://play-lh.googleusercontent.com/IeNJWoKYx1waOhfWF6TiuSiWBLfqLb18lmZYXSgsH1fvb8v1IYiZr5aYWe0Gxu-pVZX3"
        ),
        UserEntity(
            "login 2",
            2,
            "https://play-lh.googleusercontent.com/IeNJWoKYx1waOhfWF6TiuSiWBLfqLb18lmZYXSgsH1fvb8v1IYiZr5aYWe0Gxu-pVZX3"
        ), //https://avatars.githubuserscontent.com/u/2?v=4
        UserEntity(
            "login 3",
            3,
            "https://play-lh.googleusercontent.com/IeNJWoKYx1waOhfWF6TiuSiWBLfqLb18lmZYXSgsH1fvb8v1IYiZr5aYWe0Gxu-pVZX3"
        )
    )

    override fun getUsers(onSuccess: (List<UserEntity>) -> Unit, onError: ((Throwable) -> Unit)?) {
        Handler(Looper.getMainLooper()).postDelayed({
            onSuccess(data)
        }, DATA_LOADING_FAKE_DELAY)
    }
}