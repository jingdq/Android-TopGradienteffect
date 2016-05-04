package com.example.wanglong.topgradienteffect;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by wang.long on 2016/4/28.
 */
public class HomeActivity extends Activity{

    private LinearLayout v;
    private ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle saveInstanceSate){
        super.onCreate(saveInstanceSate);

        super.setContentView(R.layout.home);

        initData();
    }


    public void initData(){
        v =(LinearLayout) findViewById(R.id.visatitle);
        v.getBackground().setAlpha(0);


        ChangeTitle();
    }

    public void ChangeTitle(){
        mScrollView=(ScrollView) findViewById(R.id.scrollvisacontent);

        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                Log.d("height:---------", String.valueOf(mScrollView.getScrollY()));
                int sy=mScrollView.getScrollY();
                if(sy>=0 && sy<=255){
                    v.getBackground().setAlpha(sy);
                } else if(sy>255){
                    v.getBackground().setAlpha(255);
                }
            }
        });
    }








}
