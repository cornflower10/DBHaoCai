package com.tiangong.plugin.nosdklib;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    private CommonViewPager commonViewPager;

    private List<PageItem> pageItemList = new ArrayList<>();
    private HashMap<Integer,String []> hashMapZH = new HashMap();
    private HashMap<Integer,String []> hashMapEN = new HashMap();

    private String [] name = {
            "鼠","牛","虎",
            "兔","龙","蛇","马",
            "羊","猴","鸡","狗",
            "猪",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        commonViewPager = findViewById(R.id.cvp);
       findViewById(R.id.iv).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               InfoActivity.this.finish();
           }
       });

        for (int i = 0; i < 12; i++) {
            if(i==0){
                String [] ratZH =  getResources().getStringArray(R.array.rat_zh);
                String [] ratEN =  getResources().getStringArray(R.array.rat_en);
                hashMapZH.put(i,ratZH);
                hashMapEN.put(i,ratEN);
            } else if(i==1){
                hashMapZH.put(i,getResources().getStringArray(R.array.cattle_zh));
                hashMapEN.put(i,getResources().getStringArray(R.array.cattle_en));
            }else if(i==2){
                hashMapZH.put(i,getResources().getStringArray(R.array.tiger_zh));
                hashMapEN.put(i,getResources().getStringArray(R.array.tiger_en));
            }else if(i==3){
                hashMapZH.put(i,getResources().getStringArray(R.array.rabbit_zh));
                hashMapEN.put(i,getResources().getStringArray(R.array.rabbit_en));
            }else if(i==4){
                hashMapZH.put(i,getResources().getStringArray(R.array.dragon_zh));
                hashMapEN.put(i,getResources().getStringArray(R.array.dragon_en));
            }else if(i==5){
                hashMapZH.put(i,getResources().getStringArray(R.array.snake_zh));
                hashMapEN.put(i,getResources().getStringArray(R.array.snake_en));
            }else if(i==6){
                hashMapZH.put(i,getResources().getStringArray(R.array.hourse_zh));
                hashMapEN.put(i,getResources().getStringArray(R.array.hourse_en));
            }else if(i==7){
                hashMapZH.put(i,getResources().getStringArray(R.array.sheep_zh));
                hashMapEN.put(i,getResources().getStringArray(R.array.sheep_en));
            }else if(i==8){
                hashMapZH.put(i,getResources().getStringArray(R.array.monkey_zh));
                hashMapEN.put(i,getResources().getStringArray(R.array.monkey_en));
            }else if(i==9){
                hashMapZH.put(i,getResources().getStringArray(R.array.chicken_zh));
                hashMapEN.put(i,getResources().getStringArray(R.array.chicken_en));
            }else if(i==10){
                hashMapZH.put(i,getResources().getStringArray(R.array.dog_zh));
                hashMapEN.put(i,getResources().getStringArray(R.array.dog_en));
            }else if(i==11){
                hashMapZH.put(i,getResources().getStringArray(R.array.pig_zh));
                hashMapEN.put(i,getResources().getStringArray(R.array.pig_en));
            }

        }
        Item item = (Item) getIntent().getSerializableExtra("item");
       String[] temp =  hashMapZH.get(item.getId());
        String[] tempEn =  hashMapEN.get(item.getId());
        for (int i = 0; i < temp.length ; i++) {
            PageItem pageItem = new PageItem();
            pageItem.setZh(temp[i]);
            pageItem.setEn(tempEn[i]);
            pageItem.setImg(item.getImg());
            pageItemList.add(pageItem);
        }


        commonViewPager.setPages(pageItemList, new ViewPagerHolderCreator() {
            @Override
            public ViewPagerHolder createViewHolder() {
                return new ViewImageHolder();
            }
        });
    }

    public static class ViewImageHolder implements ViewPagerHolder<PageItem>{
        private TextView tv_zh,tv_en;
        private ImageView iv_a;
        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.viewpager_item,null);
            tv_zh = (TextView) view.findViewById(R.id.tv_zh);
            tv_en = (TextView) view.findViewById(R.id.tv_en);
            iv_a =  (ImageView) view.findViewById(R.id.iv_a);
            iv_a.setAlpha(0.2f);
            return view;
        }

        @Override
        public void onBind(Context context, int position, PageItem data) {
            tv_zh.setText(data.getZh());
            tv_en.setText(data.getEn());
            iv_a.setBackgroundResource(data.getImg());
        }
    }
}
