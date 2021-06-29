package com.hafizdwp.alphabet_checklist.ktor

import com.hafizdwp.alphabet_checklist.app.MyApplication
import com.readystatesoftware.chuck.ChuckInterceptor
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * @author hafizdwp
 * 20/05/2021
 **/

val ktorHttpClient by lazy {

    HttpClient(OkHttp) {

        defaultRequest {
            host = Endpoint.BASE_URL
            url {
                protocol = URLProtocol.HTTPS
            }
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        engine {
            addInterceptor(ChuckInterceptor(MyApplication.getInstance()))
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 15000L
            connectTimeoutMillis = 15000L
            socketTimeoutMillis = 15000L
        }
    }
}