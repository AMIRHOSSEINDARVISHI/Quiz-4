package code.with.cal.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    private val addHeaderClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .addHeader("Authorization", "Bearer bkjcsbcg687hwgjhgksc")
                .build()
            chain.proceed(request)
        }
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val userRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://papp.ir/api/v1/")
        .client(addHeaderClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userService = userRetrofit.create(UserServices::class.java)
}