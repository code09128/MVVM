package com.drs24.myapplication.VewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.drs24.myapplication.Model.DataList;
import com.drs24.myapplication.Repository.DataListRepo;

import java.util.List;

/**
 * Created by dustin0128 on 2020/3/13
 */
public class DataListViewModel {

    private DataListRepo dataListRepo;
    private MutableLiveData<List<DataList>> mutableLiveData;

    public DataListViewModel(){
        dataListRepo = new DataListRepo();
    }

    /**LiveData 是 Google 開發出來的幫我們處理生命週期時資料存活的工具
     * 也就是說你跟 LiveData 講要跟著誰的(Owner 是哪個 Activity 或 Fragment)生命週期
     * 那麼它就會隨著該 Owner 活著或消滅。*/
    public LiveData<List<DataList>> getDataList() {
        if(mutableLiveData==null){
            mutableLiveData = dataListRepo.requestDataLists();
        }
        return mutableLiveData;
    }
}
