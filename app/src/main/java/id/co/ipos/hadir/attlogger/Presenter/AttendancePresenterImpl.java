package id.co.ipos.hadir.attlogger.Presenter;

import id.co.ipos.hadir.attlogger.Infrastruktur.Db.CompanyRepository;
import id.co.ipos.hadir.attlogger.Infrastruktur.Net.IposAuth;
import id.co.ipos.hadir.attlogger.Infrastruktur.Net.Token;
import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStore;
import id.co.ipos.hadir.attlogger.View.AttendanceView;
import io.reactivex.Scheduler;

public class AttendancePresenterImpl implements AttendancePresenter {

    private AttendanceView attendanceView;
    private TokenStore tokenStore;
    private IposAuth iPosAuth;
    private CompanyRepository m_companyRepository;
    private Scheduler processScheduler;
    private Scheduler androidScheduler;
    public AttendancePresenterImpl(AttendanceView attendanceView, TokenStore tokenStore,
                                   IposAuth iposAuth, CompanyRepository companyRepository,
                                   Scheduler androidScheduler, Scheduler processScheduler) {
        this.attendanceView = attendanceView;
        this.tokenStore = tokenStore;
        this.iPosAuth = iposAuth;
        this.m_companyRepository = companyRepository;
        this.processScheduler = processScheduler;
        this.androidScheduler = androidScheduler;
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
                //.subscribe(x->successLogin(x), err->errorLogin(err));
                .subscribe(x->{successLogin(x);},err ->{errorLogin(err);
                }
                );
    }

    private void errorLogin(Throwable err) {
        this.attendanceView.showDisplayError();
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
