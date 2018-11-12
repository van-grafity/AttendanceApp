package id.co.ipos.hadir.attlogger.Application.Dagger;

import dagger.Component;
import id.co.ipos.hadir.attlogger.Infrastruktur.Dagger.TokenStoreModule;
import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStore;

@Component (modules = {TokenStoreModule.class, AppContextModule.class})
public interface AppAttendanceComponent {
    TokenStore getTokenStore();
}
