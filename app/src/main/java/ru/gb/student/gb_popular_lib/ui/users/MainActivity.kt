package ru.gb.student.gb_popular_lib.ui.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import ru.gb.student.gb_popular_lib.app
import ru.gb.student.gb_popular_lib.domain.entities.UserEntity
import ru.gb.student.gb_popular_lib.domain.repos.UsersRepo
import ru.gb.student.gb_popular_lib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UsersContract.View {
    private lateinit var binding: ActivityMainBinding
    private val adapter: UsersAdapter = UsersAdapter()

    private lateinit var presenter: UsersContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        initViews()

        presenter = UsersPresenter(app.usersRepo)
        presenter.attach(this)
    }

    override fun onDestroy() {

        presenter.detach()
        super.onDestroy()
    }

    private fun initViews() {
        setContentView(binding.root)
        showProgress(false)
        binding.refreshButton.setOnClickListener {
            presenter.onRefresh()
        }

        initRecyclerView()
    }

    override fun showUsers(users: List<UserEntity>) {
        adapter.setData(users)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress(inProgress: Boolean) {
        binding.progressBar.isVisible = inProgress
        binding.usersRecyclerView.isVisible = !inProgress
    }

    private fun initRecyclerView() {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.usersRecyclerView.adapter = adapter

    }
}