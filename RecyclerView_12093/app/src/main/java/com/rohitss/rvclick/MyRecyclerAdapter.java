package com.rohitss.rvclick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    private List<TestItem> ItemList;
    private View.OnClickListener clickListener;

    public MyRecyclerAdapter(List<TestItem> ItemList) {
        this.ItemList = ItemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(ItemList.get(position).getTitle());
        holder.description.setText(ItemList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        clickListener = itemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            itemView.setTag(this);
            itemView.setOnClickListener(clickListener);
        }
    }
}
