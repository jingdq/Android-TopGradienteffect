package com.example.wanglong.topgradienteffect;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

/**
 * Created by wang.long on 2016/4/28.
 */
public class HomeActivity extends Activity implements View.OnScrollChangeListener {

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

        mScrollView.setOnScrollChangeListener(this);

    }
    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {



    }


    //滑动title透明度变化
    public void initChangeTitle(){
        mScrollView=(ScrollView) findViewById(R.id.scrollvisacontent);
        mScrollView.setOnTouchListener(new TouchListenerImpl());
        final ViewTreeObserver.OnScrollChangedListener listener = new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int sy=mScrollView.getScrollY();
                if(sy>=0 && sy<=255){
                    v.getBackground().setAlpha(sy);
                } else if(sy>255){
                    v.getBackground().setAlpha(255);
                }
            }
        };
        ViewTreeObserver observer = mScrollView.getViewTreeObserver();
        observer.addOnScrollChangedListener(listener);
    }

    //监控touch事件title透明度变化
    private class TouchListenerImpl implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            //System.out.println(view.getScrollY());
            int sy=view.getScrollY();
            if(sy>=0 && sy<=255){
                v.getBackground().setAlpha(view.getScrollY());
            } else if(sy>255){
                v.getBackground().setAlpha(255);
            }
            return false;
        }

    }

}
