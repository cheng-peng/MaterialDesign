package com.cxp.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private Button bt7;
    private Button bt8;
    private Button bt9;
    private Button bt10;
    private Button bt11;
    private Button bt12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);
        bt10 = (Button) findViewById(R.id.bt10);
        bt11 = (Button) findViewById(R.id.bt11);
        bt12 = (Button) findViewById(R.id.bt12);

        bt1.setOnClickListener(clickLis);
        bt2.setOnClickListener(clickLis);
        bt3.setOnClickListener(clickLis);
        bt4.setOnClickListener(clickLis);
        bt5.setOnClickListener(clickLis);
        bt6.setOnClickListener(clickLis);
        bt7.setOnClickListener(clickLis);
        bt8.setOnClickListener(clickLis);
        bt9.setOnClickListener(clickLis);
        bt10.setOnClickListener(clickLis);
        bt11.setOnClickListener(clickLis);
        bt12.setOnClickListener(clickLis);

    }

    //单击事件
    private View.OnClickListener clickLis = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt1:
                    //日期选择器
                    showDatePickerDialog();
                    break;
                case R.id.bt2:
                    //时间选择器
                    showTimePickerDialog();
                    break;
                case R.id.bt3:
                    //一个按钮的提示框
                    showAlertDialogOneButton();
                    break;
                case R.id.bt4:
                    //两个按钮的提示框
                    showAlertDialogTwoButton();
                    break;
                case R.id.bt5:
                    //三个按钮的提示框
                    showAlertDialogThreeButton();
                    break;
                case R.id.bt6:
                    //带输入框的Dialog
                    showAlertDialogInput();
                    break;
                case R.id.bt7:
                    //带单选框的Dialog
                    showAlertDialogSingleChoice();
                    break;
                case R.id.bt8:
                    //带复选框的Dialog
                    showAlertDialogMultiChoice();
                    break;
                case R.id.bt9:
                    //列表的Dialog
                    showAlertDialogList();
                    break;
                case R.id.bt10:
                    //自定义dialog
                    showAlertDialogCustom();
                    break;
                case R.id.bt11:
                    //圆形进度条
                    showProgressDialogCycle();
                    break;
                case R.id.bt12:
                    //横条进度条
                    showProgressDialogHorizontal();
                    break;
            }
        }
    };


    //日期选择器
    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                // 回调监听实现
                String msg = year + "-" + monthOfYear + "-" + dayOfMonth;
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        }, 2016, 4, 15);
        datePickerDialog.show();
    }

    //时间选择器
    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, R.style.DIYMaterialDialog, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                String msg = hourOfDay + ":" + minute;
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        }, 12, 12, true);
        timePickerDialog.show();
    }

    //一个按钮的提示框
    private void showAlertDialogOneButton() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DIYMaterialDialog);
        builder.setTitle("提示框");
        builder.setMessage("提示内容");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    //两个按钮的提示框
    private void showAlertDialogTwoButton() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DIYMaterialDialog);
        builder.setTitle("提示框");
        builder.setMessage("提示内容");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    //三个按钮的提示框
    private void showAlertDialogThreeButton() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DIYMaterialDialog);
        builder.setTitle("提示框");
        builder.setMessage("提示内容");
        builder.setNegativeButton("程小鹏。", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "程小鹏。", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    //带输入框的Dialog
    private void showAlertDialogInput() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DIYMaterialDialog);
        builder.setTitle("带输入框的提示框");
        builder.setView(new EditText(this));
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    //带单选框的Dialog
    private void showAlertDialogSingleChoice() {
        final String[] itemArr = new String[]{"唐三藏", "孙悟空", "猪八戒", "沙和尚"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DIYMaterialDialog);
        builder.setTitle("带单选框的提示框");
        builder.setSingleChoiceItems(itemArr, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, itemArr[which], Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    //带复选框的Dialog
    private void showAlertDialogMultiChoice() {
        final String[] itemArr = new String[]{"唐三藏", "孙悟空", "猪八戒", "沙和尚"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DIYMaterialDialog);
        builder.setTitle("带单选框的提示框");
        builder.setMultiChoiceItems(itemArr, new boolean[]{true, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(MainActivity.this, itemArr[which], Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    //列表的Dialog
    private void showAlertDialogList() {
        final String[] itemArr = new String[]{"唐三藏", "孙悟空", "猪八戒", "沙和尚"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DIYMaterialDialog);
        builder.setTitle("列表提示框");
        builder.setItems(itemArr, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, itemArr[which], Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    //自定义dialog
    private void showAlertDialogCustom() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DIYMaterialDialog);
        builder.setTitle("自定义dialog");
        builder.setView(view);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    //圆形进度条
    private void showProgressDialogCycle() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("圆形进度条");
        progressDialog.setMessage("进度条描述");
        progressDialog.show();
    }

    //横条进度条
    private void showProgressDialogHorizontal() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("横条进度条");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }


}
