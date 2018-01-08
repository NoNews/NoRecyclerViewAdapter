package ru.alexbykov.norecyclerviewadaptersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    private static final int LAYOUT = R.layout.activity_main;
    private RecyclerView recyclerView;
    private Button btnAddAll;
    private Button btnRemoveAll;
    private Button btnAddOne;
    private Button btnRemoveOne;
    private SampleRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        setupUI();
    }

    private void setupUI() {
        bindViews();
        setupAdapter();
        addItems();
    }


    @Override
    protected void onResume() {
        setupUX();
        super.onResume();
    }


    private void setupUX() {
        btnAddAll.setOnClickListener(v -> addItems());
        btnRemoveAll.setOnClickListener(v -> clear());
        btnAddOne.setOnClickListener(v-> addItem());
        btnRemoveOne.setOnClickListener(v -> deleteByPosition());
    }

    private void deleteByPosition() {
        adapter.remove(0);
    }

    private void clear() {
        adapter.clear();
    }

    private void addItem() {
        adapter.add("Test");
    }

    private void setupAdapter() {
        adapter = new SampleRecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void addItems() {
        adapter.addItems(MockUtils.getItems());
    }


    @Override
    protected void onPause() {
        unbindUX();
        super.onPause();
    }

    private void unbindUX() {
        btnAddOne.setOnClickListener(null);
        btnRemoveOne.setOnClickListener(null);
        btnAddAll.setOnClickListener(null);
        btnRemoveAll.setOnClickListener(null);
    }

    private void bindViews() {
        recyclerView = findViewById(R.id.recyclerView);
        btnAddAll = findViewById(R.id.btnAddAll);
        btnRemoveAll = findViewById(R.id.btnRemoveAll);
        btnAddOne = findViewById(R.id.btnAddOne);
        btnRemoveOne = findViewById(R.id.btnRemoveOne);
    }
}
