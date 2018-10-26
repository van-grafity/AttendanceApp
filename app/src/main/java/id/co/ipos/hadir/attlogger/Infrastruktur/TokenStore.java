package id.co.ipos.hadir.attlogger.Infrastruktur;

public interface TokenStore {
    boolean isTokenExist();
    boolean isTokenExpired();
}
