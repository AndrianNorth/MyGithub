package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.FragmentUserBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.GithubUsersRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.UsersPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.BackButtonListener

class UserFragment private constructor() : MvpAppCompatFragment(), BackButtonListener {

    companion object {
        fun getInstance(args: Bundle?): UserFragment{
            val userFragment = UserFragment()
            userFragment.arguments
            return userFragment
        }
    }

    private var vb: FragmentUserBinding? = null
    val presenter by moxyPresenter { UsersPresenter(GithubUsersRepo(), App.instance.router) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        vb = it
        vb?.tvUser?.text = arguments.toString()
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = presenter.backClick()

}