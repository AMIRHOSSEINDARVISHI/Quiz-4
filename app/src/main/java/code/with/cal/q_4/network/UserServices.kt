package code.with.cal.network

import android.telecom.Call
import code.with.cal.model.CreateUser
import code.with.cal.model.User
import okhttp3.MultipartBody

import retrofit2.http.*

interface UserServices {
    @POST("users")
    fun createUser(@Body body: CreateUser): retrofit2.Call<String>

    @Multipart
    @POST("users/{userId}/image")
    fun uploadImageUser(
        @Path("userId") id: String,
        @Part image: MultipartBody.Part
    ): retrofit2.Call<Any>

    @GET("users")
    fun getUsers(): retrofit2.Call<List<User>>
}