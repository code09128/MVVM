package com.drs24.myapplication.Repository;

import com.drs24.myapplication.Model.DataList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dustin0128 on 2020/3/13
 */
public interface APIInterface {

    @GET("PublicHolidays/2019/us")
    Call<List<DataList>> getDataLists();
}
