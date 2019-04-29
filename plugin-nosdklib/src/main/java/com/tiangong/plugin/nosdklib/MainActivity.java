package com.tiangong.plugin.nosdklib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

//import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {


   private GridView gv;
    private HomeAdapter homeAdapter;
    private int [] mip = {
            R.mipmap.rat,R.mipmap.cattle,R.mipmap.tiger,
            R.mipmap.rabbit,R.mipmap.dragon,R.mipmap.snake,R.mipmap.hourse,
            R.mipmap.sheep,R.mipmap.monkey,R.mipmap.chicken,R.mipmap.dog,
            R.mipmap.pig,};
    private String [] name = {
            "鼠","牛","虎",
            "兔","龙","蛇","马",
            "羊","猴","鸡","狗",
            "猪",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        gv = findViewById(R.id.gv);
        gv.setNumColumns(2);
        List<Item> list = new ArrayList<>();
        for (int i = 0; i <mip.length ; i++) {
            Item item = new Item();
            item.setId(i);
            item.setImg(mip[i]);
            item.setName(name[i]);
            list.add(item);
        }
        homeAdapter = new HomeAdapter(this,list);
        gv.setAdapter(homeAdapter);
    }
}
