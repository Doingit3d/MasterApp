package com.example.dann.pcsilos;

import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dann on 10/12/2017.
 */

public class MyPagerAdapter2 extends PagerAdapter {


    private boolean isMultiScr;


    public MyPagerAdapter2() {
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

        ConstraintLayout linearLayout = (ConstraintLayout) LayoutInflater.from(container.getContext()).inflate(R.layout.scroll_silo_estado, null);
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

