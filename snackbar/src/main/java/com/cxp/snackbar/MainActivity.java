package com.cxp.snackbar;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt1;
    private Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);

        bt1.setOnClickListener(clickLis);
        bt2.setOnClickListener(clickLis);
    }

    //单击事件
    private View.OnClickListener clickLis = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt1:
                    //普通SnackBar
                    showCommonSB();
                    break;
                case R.id.bt2:
                    //显示带 Action 的 Snackbar
                    showWithActionSB();
                    break;
            }
        }
    };

    //普通的SnackBar
    private void showCommonSB() {
        Snackbar snackbar = Snackbar.make(bt1,
                "我是普通 Snackbar", Snackbar.LENGTH_SHORT);
        //设置背景颜色
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_blue_bright));
        snackbar.setCallback(new Snackbar.Callback() {
            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                super.onDismissed(snackbar, event);
                //关闭时候监听
                Toast.makeText(MainActivity.this, "onDismissed()", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShown(Snackbar snackbar) {
                super.onShown(snackbar);
                //打开时候监听
                Toast.makeText(MainActivity.this, "onShown()", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }

    //显示带 Action 的 Snackbar
    private void showWithActionSB() {
        final Snackbar snackbar = Snackbar.make(bt2,
                "我是带 Action 的 Snackbar", Snackbar.LENGTH_LONG);
        snackbar.setAction("撤销", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "撤销成功", Toast.LENGTH_SHORT).show();
                snackbar.dismiss();
            }
        });
        //设置背景颜色
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_blue_bright));
        snackbar.setCallback(new Snackbar.Callback() {
            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                super.onDismissed(snackbar, event);
                //关闭时候监听
                Toast.makeText(MainActivity.this, "onDismissed()", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShown(Snackbar snackbar) {
                super.onShown(snackbar);
                //打开时候监听
                Toast.makeText(MainActivity.this, "onShown()", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }
}
