# DiscolorViewPager
会变色的 ViewPager 
**先放效果图:**
![discolorViewPager.gif](http://upload-images.jianshu.io/upload_images/166866-db2d10827034dcab.gif)
[github 地址](https://github.com/zzz40500/DiscolorViewPager)
这个是在[PagerSlidingTabStrip](https://github.com/astuetz/PagerSlidingTabStrip)基础上做的2次开发,
主要实现了 TabStrip背景颜色随着 ViewPager 滑动的变换.以及字体颜色的变化.并将颜色的变换实时通知出来出来.
添加了 tab 选中以后字体颜色的变化

**使用方法**
~~~

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
~~~
自定义属性讲解:
* pstsIndicatorColor Color of the sliding indicator
* pstsUnderlineColor Color of the full-width line on the bottom of the view
* pstsDividerColor Color of the dividers between tabs
* pstsIndicatorHeightHeight of the sliding indicator
* pstsUnderlineHeight Height of the full-width line on the bottom of the view
* pstsDividerPadding Top and bottom padding of the dividers
* pstsTabPaddingLeftRight Left and right padding of each tab
* pstsScrollOffset Scroll offset of the selected tab
* pstsTabBackground Background drawable of each tab, should be a StateListDrawable
* pstsShouldExpand If set to true, each tab is given the same weight, default false
* pstsTextAllCaps If true, all tab titles will be upper case, default true

* pstsSelectTitleColor  Color of the tab's text that is select State

图示:




![图示](http://upload-images.jianshu.io/upload_images/166866-4b9764cbf5e77bf2.png)





