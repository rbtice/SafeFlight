package com.example.safeflight.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.safeflight.R;
import com.example.safeflight.Search.sactivity.MessageActivity;
import com.example.safeflight.bean.SingleBean;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;



public class ReasonAdapter extends  RecyclerView.Adapter<ReasonAdapter.MyViewHolder> {

    private Context context;
    private MyViewHolder myViewHolder;
    List<SingleBean.DataBean> list;

    public ReasonAdapter(Context context, List<SingleBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_reason,parent,false);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.item_single_id.setText("原因id："+list.get(position).getAirid());
        holder.item_single_name.setText("原因名称："+list.get(position).getAirname());
        holder.item_reason_detail.setText("原因详情："+list.get(position).getAirhow());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtra("id",list.get(position).getAirid()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item_single_id;
        TextView item_single_name;
        TextView item_reason_detail;
        TextView item_single_when;
        TextView item_single_where;
        TextView item_single_why;

        public MyViewHolder(final View itemView) {
            super(itemView);
            item_single_id = itemView.findViewById(R.id.item_reason_id);
            item_single_name = itemView.findViewById(R.id.item_reason_name);
            item_reason_detail = itemView.findViewById(R.id.item_reason_detail);

        }
    }


}
