package com.hopefound.testdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hopefound.testdemo.R;

/**
 * Created by 王震 on 2018/4/19 0019.
 */

public class IntoRoomDialog extends Dialog {

    private ImageView ivClose;
    private TextView tvTime,tvType,tvCount,tvSubmit;

    public IntoRoomDialog(@NonNull Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_in_room);
        ivClose = findViewById(R.id.iv_close);
        tvTime = findViewById(R.id.tv_time);
        tvType = findViewById(R.id.tv_type);
        tvCount = findViewById(R.id.tv_count);
        tvSubmit = findViewById(R.id.tv_submit);

        setCanceledOnTouchOutside(false);

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }

    /**
     * choose type
     * @param listener
     */
    public void setChooseTypeListner(View.OnClickListener listener){
            tvType.setOnClickListener(listener);
    }

    /**
     * choose time
     * @param listner
     */
    public void setChooseTimeListner(View.OnClickListener listner){
        tvTime.setOnClickListener(listner);
    }

    /**
     * choose count
     * @param listner
     */
    public void setTvCountListner(View.OnClickListener listner){
        tvCount.setOnClickListener(listner);
    }


    public interface SubmitData{
        void submit();
    }
}
