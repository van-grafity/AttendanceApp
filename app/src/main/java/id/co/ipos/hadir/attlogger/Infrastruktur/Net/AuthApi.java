package id.co.ipos.hadir.attlogger.Infrastruktur.Net;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface AuthApi {
     @FormUrlEncoded
     @POST("token")
     Observable<Token> getToken(@Field("username") String username,
                                @Field("password") String password,
                                @Field("grant_type") String grantType);
}
