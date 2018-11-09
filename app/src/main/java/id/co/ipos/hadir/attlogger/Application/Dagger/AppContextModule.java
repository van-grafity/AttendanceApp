package id.co.ipos.hadir.attlogger.Application.Dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppContextModule {
    private Context context;

    public AppContextModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext(){
        return context;
    }
}
