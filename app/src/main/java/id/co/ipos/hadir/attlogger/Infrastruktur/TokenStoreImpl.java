package id.co.ipos.hadir.attlogger.Infrastruktur;

import android.content.Context;

import id.co.ipos.hadir.attlogger.Infrastruktur.Net.Token;

public class TokenStoreImpl implements TokenStore {
    private Context m_applicationContext;

    public TokenStoreImpl(Context applicationContext) {
        m_applicationContext = applicationContext;
    }

    @Override
    public boolean isTokenExist() {
        return false;
    }

    @Override
    public boolean isTokenExpired() {
        return false;
    }

    @Override
    public void saveToken(Token token) {

    }
}
