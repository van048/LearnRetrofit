package cn.ben.learnretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface APIInterface {
    @GET("/users/{user}")
    Call<TestModel> repo(@SuppressWarnings("SameParameterValue") @Path("user") String user);
}
