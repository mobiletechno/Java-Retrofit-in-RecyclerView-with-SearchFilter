package com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Custom.MyApp.Constant;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Adapter.RecyclerViewAdapter;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Model.Pojo.Employee.Employee;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.R;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.ViewModel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MainActivity context;
    MainViewModel viewModel;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Employee> list = new ArrayList<>();
    public String filtertext;
    public static ProgressDialog progress;
    public static Boolean istoastworks = false;
    public static Toast mytoast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyToast();
        dataprogress();
        context = this;
        recyclerView = findViewById(R.id.viewEmployees);
        viewModel = ViewModelProviders.of(context).get(MainViewModel.class);
        viewModel.getUserMutableLiveData().observe(context, userListUpdateObserver);
        EditText editText = findViewById(R.id.editTextTextPersonName2);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
        if (filtertext != null) {
            filter(filtertext);
        }
    }

    public void MyToast() {

        mytoast = Toast.makeText(MainActivity.this, Constant.BASE_TOAST_NETWORK_FAILURE, Toast.LENGTH_LONG);

    }

    public void dataprogress() {

        progress = new ProgressDialog(this);
        progress.setTitle(Constant.SHOW_PROGRESS_MESSAGE);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.setIcon(R.drawable.ic_action_stop);
        progress.setProgress(0);
        if (isNetworkAvailable()) {
            progress.show();
        } else {
            progress.dismiss();
        }
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }


    Observer<ArrayList<Employee>> userListUpdateObserver = new Observer<ArrayList<Employee>>() {
        @Override
        public void onChanged(ArrayList<Employee> userArrayList) {

            recyclerViewAdapter = new RecyclerViewAdapter(context, userArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(recyclerViewAdapter);
            list = userArrayList;

        }
    };

    private void filter(String text) {

        ArrayList<Employee> filteredList = new ArrayList<>();
        for (Employee item : list) {
            if (item.getEmployeeName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        recyclerViewAdapter.filterList(filteredList);
    }


}