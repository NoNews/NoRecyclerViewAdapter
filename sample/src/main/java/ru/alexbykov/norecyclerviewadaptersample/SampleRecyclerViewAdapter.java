package ru.alexbykov.norecyclerviewadaptersample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.alexbykov.norecyclerviewadapter.NoRecyclerViewAdapter;

/**
 * @author Alex Bykov
 *         Date: 08.01.2018.
 *         <p>
 *         You can contact me at me@alexbykov.ru
 */

public class SampleRecyclerViewAdapter extends NoRecyclerViewAdapter<String, SampleRecyclerViewAdapter.ViewHolder> {


    private static final int LAYOUT = R.layout.item_sample;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflate(parent, LAYOUT));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvSample.setText(items.get(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvSample;

        public ViewHolder(View itemView) {
            super(itemView);
            tvSample = itemView.findViewById(R.id.tvSample);
        }

    }
}
