package com.example.dann.pcsilos;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by dann on 08/12/2017.
 */
public class MyPagerAdapter extends PagerAdapter {


    private boolean isMultiScr;


    public MyPagerAdapter() {
        this.isMultiScr = isMultiScr;
    }


    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ConstraintLayout linearLayout = (ConstraintLayout) LayoutInflater.from(container.getContext()).inflate(R.layout.scroll_silos_select, null);
        //new LinearLayout(container.getContext());
       /* CardView textView = (CardView) linearLayout.findViewById(R.id.recu_scroll_silo);
        TextView tv = (TextView) linearLayout.findViewById(R.id.tv_scroll_consumo_silo);
        tv.setText("Silo 1");*/

        container.addView(linearLayout);
//        linearLayout.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, container.getContext().getResources().getDisplayMetrics());
//        linearLayout.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, container.getContext().getResources().getDisplayMetrics());
        return linearLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ConstraintLayout view = (ConstraintLayout) object;
        container.removeView(view);
    }
}

