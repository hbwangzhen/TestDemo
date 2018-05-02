package com.hopefound.testdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hopefound.testdemo.Adapter.Question;
import com.hopefound.testdemo.entity.SurveyData;
import com.hopefound.testdemo.gen.GreenDaoManager;
import com.hopefound.testdemo.gen.SurveyDataDao;
import com.hopefound.testdemo.surveyNextView.NextView;

import java.util.ArrayList;
import java.util.List;

public class SurveyActivity extends AppCompatActivity {

    private NextView nextView;
    private int progress = 0;
    private boolean isAnswer;

    private RecyclerView recyclerView;

    private List<SurveyData> surveyDataList;
    private Question adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        recyclerView = findViewById(R.id.recyclerview);
        nextView = findViewById(R.id.nextview);
        nextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isAnswer){
                    ((NextView) view).setIsClick(true);
                    isAnswer = true;
                    recyclerView.scrollToPosition(1);
                    progress+=10;
                    if (progress<=360) {
                        ((NextView) view).setProgress(progress);
                    }
                }else {
                    ((NextView) view).setIsClick(false);
                    isAnswer = false;

                }
            }
        });

        surveyDataList = new ArrayList<>();
        LinearLayoutManager  linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adpter = new Question(this,surveyDataList);
        recyclerView.setAdapter(adpter);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        getSurveyData();
    }

    /**
     * 在数据库中查找数据
     */
    private void getSurveyData() {
        SurveyDataDao surveyDate = GreenDaoManager.getIstance().getNewSession().getSurveyDataDao();
        surveyDataList.addAll(surveyDate.loadAll());
        adpter.notifyDataSetChanged();
    }
}
