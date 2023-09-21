package hackeru.lesson.project.utils

import okhttp3.Interceptor
import okhttp3.Response


class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        //the original request:
        //https://api.themoviedb.org/3/discover/movie
        val original = chain.request()

        //here i add my own api key to the URL
        val url = original.url.newBuilder()
            .addQueryParameter("api_key", "c1aacf80a4a4b90c291ab3eafdfb5fec")
            .build()

        val request = original.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}