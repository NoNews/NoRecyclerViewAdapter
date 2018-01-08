package com.example.alexbykov.recyclerviewtestselection.adapters;

import android.support.v4.content.ContextCompat;
import android.view.View;

/**
 * @author Alex Bykov
 *         Date: 11.12.2017.
 *         <p>
 *         You can contact me at me@alexbykov.ru
 */

public class TestDelegate {

    private TestAdapter testAdapter;

    public TestDelegate(TestAdapter testAdapter) {
        this.testAdapter = testAdapter;

    }

    public void onBindViewHolder(final TestAdapter.ViewHolder holder, final Test test) {
        holder.tvItem.setText(test.hashCode() + "");

        holder.ltItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (testAdapter.isSelectModeEnabled) {
                    test.selected = !test.selected;
                    select(holder, test);
                }
            }
        });

        holder.ltItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!testAdapter.isSelectModeEnabled) {
                    testAdapter.isSelectModeEnabled = true;
                    test.selected = !test.selected;
                    select(holder, test);
                    return true;
                } else {
                    return false;
                }
            }
        });
        select(holder, test);
    }

    private void select(TestAdapter.ViewHolder holder, Test test) {
        if (test.selected) {
            holder.ltItem.setBackgroundColor(ContextCompat.getColor(holder.tvItem.getContext(), android.R.color.holo_blue_bright));
        } else {
            holder.ltItem.setBackgroundColor(ContextCompat.getColor(holder.tvItem.getContext(), android.R.color.white));
        }
    }
}
