package com.hopefound.testdemo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hopefound.testdemo.entity.AnswerData;
import com.hopefound.testdemo.entity.SurveyData;
import com.hopefound.testdemo.gen.AnswerDataDao;
import com.hopefound.testdemo.gen.GreenDaoManager;
import com.hopefound.testdemo.gen.SurveyDataDao;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class AddSurveyActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAdd,btnNext,btndelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_survey);
        btnAdd = findViewById(R.id.btn_insert);
        btnNext = findViewById(R.id.btn_next);
        btndelete = findViewById(R.id.btndeleteAll);

        btnAdd.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btndelete.setOnClickListener(this);
        AddSurveyActivityPermissionsDispatcher.getPermissionWithPermissionCheck(this);
    }

    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void getPermission() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_insert:
                insertData();
                break;
            case R.id.btn_next:
                startActivity(new Intent(this,SurveyActivity.class));
                break;
            case R.id.btndeleteAll:
                delete();
                break;
        }
    }

    /**
     * 清空数据库数据
     */
    private void delete() {
        GreenDaoManager.getIstance().getSession().deleteAll(SurveyData.class);
        GreenDaoManager.getIstance().getSession().deleteAll(AnswerData.class);

    }

    /**
     * 向数据库中插入数据
     */
    private void insertData() {

        SurveyDataDao surveyDataDao = GreenDaoManager.getIstance().getSession().getSurveyDataDao();
        AnswerDataDao answerDataDao = GreenDaoManager.getIstance().getSession().getAnswerDataDao();

        SurveyData surveyData = new SurveyData();
        surveyData.setId(5L);
        surveyData.setQuestionName("你认为自己长得好看吗？");
        surveyData.setIsAnswed(false);

        surveyDataDao.insert(surveyData);


        AnswerData answerData = new AnswerData();
        answerData.setAnswerId(208L);
        answerData.setAnswerStr("A、贼拉好看");
        answerData.setQuestionId(5L);

        answerDataDao.insert(answerData);

        AnswerData answerData1 = new AnswerData();
        answerData1.setAnswerId(209L);
        answerData1.setAnswerStr("B、挺好看");
        answerData1.setQuestionId(5L);

        answerDataDao.insert(answerData1);

        AnswerData answerData2 = new AnswerData();
        answerData2.setAnswerId(210L);
        answerData2.setAnswerStr("C、一般好看");
        answerData2.setQuestionId(5L);

        answerDataDao.insert(answerData2);

        AnswerData answerData3 = new AnswerData();
        answerData3.setAnswerId(211L);
        answerData3.setAnswerStr("D、不好看");
        answerData3.setQuestionId(5L);

        answerDataDao.insert(answerData3);

        SurveyData surveyData1 = new SurveyData();
        surveyData1.setId(6L);
        surveyData1.setQuestionName("你的职业是什么？");
        surveyData1.setIsAnswed(false);

        surveyDataDao.insert(surveyData1);

        AnswerData answerData00 = new AnswerData();
        answerData00.setAnswerId(204L);
        answerData00.setAnswerStr("A、android");
        answerData00.setQuestionId(6L);

        answerDataDao.insert(answerData00);

        AnswerData answerData01 = new AnswerData();
        answerData01.setAnswerId(205L);
        answerData01.setAnswerStr("B、ios");
        answerData01.setQuestionId(6L);

        answerDataDao.insert(answerData01);

        AnswerData answerData02 = new AnswerData();
        answerData02.setAnswerId(206L);
        answerData02.setAnswerStr("C、java");
        answerData02.setQuestionId(6L);

        answerDataDao.insert(answerData02);

        AnswerData answerData03 = new AnswerData();
        answerData03.setAnswerId(207L);
        answerData03.setAnswerStr("A、php");
        answerData03.setQuestionId(6L);

        answerDataDao.insert(answerData03);


    }
}
