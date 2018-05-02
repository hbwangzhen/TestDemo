package com.hopefound.testdemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hopefound.testdemo.R;
import com.hopefound.testdemo.entity.AnswerData;

import java.util.List;

/**
 * Created by 王震 on 2018/4/27 0027.
 */

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AVeiwHolder>{

    private Context context;
    private List<AnswerData> list;
    private LayoutInflater inflater;

    public AnswerAdapter(Context context, List<AnswerData> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public AVeiwHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_answer,parent,false);
        return new AVeiwHolder(view);
    }

    @Override
    public void onBindViewHolder(AVeiwHolder holder, int position) {
        holder.tvAnswer.setText(list.get(position).getAnswerStr());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class AVeiwHolder extends RecyclerView.ViewHolder{

        TextView tvAnswer;
        public AVeiwHolder(View itemView) {
            super(itemView);
            tvAnswer = itemView.findViewById(R.id.tv_answer);
        }
    }
}
