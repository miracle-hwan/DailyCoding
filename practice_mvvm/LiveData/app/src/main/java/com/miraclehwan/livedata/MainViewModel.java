package com.miraclehwan.livedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName(){
        if (currentName == null){
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }

    public void buttonClick(){
        currentName.setValue("버튼1111");
    }

    public void buttonClick2(){
        currentName.setValue("버튼2222");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e("miraclehwan", "onCleared");
    }
}
