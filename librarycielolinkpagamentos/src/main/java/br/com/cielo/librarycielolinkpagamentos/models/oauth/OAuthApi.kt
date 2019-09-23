package br.com.cielo.librarycielolinkpagamentos.models.oauth

import br.com.cielo.librarycielolinkpagamentos.models.oauth.AuthClientModel
import retrofit2.Call
import retrofit2.http.*

interface OAuthApi {
    @FormUrlEncoded
    @POST("v2/token")
    fun getTokenOAuth(
        @Header("authorization") authorization: String,
        @Field("grant_type") grant_type: String
    ): Call<AuthClientModel>
}