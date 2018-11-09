package id.co.ipos.hadir.attlogger.Infrastruktur.Net;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Token{

/*
@Override
    public Token getToken(String username, String password) {
        return null;
    }
*/


    @SerializedName("access_token")
    public String accessToken;

    @SerializedName("token_type")
    public String tokenType;

    @SerializedName("expires_in")
    public Long expiresIn;

    @SerializedName("userName")
    public String userName;

    @SerializedName(".issued")
    public String issued;

    @SerializedName(".expires")
    public Date expires;

}
