package com.ufps.ctiam20.ui.cc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CcViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CcViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aqui va los datos de las tiendas.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}