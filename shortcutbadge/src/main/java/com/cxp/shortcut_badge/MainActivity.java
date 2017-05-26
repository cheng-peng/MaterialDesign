package com.cxp.shortcut_badge;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import me.leolin.shortcutbadger.ShortcutBadger;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private TextInputLayout til;
    private TextInputEditText tiet;
    private Button btAdd;
    private Button btRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.main_tv);
        til = (TextInputLayout) findViewById(R.id.main_til);
        btAdd = (Button) findViewById(R.id.add_badge);
        btRemove = (Button) findViewById(R.id.remobe_badge);

        btAdd.setOnClickListener(clickLis);
        btRemove.setOnClickListener(clickLis);

        tiet = (TextInputEditText) til.getEditText();
        tiet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 3 && charSequence.length() != 0) {
                    til.setError("当输入数大于99时，默认99+");
                } else {
                    til.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        ResolveInfo resolveInfo = getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        String currentHomePackage = resolveInfo.activityInfo.packageName;
        tv.setText("launcher:" + currentHomePackage);
    }

    //单击事件
    private View.OnClickListener clickLis=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.add_badge:
                    int badgeCount = 0;
                    try {
                        badgeCount = Integer.parseInt(tiet.getText().toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Error input", Toast.LENGTH_SHORT).show();
                    }
                    boolean successAdd = ShortcutBadger.applyCount(MainActivity.this, badgeCount);
                    Toast.makeText(getApplicationContext(), "Set count=" + badgeCount + ", success=" + successAdd, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.remobe_badge:
                    tiet.setText("");
                    boolean successRemove = ShortcutBadger.removeCount(MainActivity.this);
                    Toast.makeText(getApplicationContext(), "success=" + successRemove, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
