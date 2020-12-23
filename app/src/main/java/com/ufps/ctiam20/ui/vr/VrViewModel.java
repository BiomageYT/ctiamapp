package com.ufps.ctiam20.ui.vr;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VrViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VrViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aqui va los datos de las tiendas.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
