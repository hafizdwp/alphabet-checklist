package com.hafizdwp.alphabet_checklist.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author hafizdwp
 * 20/05/2021
 **/
abstract class BaseViewModel : ViewModel() {

    suspend fun <T> withIO(action: suspend () -> T): T {
        return withContext(Dispatchers.IO) { action() }
    }

    suspend fun <T> withDefault(action: suspend () -> T): T {
        return withContext(Dispatchers.Default) { action() }
    }
}