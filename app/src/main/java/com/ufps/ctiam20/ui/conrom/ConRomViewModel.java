package com.ufps.ctiam20.ui.conrom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConRomViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ConRomViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aqui van los productos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}