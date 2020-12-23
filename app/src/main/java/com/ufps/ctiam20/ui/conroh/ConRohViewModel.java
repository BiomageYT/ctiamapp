package com.ufps.ctiam20.ui.conroh;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConRohViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ConRohViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aqui van los productos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}