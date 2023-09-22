import com.firebase.ui.auth.data.model.User
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    @FormUrlEncoded
    suspend fun signIn(
        @Field("email") email: String,
        @Field("password") password: String
    ): User // Tipo de retorno modificado

    @POST("register")
    @FormUrlEncoded
    suspend fun register(
        @Field("email") email: String,
        @Field("password") password: String
    ): User // Tipo de retorno modificado
}
