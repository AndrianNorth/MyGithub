package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo

import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser

class GithubUsersRepo {
    private val users = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5"),
        GithubUser("login6"),
        GithubUser("login7"),
    )

        fun userObserver(): Observable<List<GithubUser>> = Observable.fromCallable{
            users
        }

}

    // Разница между switchmap и flatmap в том, что последний подписан на все observable и выводит все результаты,
    // а первый при появлении нового observable отписывается от предыдущего и начинает выводить текущий.
