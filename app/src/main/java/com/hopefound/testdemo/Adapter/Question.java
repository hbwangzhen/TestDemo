package com.hopefound.testdemo.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hopefound.testdemo.R;
import com.hopefound.testdemo.entity.SurveyData;

import java.util.List;

/**
 * Created by 王震 on 2018/4/27 0027.
 */

public class Question extends RecyclerView.Adapter<Question.QViewHolder>{

    private Context context;
    private List<SurveyData> list;
    private LayoutInflater inflater;

    public Question(Context context, List<SurveyData> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public QViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_question,parent,false);
        return new QViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getQuestionName());
        holder.rvAnswer.setLayoutManager(new LinearLayoutManager(context));
        holder.rvAnswer.setAdapter(new AnswerAdapter(context,list.get(position).getAnswerStr()));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class QViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        RecyclerView rvAnswer;

        public QViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_question);
            rvAnswer = itemView.findViewById(R.id.recyclerview_answer);
        }
    }
}
