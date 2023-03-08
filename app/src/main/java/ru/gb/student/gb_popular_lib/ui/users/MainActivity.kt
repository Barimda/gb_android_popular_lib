package ru.gb.student.gb_popular_lib.ui.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import ru.gb.student.gb_popular_lib.App
import ru.gb.student.gb_popular_lib.app
import ru.gb.student.gb_popular_lib.data.FakeUsersRepoImpl
import ru.gb.student.gb_popular_lib.domain.UserEntity
import ru.gb.student.gb_popular_lib.domain.UsersRepo
import ru.gb.student.gb_popular_lib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter: UsersAdapter = UsersAdapter()
    private val usersRepo: UsersRepo by lazy { app.usersRepo }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        setContentView(binding.root)
        showProgress(false)
        binding.refreshButton.setOnClickListener {
            loadData()
        }

        initRecyclerView()
    }

    private fun loadData() {
        showProgress(true)
        usersRepo.getUsers(
            onSuccess = {
                showProgress(false)
                onDataLoaded(it)
            },
            onError = {
                showProgress(false)
                onError(it)
            })
    }
    private fun onDataLoaded(data:List<UserEntity>) {
        adapter.setData(data)
    }
    private fun onError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    private fun initRecyclerView() {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.usersRecyclerView.adapter = adapter

    }

    private fun showProgress(inProgress: Boolean) {
        binding.progressBar.isVisible = inProgress
        binding.usersRecyclerView.isVisible = !inProgress
    }
}