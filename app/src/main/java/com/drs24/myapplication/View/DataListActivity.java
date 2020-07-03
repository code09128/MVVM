package com.drs24.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.drs24.myapplication.Model.DataList;
import com.drs24.myapplication.VewModel.DataListViewModel;
import com.drs24.myapplication.View.adapter.DataListAdapter;
import com.drs24.myapplication.AppDelegate;
import com.drs24.myapplication.databinding.ActivityDataListBinding;

import java.util.List;

public class DataListActivity extends AppCompatActivity {

    final String TAG = getClass().getSimpleName();
    ActivityDataListBinding binding;
    DataListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDataListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initUI();

        if (AppDelegate.getInstance().isNetworkAvailable()) {
            binding.progressBar.setVisibility(View.VISIBLE);

            DataListViewModel dataListViewModel = new DataListViewModel();

            //observe 的第一個參數 this，就是跟getDataList()回傳的LiveData說跟著當前Activity的生命週期。
            //透過observe可以在非同步的資料取得/處理完成以後，把結果回傳回來，這種就是透過觀察者模式來完成我們的Callback處理。
            dataListViewModel.getDataList().observe(this, new Observer<List<DataList>>() {
                @Override
                public void onChanged(List<DataList> currencyPojos) {
                    if (currencyPojos != null && !currencyPojos.isEmpty()) {
                        Log.e(TAG, "observe onChanged()=" + currencyPojos.size());
                        binding.progressBar.setVisibility(View.GONE);
                        adapter.addDataList(currencyPojos);
                        adapter.notifyDataSetChanged();
                    }
                }
            });
        } else {
            Toast.makeText(this, "No Network Available", Toast.LENGTH_LONG).show();
        }
    }

    private void initUI() {
        binding.rvHolidayList.setHasFixedSize(true);
        binding.rvHolidayList.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DataListAdapter();
        binding.rvHolidayList.setAdapter(adapter);
    }
}
