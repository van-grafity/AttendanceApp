package id.co.ipos.hadir.attlogger.Infrastruktur;

import id.co.ipos.hadir.attlogger.Infrastruktur.Net.Token;

public interface TokenStore {
    boolean isTokenExist();

    boolean isTokenExpired();

    void saveToken(Token token);
}
