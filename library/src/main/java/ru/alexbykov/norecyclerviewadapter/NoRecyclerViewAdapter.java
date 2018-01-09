package ru.alexbykov.norecyclerviewadapter;

import android.support.annotation.IntRange;
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
 *         You can contact me at me@alexbykov.ru
 * @version 0.0.1
 */

public abstract class NoRecyclerViewAdapter<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<M> items = new ArrayList<>();
    private static final String TAG = NoRecyclerViewAdapter.class.getSimpleName();


    /**
     * This method item count
     *
     * @return item count of {@link #items}
     */
    @Override
    public int getItemCount() {
        return items.size();
    }


    /**
     * This method return item by position
     *
     * @param position is position which you want to get
     * @return item
     */
    public M getItem(@IntRange(from = 0) int position) {
        return items.get(position);
    }


    /**
     * This method is add item by position
     *
     * @param item     is item what you want to add
     * @param position is position of the item
     */
    public void add(M item, @IntRange(from = 0) int position) {
        items.add(position, item);
        notifyItemInserted(position);
    }


    /**
     * This methid is add item to the end of ArrayList
     *
     * @param item is item what you want to add
     */
    public void add(M item) {
        items.add(item);
        notifyItemInserted(getLastPosition());
    }

    /**
     * This method add items to the end of adapter
     *
     * @param items which you want to add
     */
    public void addItems(@NonNull List<M> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }


    /**
     * This method return last position
     *
     * @return lastPosition of {@link #items}
     */
    private int getLastPosition() {
        return items.size() - 1;
    }


    /**
     * This method remove item by position
     *
     * @param position is position which you want remove
     */
    public void remove(@IntRange(from = 0) int position) {
        try {
            notifyItemRemoved(position);
            items.remove(position);
        } catch (IndexOutOfBoundsException e) {
            Log.d(TAG, "You can't remove element with index " + position + ", because itemCount is " + getItemCount());
        }
    }


    /**
     * This method remove item
     * Don't forget to override method equals and hashCode in your model
     *
     * @param item is position which you want to remove
     */
    public void remove(M item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                remove(i);
                return;
            }
        }
    }

    /**
     * This method clear all items and update recyclerView state
     */
    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }


    /**
     * This method inflate and return view
     *
     * @param viewGroup is viewGroup from method onCreateViewHolder
     * @param layoutID  is LAYOUT which you want to inflate
     * @return new View
     */
    protected View inflate(@NonNull ViewGroup viewGroup, @LayoutRes int layoutID) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(layoutID, viewGroup, false);
    }
}
