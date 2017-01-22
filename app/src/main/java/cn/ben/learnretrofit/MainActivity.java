package cn.ben.learnretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface service = retrofit.create(APIInterface.class);
        Call<TestModel> model = service.repo("Guolei1130");

        model.enqueue(new Callback<TestModel>() {
            @Override
            public void onResponse(Call<TestModel> call, Response<TestModel> response) {
                // Log.e("Test", response.body().getLogin());
                Log.d(TAG, response.body().getLogin());
                Log.d(TAG, response.body().getAvatar_url());
            }

            @Override
            public void onFailure(Call<TestModel> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });

        query();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Log.d(TAG, "main thread: " + Thread.currentThread().getId());
        IPService ipService = retrofit.create(IPService.class);
        ipService.getIPResult(API_KEY, "115.239.210.27")
                .subscribeOn(Schedulers.newThread()) // 子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IPResult>() {

                    @Override
                    public void onNext(IPResult ipResult) {
                        if (ipResult != null) {
                            Log.d(TAG, "handle: " + ipResult);
                            Log.d(TAG, "thread: " + Thread.currentThread().getId());
                        }
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    private static final String BASE_URL = "http://apis.baidu.com";
    private static final String API_KEY = "2e6f8b920859a476254f77b1b9c225d6";

    private void query() {
        //1.创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())//解析方法
                .baseUrl(BASE_URL)//主机地址
                .build();

        //2.创建访问API的请求
        IPService service = retrofit.create(IPService.class);
        Call<IPResult> call = service.getResult(API_KEY, "115.239.210.27");

        //3.发送请求
        call.enqueue(new Callback<IPResult>() {
            @Override
            public void onResponse(Call<IPResult> call, Response<IPResult> response) {
                //4.处理结果
                if (response.isSuccessful()) {
                    IPResult result = response.body();
                    if (result != null) {
                        Log.d(TAG, "handle: " + result);
                    }
                }
            }

            @Override
            public void onFailure(Call<IPResult> call, Throwable t) {
                Log.d(TAG, "error: " + t.getMessage());
            }
        });
    }
}
