package cn.ben.learnretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

@SuppressWarnings("SameParameterValue")
interface IPService {
    @GET("/bdyunfenxi/intelligence/ip")
    Call<IPResult> getResult(@Header("apikey") String apikey, @Query("ip") String ip);

    @GET("/bdyunfenxi/intelligence/ip")
    Observable<IPResult> getIPResult(@Header("apikey") String apikey, @Query("ip") String ip);
}
