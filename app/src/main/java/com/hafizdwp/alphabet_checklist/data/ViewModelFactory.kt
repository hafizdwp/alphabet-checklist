package com.hafizdwp.alphabet_checklist.data

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hafizdwp.alphabet_checklist.MainViewModel
import com.hafizdwp.alphabet_checklist.ktor.ktorHttpClient

/**
 * @author hafizdwp
 * 17/05/2021
 **/
class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(repository)
            else ->
                throw IllegalArgumentException("Unknown ViewModel class")
        } as T
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(application: Application) =
                instance ?: synchronized(ViewModelFactory::class.java) {
                    instance ?: ViewModelFactory(provideRepository(application.applicationContext))
                            .also { instance = it }
                }

        private fun provideRepository(context: Context): Repository {
//            val database = Database.getInstance(context)
            val rds = RemoteDataSource(ktorHttpClient)
            val lds = LocalDataSource.getInstance()

            return Repository.getInstance(rds, lds)
        }
    }
}