package com.ufps.ctiam20.ui.tiendas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TiendasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TiendasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aqui va los datos de las tiendas.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}