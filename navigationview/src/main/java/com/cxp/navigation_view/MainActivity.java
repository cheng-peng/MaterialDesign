package com.cxp.navigation_view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * 沉浸式布局 支持  4.4和4.4以上版本
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout= (DrawerLayout) findViewById(R.id.main_dl);
        mNavigationView= (NavigationView) findViewById(R.id.nv);

        Toolbar toolbar= (Toolbar) findViewById(R.id.tb_title);

        toolbar.setTitle("程小鹏");
        toolbar.setNavigationIcon(R.mipmap.cxp_white_19);
        setSupportActionBar(toolbar);

        //设置状态栏颜色
        StatusBarCompat.compat(this, ContextCompat.getColor(this,R.color.primary_dark));


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_homg:
                        Snackbar.make(mNavigationView,item.getTitle(),Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_tx:
                        Snackbar.make(mNavigationView,item.getTitle(),Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_xh:
                        Snackbar.make(mNavigationView,item.getTitle(),Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_sc:
                        Snackbar.make(mNavigationView,item.getTitle(),Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_wz:
                        Snackbar.make(mNavigationView,item.getTitle(),Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_downloaded:
                        Snackbar.make(mNavigationView,item.getTitle(),Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_more:
                        Snackbar.make(mNavigationView,item.getTitle(),Snackbar.LENGTH_SHORT).show();
                        break;
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true ;
        }
        return super.onOptionsItemSelected(item);
    }
}
