package com.altimetrik.donorschoose.api;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by José Guadalupe Mandujano on 10/5/18.
 */
public class ApiClient {
    private static IDonorsChooseClient mClient;

    private ApiClient() {
    }

    /**
     * @return A static {@link IDonorsChooseClient} client
     */
    public static IDonorsChooseClient getClient() {
        if (mClient != null) {
            return mClient;
        }
        Retrofit retrofit;

        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(Gender.class, new GenderAdapter())
//                .registerTypeAdapter(RoleType.class, new RoleTypeAdapter())
//                .registerTypeAdapter(Date.class, new DateDeserializer())
                .create();

        OkHttpClient client = ApiClient.getOkHttpClientInstance();

        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Constants.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(
                        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.newThread()))
                .build();

        mClient = retrofit.create(IDonorsChooseClient.class);
        return mClient;
    }

    @NonNull
    private static OkHttpClient getOkHttpClientInstance() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.MINUTES)
                .readTimeout(3, TimeUnit.MINUTES)
                .addInterceptor(loggingInterceptor)
                .build();
    }
}