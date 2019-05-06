package com.tiangong.plugin.nosdklib;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private BottomBar mBottomBar;
    private List<Fragment> mFragments = new ArrayList<>();
    private SXFragment sxFragment;
    private XZFragment xzFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initFragment(savedInstanceState);
        initView();
    }



    private void initView() {
        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);

        mBottomBar
                .addItem(new BottomBarTab(this, R.mipmap.shengxiao,R.mipmap.shengxiaoed))
                .addItem(new BottomBarTab(this, R.mipmap.xingzuo,R.mipmap.xingzuoed));
//                .addItem(new BottomBarTab(this, R.drawable.icon_entrep,R.drawable.icon_entrep_cur))
//                .addItem(new BottomBarTab(this, R.drawable.icon_order,R.drawable.icon_order_cur))
//                .addItem(new BottomBarTab(this, R.drawable.icon_my,R.drawable.icon_my_cur));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (position){
                    case 0:
                        if(null==sxFragment){
                            sxFragment = SXFragment.newInstance();
                            transaction.add(R.id.fl_container,sxFragment);
                        }
                        showHideFragment(sxFragment);
                        break;
                    case 1:
                        if(null==xzFragment){
                            xzFragment = XZFragment.newInstance();
                            transaction.add(R.id.fl_container,xzFragment);
                        }
                        showHideFragment(xzFragment);
                        break;
//                    case 1:
//                        if(null==ventureServiceFragment){
//                            ventureServiceFragment = VentureServiceFragment.newInstance();
//                            transaction.add(R.id.fl_container,ventureServiceFragment);
//                        }
//                        showHideFragment(ventureServiceFragment);
//                        break;
//                    case 3:
//                        if(!App.getInstance().isLogin()){
//                            startActivity(LoginActivity.class);
//                            chooseTab(0);
//                            return;
//                        }
//                        if(null==orderFragment){
//                            orderFragment = OrderFragment.newInstance();
//                            transaction.add(R.id.fl_container,orderFragment);
//                        }
//                        showHideFragment(orderFragment);
//                        break;
//                    case 4:
//                        if(!App.getInstance().isLogin()){
//                            startActivity(LoginActivity.class);
//                            chooseTab(0);
//                            return;
//                        }
//                        if(null==myFragment){
//                            myFragment = MyFragment.newInstance();
//                            transaction.add(R.id.fl_container,myFragment);
//                        }
//                        showHideFragment(myFragment);
//                        break;

                }
                transaction.commitAllowingStateLoss();

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
//                final Fragment currentFragment = mFragments.get(position);
//                int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();
//
//                // 如果不在该类别Fragment的主页,则回到主页;
//                if (count > 1) {
//                    if (currentFragment instanceof ZhihuFirstFragment) {
//                        currentFragment.popToChild(FirstHomeFragment.class, false);
//                    } else if (currentFragment instanceof ZhihuSecondFragment) {
//                        currentFragment.popToChild(ViewPagerFragment.class, false);
//                    } else if (currentFragment instanceof ZhihuThirdFragment) {
//                        currentFragment.popToChild(ShopFragment.class, false);
//                    } else if (currentFragment instanceof ZhihuFourthFragment) {
//                        currentFragment.popToChild(MeFragment.class, false);
//                    }
//                    return;
//                }


                // 这里推荐使用EventBus来实现 -> 解耦
//                if (count == 1) {
//                    // 在FirstPagerFragment中接收, 因为是嵌套的孙子Fragment 所以用EventBus比较方便
//                    // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
//                    EventBus.getDefault().post(new TabSelectedEvent(position));
//                }
            }
        });
        mBottomBar.setCurrentItem(0);
    }

    public void showHideFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if(!mFragments.contains(fragment)){
            mFragments.add(fragment);
        }
        for (Fragment f:mFragments) {
            if(fragment.equals(f)){
                fragmentTransaction.show(fragment);
            }else
                fragmentTransaction.hide(f);

        }
        fragmentTransaction.commitAllowingStateLoss();
    }
    /**
     * 初始化fragment的记忆状态
     *
     * @param savedInstanceState
     */
    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (savedInstanceState != null) {

            sxFragment = (SXFragment) getSupportFragmentManager().getFragment(savedInstanceState, "sxFragment");
            xzFragment = (XZFragment) getSupportFragmentManager().getFragment(savedInstanceState, "xzFragment");
//            findFragment = (PeopleFragment) getSupportFragmentManager().getFragment(savedInstanceState, "findFragment");
//            ventureServiceFragment = (VentureServiceFragment) getSupportFragmentManager().getFragment(savedInstanceState, "ventureServiceFragment");
//            orderFragment = (OrderFragment) getSupportFragmentManager().getFragment(savedInstanceState, "orderFragment");

        } else {
            sxFragment =SXFragment.newInstance();
//            myFragment = MyFragment.newInstance();
//            findFragment = FindFragment.newInstance();
        }
        if(null!=sxFragment){
            mFragments.add(sxFragment);
            transaction.add(R.id.fl_container,sxFragment);
        }
        if(null!=xzFragment){
            mFragments.add(xzFragment);
            transaction.add(R.id.fl_container,xzFragment);
            transaction.hide(xzFragment);
        }

//        if(null!=ventureServiceFragment){
//            mFragments.add(ventureServiceFragment);
//            transaction.add(R.id.fl_container,ventureServiceFragment);
//            transaction.hide(ventureServiceFragment);
//
//        }
//
//        if(null!=orderFragment){
//            mFragments.add(orderFragment);
//            transaction.add(R.id.fl_container,orderFragment);
//            transaction.hide(orderFragment);
//        }
//
//
//        if(null!=myFragment){
//            mFragments.add(myFragment);
//            transaction.add(R.id.fl_container,myFragment);
//            transaction.hide(myFragment);
//        }


        transaction.commit();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
        FragmentManager manager = getSupportFragmentManager();
        if (null!=sxFragment&&sxFragment.isAdded()) {
            manager.putFragment(outState, "sxFragment", sxFragment);
        }
        if (null!=xzFragment&&xzFragment.isAdded()) {
            manager.putFragment(outState, "xzFragment", xzFragment);
        }
//        if (null!=ventureServiceFragment&&ventureServiceFragment.isAdded()) {
//            manager.putFragment(outState, "ventureServiceFragment", ventureServiceFragment);
//        }
//
//
//        if (null!=orderFragment&&orderFragment.isAdded()) {
//            manager.putFragment(outState, "orderFragment", orderFragment);
//        }
//        if (null!=myFragment&&myFragment.isAdded()) {
//            manager.putFragment(outState, "myFragment", myFragment);
//        }


    }
}
