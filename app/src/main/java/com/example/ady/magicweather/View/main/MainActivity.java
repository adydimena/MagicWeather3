package com.example.ady.magicweather.View.main;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ady.magicweather.MagicWeather;
import com.example.ady.magicweather.R;
import com.example.ady.magicweather.Util.helperClasses.RecycleViewAdapter;
import com.example.ady.magicweather.Util.pojo.WeatherPojo;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    EditText etZip ;
    public static final String TAG = MainActivity.class.getCanonicalName();
    @Inject
    MainPresenter mainPresenter;
    private DrawerLayout dlayout;
    private ActionBarDrawerToggle btnToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MagicWeather.get(this).getMainComponet().inject(this);
        mainPresenter.attachView(this);
        // app program logic starts here...
        setNaviBar();
        etZip = findViewById(R.id.etZip);
    }

    @Override
    public void ShowError(String message) {
        // Todo setUp Error
    }

    @Override
    public void setWeatherdata(WeatherPojo weatherPojo) {
        if (weatherPojo!= null) {
            RecyclerView recyclerView = findViewById(R.id.mainlayoutRecycle);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
            RecycleViewAdapter recycleadapter = new RecycleViewAdapter(weatherPojo, this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(itemAnimator);
            recyclerView.setAdapter(recycleadapter);
        }

    }
    @Override
    public void setError(String message) {
        String dummy = etZip.getText().toString();
        Toast.makeText(this,message + ". could not find "+ dummy + ".Try again",Toast.LENGTH_LONG).show();
        etZip.setText(" ");
    }
    public void weatherVudo(View view) {
        InputMethodManager mgr = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(etZip.getWindowToken(),0);
        mainPresenter.getWeatherData(etZip.getText().toString());
    }

    private void setNaviBar() {
        dlayout = findViewById(R.id.drawerLayout);
        btnToggle = new ActionBarDrawerToggle(this,dlayout,R.string.Open,R.string.Close);
        dlayout.addDrawerListener(btnToggle);
        btnToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
