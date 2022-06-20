package com.example.riderlog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<orders> mData;

    public RecyclerViewAdapter(Context mContext, List<orders> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_unassigned, viewGroup,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_title.setText(mData.get(i).getTitle());
        myViewHolder.tv_description.setText(mData.get(i).getDepartment());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title;
        private TextView tv_description;

     public MyViewHolder(@NonNull View itemView) {
         super(itemView);

         tv_title = (TextView) itemView.findViewById(R.id.text_view_title);
         tv_description = (TextView) itemView.findViewById(R.id.text_view_description);

     }
 }



}
