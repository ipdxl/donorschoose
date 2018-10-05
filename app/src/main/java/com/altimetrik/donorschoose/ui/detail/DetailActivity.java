package com.altimetrik.donorschoose.ui.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.altimetrik.donorschoose.R;

public class DetailActivity extends AppCompatActivity implements DetailView {

    private DetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        presenter = new DetailPresenter(this);
    }
}
