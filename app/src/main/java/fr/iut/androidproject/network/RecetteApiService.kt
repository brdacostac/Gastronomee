package fr.iut.androidproject.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface RecetteApiService {
    @GET("search.php?f=a")
    suspend fun getRecettes() : Meal

    @GET("random.php")
    suspend fun getRecommended() : Meal

    @GET("categories.php")
    suspend fun getCategories() : Categorie

    //@GET("filter.php?c={strCategory}")
    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") category: String) : Meal

}

object RecetteApi {
    val retrofitService: RecetteApiService by lazy { retrofit.create(RecetteApiService::class.java) }
}