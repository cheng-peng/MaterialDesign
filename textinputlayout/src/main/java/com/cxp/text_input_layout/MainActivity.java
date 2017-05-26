package com.cxp.text_input_layout;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;


/**
 * 1、setHint();设置提示语
 * 2、setError();设置错误显示信息
 * 3、setErrorEnabled();设置错误信息是否显示。true显示，false不显示。
 * 4、getEditText();得到EditText的控件实例。
 */
public class MainActivity extends AppCompatActivity {

    private TextInputLayout til;
    private TextInputEditText tiet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        til = (TextInputLayout) findViewById(R.id.main_til);
        tiet = (TextInputEditText) findViewById(R.id.main_tiet);

        //初始化数据
        initData();

    }

    //初始化数据
    private void initData() {
        //设置hint提示
        til.setHint("请输入用户名");
        tiet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //这儿判断操作，如果输入错误可以给用户提示
                if(charSequence.length()<6&&charSequence.length()!=0){
                    til.setError("用户名不能小于6位");
                }else {
                    til.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}

