package id.co.ipos.hadir.attlogger.Infrastruktur.Net;


import io.reactivex.Observable;

public interface IposAuth {
    Observable<Token> getToken(String username, String password);

}
