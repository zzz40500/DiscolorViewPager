package com.mingle.example;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;

import com.mingle.discolor.PagerSlidingTabStrip;
import com.mingle.example.fragment.BlankFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {



    private ViewPager vps;
    private PagerSlidingTabStrip pagerSlidingTabStrip;
    private View rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pagerSlidingTabStrip= (PagerSlidingTabStrip) findViewById(R.id.tabStrip);
        rootView=findViewById(R.id.rootView);
        vps= (ViewPager) findViewById(R.id.viewPager);


        List<Fragment>  fragments=new ArrayList<Fragment>();
        List<CharSequence>  titles=new ArrayList<CharSequence>();

        fragments.add(new BlankFragment("tab1"));
        fragments.add(new BlankFragment("tab2"));
        fragments.add(new BlankFragment("tab3"));
        fragments.add(new BlankFragment("tab4"));
        fragments.add(new BlankFragment("tab5"));
        titles.add("tab1");
        titles.add("tab2");
        titles.add("tab3");
        titles.add("tab4");
        titles.add("tab5");


        ViewpagerAdapter viewpagerAdapter=new ViewpagerAdapter(getSupportFragmentManager(),fragments,titles);

        //ViewPager 设置适配器
        vps.setAdapter(viewpagerAdapter);

        //pagerSlidingTabStrip  设置 ViewPager
        pagerSlidingTabStrip.setViewPager(vps);
        //注册观察者,观察 pagerSlidingTabStrip 背景颜色的变换
        pagerSlidingTabStrip.setBackgroundColorObserve(new PagerSlidingTabStrip.BackgroundColorObserve() {
            @Override
            public void change(int color) {
                //将屏幕设置跟pagerSlidingTabStrip 同色
                rootView.setBackgroundColor(color);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color));
            }
        });
        //设置pagerSlidingTabStrip  每个 tab 的背景颜色
        pagerSlidingTabStrip.setColors(getResources().getIntArray(R.array.colors));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {


            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/zzz40500/DiscolorViewPager"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            MainActivity.this.startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
