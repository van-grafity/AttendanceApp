package id.co.ipos.hadir.attlogger.Presenter;

import javax.inject.Inject;

import id.co.ipos.hadir.attlogger.Infrastruktur.Db.CompanyRepository;
import id.co.ipos.hadir.attlogger.Infrastruktur.Net.IposAuth;
import id.co.ipos.hadir.attlogger.Infrastruktur.Net.Token;
import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStore;
import id.co.ipos.hadir.attlogger.View.AttendanceView;
import io.reactivex.Scheduler;

public class AttendancePresenterImpl implements AttendancePresenter {
    @Inject
    AttendanceView attendanceView;
    @Inject
    TokenStore tokenStore;
    @Inject
    IposAuth iPosAuth;
    @Inject
     CompanyRepository m_companyRepository;
    @Inject
     Scheduler processScheduler;
    @Inject
     Scheduler androidScheduler;


    @Inject
    public AttendancePresenterImpl() {

    }

    @Override
    public void prepare() {
        if (this.tokenStore.isTokenExist() && !this.tokenStore.isTokenExpired()) {
                this.attendanceView.showReadyState();
        }

         else {
            this.attendanceView.showLoginState();
        }
    }

    @Override
    public void login() {
        String username = attendanceView.getUsername();
        String password = attendanceView.getPassword();
        iPosAuth.getToken(username, password)
                .subscribeOn(processScheduler)
                .observeOn(androidScheduler)
                .subscribe(x->successLogin(x),err ->errorLogin(err));
    }

    private void errorLogin(Throwable err) {
        this.attendanceView.showDisplayError(err.getMessage());
    }

    private void successLogin(Token token){
        tokenStore.saveToken(token);

        if (!this.m_companyRepository.isCompanyExist()){
            this.attendanceView.downloadData();

        }else{
            this.attendanceView.showReadyState();
        }

    }
}
