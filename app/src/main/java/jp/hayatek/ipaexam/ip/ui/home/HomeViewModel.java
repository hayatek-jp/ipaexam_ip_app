package jp.hayatek.ipaexam.ip.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mCountdownText;

    public HomeViewModel() {
        mCountdownText = new MutableLiveData<>();
        mCountdownText.setValue("試験まであと∞日");
    }

    public LiveData<String> getText() {
        return mCountdownText;
    }
}
