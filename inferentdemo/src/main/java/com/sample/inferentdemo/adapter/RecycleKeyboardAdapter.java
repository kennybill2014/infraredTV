package com.sample.inferentdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample.inferentdemo.R;

/**
 * Created by FarinaZhang on 2017/8/23.
 */
public class RecycleKeyboardAdapter extends RecyclerView.Adapter<RecycleKeyboardAdapter.MyViewHolder> {
    private Context mContext;
    private String[] values;
    private OnRecyclerViewItemClickListener mItemClickListener;

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , int position);
    }

    public RecycleKeyboardAdapter(Context context, String[] values){
        mContext = context;
        this.values = values;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_adapter_keybord,viewGroup,false);
        MyViewHolder  vh= new MyViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        viewHolder.txt_num.setText(values[i]);

        /*if(i == 9|| i == 11){
            int size_px = DensityUtil.dip2px(mContext,20.0f);
            viewHolder.txt_num.setTextSize(size_px);
        }else{
            int size_px;
            size_px = DensityUtil.dip2px(mContext,34.0f);
            viewHolder.txt_num.setTextSize(size_px);
        }*/

        final int position = i;
        viewHolder.txt_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemClickListener!=null){
                    mItemClickListener.onItemClick(v,position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return values.length;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener){
        this.mItemClickListener = listener;
    }

    public class MyViewHolder extends ViewHolder {
        public TextView txt_num;
        public MyViewHolder(View itemView) {

            super(itemView);
            txt_num = (TextView)itemView.findViewById(R.id.text_num);
        }
    }
}
