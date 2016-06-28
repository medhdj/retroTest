package com.medhdj.retrotest.ws;

import android.util.Log;

import com.medhdj.retrotest.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by youness on 26/06/16.
 */
public class RestClient {
    private static final String TAG = "RestClient";

    Retrofit retrofit;
    ApiService apiService;

    public RestClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public void getUsers(final RestDelegate restDelegate) {
        Call<List<User>> call = apiService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users = response.body();
                restDelegate.onSuccess(users);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e(TAG,t.getMessage());
            }
        });
    }

}
