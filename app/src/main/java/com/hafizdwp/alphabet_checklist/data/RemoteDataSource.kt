package com.hafizdwp.alphabet_checklist.data

import com.hafizdwp.alphabet_checklist.ktor.Endpoint
import com.hafizdwp.alphabet_checklist.ktor.RandomFact
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * @author hafizdwp
 * 17/05/2021
 **/
class RemoteDataSource(private val api: HttpClient) {

    suspend fun getRandomFact(): RandomFact {
        return api.get(Endpoint.GITHUB)
    }
}