package com.color.picker.colornamepicker.adapter;


import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.color.picker.colornamepicker.model.ColorModel;
import com.color.picker.colornamepicker.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.colorAdapter> {

    ArrayList<ColorModel> list;
    Context context;
    private int selectedItem = -1; // Initially, no item is selected
    private ColorOnItemClickListener listener;

    public ColorAdapter(ArrayList<ColorModel> list, Context context, ColorOnItemClickListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public colorAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_colour, parent, false);
        return new colorAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull colorAdapter holder, int position) {
        RelativeLayout itemLayout = holder.itemView.findViewById(R.id.color_layout);


        int color = Color.parseColor(list.get(holder.getAdapterPosition()).getColor_hex());
        itemLayout.setBackgroundTintList(ColorStateList.valueOf(color));
        Log.d("colorgot", String.valueOf(color));


        if (holder.getAdapterPosition() == selectedItem) {
            holder.layout_clicked.setBackgroundResource(R.drawable.circle_clicked);
        } else {
            holder.layout_clicked.setBackgroundResource(R.drawable.circle_unclicked);

        }


        // Set an OnClickListener to handle item clicks
        itemLayout.setOnClickListener(view -> {
            int previousSelectedItem = selectedItem; // Store the previously selected item
            ColorModel selectedText = list.get(position);

            // Update the selected item position
            selectedItem = holder.getAdapterPosition();

            // Ensure that the listener is not null before invoking its method
            if (listener != null) {
                listener.coloronItemClick(selectedText.getColor_name(), selectedText.getColor_hex());
            }

            // Notify data changes to reflect the new state
            notifyDataSetChanged();

            // Notify listeners or perform other actions as needed
            // For example, you might want to notify the activity/fragment that an item was clicked.

            // Restore the previous item's background
            if (previousSelectedItem != -1 && previousSelectedItem != selectedItem) {
                notifyItemChanged(previousSelectedItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class colorAdapter extends RecyclerView.ViewHolder {
        RelativeLayout item_layout, layout_clicked;

        public colorAdapter(@NonNull View itemView) {
            super(itemView);
            item_layout = itemView.findViewById(R.id.color_layout);
            layout_clicked = itemView.findViewById(R.id.layout_clicked);
        }
    }

    public interface ColorOnItemClickListener {
        void coloronItemClick(String text, String hex);
    }


}
