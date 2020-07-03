package com.drs24.myapplication.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.drs24.myapplication.AppDelegate;
import com.drs24.myapplication.Model.DataList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dustin0128 on 2020/3/13
 * Repository 是從來源(Source)取得資料加以處理
 */
public class DataListRepo {
    private final String TAG = getClass().getSimpleName();


    public MutableLiveData<List<DataList>> requestDataLists() {
        final MutableLiveData<List<DataList>> mutableLiveData = new MutableLiveData<>();

        APIInterface apiService = AppDelegate.getRetrofitClient().create(APIInterface.class);

        apiService.getDataLists().enqueue(new Callback<List<DataList>>() {
            @Override
            public void onResponse(Call<List<DataList>> call, Response<List<DataList>> response) {
                Log.e(TAG, "getCurrencyList response="+response );

                if (response.isSuccessful() && response.body()!=null ) {
                    Log.e(TAG, "requestHolidays response.size="+response.body().size() );
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<DataList>> call, Throwable t) {
                Log.e(TAG, "getProdList onFailure" + call.toString());
            }
        });

        return mutableLiveData;
    }
}
