package id.co.ipos.hadir.attlogger.Infrastruktur.Dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStore;
import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStoreImpl;

@Module
public class TokenStoreModule {
    @Provides
    TokenStore provideTokenStoreImpl(Context applicationContext){
        return new TokenStoreImpl(applicationContext);
    }
}
