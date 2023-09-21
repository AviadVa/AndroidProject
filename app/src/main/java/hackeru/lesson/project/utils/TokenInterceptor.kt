package hackeru.lesson.project.utils

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        //the original request:
        //https://api.themoviedb.org/3/discover/movie?sort_by=vote_average.desc
        val original = chain.request()

        val url = original.url.newBuilder()
            .addQueryParameter("api_key", "b3b1492d3e91e9f9403a2989f3031b0c")
            .build()

        val request = original.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}