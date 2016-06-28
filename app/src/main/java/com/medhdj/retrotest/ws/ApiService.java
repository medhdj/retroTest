package com.medhdj.retrotest.ws;

import com.medhdj.retrotest.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by youness on 26/06/16.
 */
public interface ApiService {
    @GET("users")
    Call<List<User>>getUsers();
}
