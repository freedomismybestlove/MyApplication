package com.myapplication.command;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.myapplication.R;
import com.myapplication.base.BaseCommand;
import com.myapplication.viewModel.LoginViewModel;

/**
 * Created by Adminidtrator on 2017/10/28.
 */

public class LoginCommand extends BaseCommand implements View.OnClickListener{
    private LoginViewModel viewModel;

    public LoginCommand(LoginViewModel viewModel) {
        this.viewModel=viewModel;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                Toast.makeText(v.getContext(),"AAA",Toast.LENGTH_LONG).show();
                viewModel.changeString("这里是设置来的");
                break;
        }
    }
    public void login(View view){
        switch (view.getId()){
            case R.id.login:
            Toast.makeText(view.getContext(),"login",Toast.LENGTH_LONG).show();
                break;
        }
    }
    public void listItemClick(AdapterView<?> parent, View view, int position, long id){

    }
}
