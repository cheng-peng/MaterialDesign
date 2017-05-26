package com.cxp.toolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by CXP on 2016/12/14
 * desc :
 * q978515743@163.com
 */

public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        //ToolBar中包含Nav Icon , Logo , Title , Sub Title , Menu Items
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);

        // App Logo
        toolbar.setLogo(R.mipmap.ic_launcher);
        // Title
        toolbar.setTitle("程小鹏。");
        // Sub Title
        toolbar.setSubtitle("Sub title");

        //Navigation Icon
        toolbar.setNavigationIcon(R.mipmap.cxp_white_19);

        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_a:
                Toast.makeText(ToolbarActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_b:
                Toast.makeText(ToolbarActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_c:
                Toast.makeText(ToolbarActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_d:
                Toast.makeText(ToolbarActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Toast.makeText(ToolbarActivity.this, "主菜单", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
