package com.ufps.ctiam20.ui.conhog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConHogViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ConHogViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aqui van los productos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}