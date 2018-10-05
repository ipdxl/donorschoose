package com.altimetrik.donorschoose.api;

import com.altimetrik.donorschoose.data.SearchResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by José Guadalupe Mandujano on 10/5/18.
 */
public interface IDonorsChooseClient {

    @GET("json_feed.html")
    Observable<SearchResponse> search(@QueryMap(encoded = true) Map<String, Object> filter);
}
