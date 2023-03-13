package ru.gb.student.gb_popular_lib.ui.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.gb.student.gb_popular_lib.app
import ru.gb.student.gb_popular_lib.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserInfoBinding
    private lateinit var presenter: UsersContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = extractPresenter()
//        presenter.attach(this)

        binding.userInfoActivityButtonBack.setOnClickListener(){
            //todo back to main screen
        }
    }

    private fun extractPresenter(): UsersContract.Presenter {
        return lastCustomNonConfigurationInstance as? UsersContract.Presenter
            ?: UsersPresenter(app.usersRepo)
    }
}