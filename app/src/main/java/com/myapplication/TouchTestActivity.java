package com.myapplication;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.myapplication.Interface.OnClickRemoteConterView;
import com.myapplication.bean.TestBean;
import com.myapplication.databinding.ActivityOntouchLayoutBinding;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by Administrator on 2017/8/21.
 */

public class TouchTestActivity extends AutoLayoutActivity implements View.OnClickListener{
    private ActivityOntouchLayoutBinding binding;
    private long firstTime;
    private long secondTime;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(TouchTestActivity.this,R.layout.activity_ontouch_layout);
        binding.setEvent(this);
        TestBean bean= new TestBean();
        bean.setText("来自点击事件的文字");
        ObservableField<String> stringObservableField=new ObservableField<>("222222");
        bean.setObString(stringObservableField);
        binding.setTest(bean);
        binding.remote.setmListener(new OnClickRemoteConterView() {
            @Override
            public void onTopClickListener() {
                Toast.makeText(TouchTestActivity.this,"Top",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onBottomClickListener() {
                Toast.makeText(TouchTestActivity.this,"Bottom",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLeftClickListener() {
                Toast.makeText(TouchTestActivity.this,"Left",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRightClickListener() {
                Toast.makeText(TouchTestActivity.this,"Right",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCenterClickListener() {
                Toast.makeText(TouchTestActivity.this,"OK",Toast.LENGTH_LONG).show();

            }
        });
        binding.obTest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                      binding.getTest().setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
//        LoadingDialog dialog= new LoadingDialog(TouchTestActivity.this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.onTouchTest:
                binding.getTest().setText("AAAAAAAAAA");
                break;
            case R.id.test3333:
                binding.getTest().setText("AAAA");
                Log.d("AA",binding.getTest().getText());
                break;
//            case :
//                binding.text2.setTest("33333");
//                break;
            case R.id.text_test:

//                Calendar selectedDate = Calendar.getInstance();
//                Calendar startDate = Calendar.getInstance();
//                startDate.set(2013,1,1);
//
//                Calendar endDate = Calendar.getInstance();
//                endDate.set(2100,12,31);
//                TimePickerView timePicker=new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
//                    @Override
//                    public void onTimeSelect(Date date, View v) {
//                        Calendar calendar=Calendar.getInstance();
//                        calendar.setTime(date);
//
//                        binding.onTouchTest.setText(calendar.get(Calendar.YEAR)+"");
//                    }
//                }).setType(new boolean[]{true, true, true, true, true, false})
//                        .setCancelText("取消")//取消按钮文字
//                        .setSubmitText("确认")//确认按钮文字
//                        .setContentSize(18)//滚轮文字大小
//                        .setTitleSize(20)//标题文字大小
//                        .setTitleText("")//标题文字
//                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
//                        .isCyclic(false)//是否循环滚动
//                        .setTitleColor(Color.BLACK)//标题文字颜色
//                        .setSubmitColor(Color.BLACK)//确定按钮文字颜色
//                        .setCancelColor(Color.BLACK)//取消按钮文字颜色
//                        .setTitleBgColor(Color.WHITE)//标题背景颜色 Night mode
//                        .setBgColor(ContextCompat.getColor(TouchTestActivity.this,R.color.c_ffffff))//滚轮背景颜色 Night mode
//                        .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
//                        .setRangDate(startDate,endDate)//起始终止年月日设定
//                        .setLabel("年","月","日","时","分","秒")//默认设置为年月日时分秒
//                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .isDialog(false)//是否显示为对话框样式
//                        .build();
//                timePicker.show();
                break;
            default:
                break;
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction()==MotionEvent.ACTION_DOWN){

                if(System.currentTimeMillis()-firstTime>300){
                    firstTime=System.currentTimeMillis();
                    return super.dispatchTouchEvent(ev);
                }else{
//                    Log.d("AAA","太快了"+ev.getAction());
                    return true;
                }

        }
        return super.dispatchTouchEvent(ev);

    }



}
