package com.example.alexbykov.recyclerviewtestselection.adapters;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.alexbykov.recyclerviewtestselection.R;

import java.util.ArrayList;
import java.util.List;


public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    private static final int LAYOUT = R.layout.item_layout;
    private List<Test> items = new ArrayList<>();

    private TestDelegate testDelegate;

    public boolean isSelectModeEnabled = false;

    public TestAdapter() {
        testDelegate = new TestDelegate(this);
        for (int i = 0; i < 100; i++) items.add(new Test());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(LAYOUT, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Test test = items.get(position);
        testDelegate.onBindViewHolder(holder, test);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvItem;
        public RelativeLayout ltItem;

        public ViewHolder(View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
            ltItem = itemView.findViewById(R.id.lt_item);
        }
    }
}
