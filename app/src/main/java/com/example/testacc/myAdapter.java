package com.example.testacc;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    private List<User> userList;
    private OnCompleteListener<QuerySnapshot> context;

    public myAdapter(List<User> userList, OnCompleteListener<QuerySnapshot> context) {
        this.userList = userList;
        this.context =  context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user =userList.get(position);
        holder.name.setText(user.getName());
        holder.address.setText(user.getAddress());
        holder.number.setText(user.getNumber());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView address;
        public TextView number;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.re_name);
            address =(TextView) itemView.findViewById(R.id.re_address);
            number =(TextView) itemView.findViewById(R.id.re_number);
        }
    }
}
