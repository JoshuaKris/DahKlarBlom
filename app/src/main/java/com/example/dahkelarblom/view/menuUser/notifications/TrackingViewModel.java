package com.example.dahkelarblom.view.menuUser.notifications;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dahkelarblom.service.InternetService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackingViewModel extends ViewModel {

    private final InternetService internetService;
    private Call<String> apiCall;

    private MutableLiveData<String> mText;

    public LiveData<String> getText() {
        return mText;
    }

    public TrackingViewModel(Context context) {
        internetService = new InternetService(context);
    }

    public void fetchBooking(String code) {
        apiCall = InternetService.getServicesApi().trackMyBooking(code);
        apiCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}