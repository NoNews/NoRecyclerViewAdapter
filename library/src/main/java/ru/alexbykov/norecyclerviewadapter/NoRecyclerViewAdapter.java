package ru.alexbykov.norecyclerviewadapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Bykov
 *         Date: 08.01.2018.
 *         <p>
 *         You can contact me at me@alexbykov.ru
 */

public abstract class NoRecyclerViewAdapter<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<M> items = new ArrayList<>();
    private final String TAG = getClass().getSimpleName();


    @Override
    public int getItemCount() {
        return items.size();
    }

    public M getItem(int position) {
        return items.get(position);
    }

    public void add(M item, int position) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void add(M item) {
        items.add(item);
        notifyItemInserted(getLastPosition());
    }

    private int getLastPosition() {
        return items.size() - 1;
    }


    public void remove(int position) {
        try {
            notifyItemRemoved(position);
            items.remove(position);
        } catch (IndexOutOfBoundsException e) {
            Log.d(TAG, "You can't remove element with index " + position + ", because itemCount is " + getItemCount());
        }

    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void addItems(@NonNull List<M> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    protected View inflate(@NonNull ViewGroup viewGroup, @LayoutRes int layoutID) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(layoutID, viewGroup, false);
    }
}
