package com.ufps.ctiam20.ui.lp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LpViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LpViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aqui va los datos de las tiendas.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}