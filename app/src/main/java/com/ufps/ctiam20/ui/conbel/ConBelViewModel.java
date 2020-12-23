package com.ufps.ctiam20.ui.conbel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConBelViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ConBelViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aqui van los productos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}