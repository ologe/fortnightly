package dev.olog.fortnightly.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleService {

    @GET("/svc/topstories/v2/{section}.json?api-key=2voMAqUaP5Dg6ArIx1Z58vlbxjhzb51K&page=1")
    suspend fun fetchTopStories(@Path("section") section: String = "home"): Response<TopArticlesRemote>

}