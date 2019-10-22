package dev.olog.fortnightly.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import retrofit2.Response

/**
 * Simple network request with linear retry policy.
 * Note that the function will run on the caller thread.
 */
internal suspend fun <T> networkCall(repeatTimes: Int = 3, call: suspend () -> Response<T>): T {
    var response: Response<T>? = null

    repeat(repeatTimes) { iteration ->
        delay(1000L * iteration)
        val result = call()
        if (result.isSuccessful) {
            return result.body()!!
        }
        response = result
        yield()
    }

    throw RuntimeException(response.toString())
}
