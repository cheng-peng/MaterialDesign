package com.cxp.bottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private Button bt1;
    private Button bt2;

    private RecyclerView mRecyclerView;

    private List<String> mData;
    private Context mContext;

    private MyAdapter adapter;

    private OnItemClickListener mOnItemClickListener;

    private BottomSheetDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=MainActivity.this;

        mOnItemClickListener=this;

        mData=new ArrayList<>();

        bt1 = (Button) findViewById(R.id.main_bt1);
        bt2 = (Button) findViewById(R.id.main_bt2);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("程小鹏");
        mToolbar.setTitleTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.white));
        setSupportActionBar(mToolbar);
        bt1.setOnClickListener(clickLis);
        bt2.setOnClickListener(clickLis);
    }

    private View.OnClickListener clickLis = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.main_bt1:

//                    STATE_COLLAPSED: 关闭Bottom Sheets,显示peekheight的高度，默认是0
//                    STATE_DRAGGING: 用户拖拽Bottom Sheets时的状态
//                    STATE_SETTLING: 当Bottom Sheets view释放时记录的状态。
//                    STATE_EXPANDED: 当Bottom Sheets 展开的状态
//                    STATE_HIDDEN: 当Bottom Sheets 隐藏的状态
                    BottomSheetBehavior behavior = BottomSheetBehavior.from(findViewById(R.id.scroll));
                    if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    } else {
                        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    }


                    behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                        @Override
                        public void onStateChanged(@NonNull View bottomSheet, int newState) {
                            //这里是bottomSheet 状态的改变，根据slideOffset可以做一些动画

                        }

                        @Override
                        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                            //这里是拖拽中的回调，根据slideOffset可以做一些动画
                        }
                    });
                    break;
                case R.id.main_bt2:
                    for (int i = 0; i < 15; i++) {
                        mData.add(""+(char)(65+i));
                    }
                    adapter = new MyAdapter(mContext, mData,mOnItemClickListener);

                    View v=  LayoutInflater.from(mContext)
                            .inflate(R.layout.layout_view, null,false);
                    mRecyclerView= (RecyclerView) v.findViewById(R.id.view_recyclerview);
                    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                    mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
                    mRecyclerView.setAdapter(adapter);

                    dialog = new BottomSheetDialog(mContext);
                    dialog.setContentView(v);
                    dialog.show();
                    break;
            }
        }
    };

    @Override
    public void OnItemClickListener(View view, int Position) {
        Toast.makeText(MainActivity.this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }
}
