package com.example.dann.pcsilos;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.mikephil.charting.charts.LineChart;
import com.race604.drawable.wave.WaveDrawable;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.transformer.UltraDepthScaleTransformer;

import java.util.ArrayList;

import devlight.io.library.ArcProgressStackView;


import static com.example.dann.pcsilos.MainActivity.globalContext;
import static com.example.dann.pcsilos.UtilityGraph.LineGraphAnual;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuResumen.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MenuResumen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuResumen extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MenuResumen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuResumen.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuResumen newInstance(String param1, String param2) {
        MenuResumen fragment = new MenuResumen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu_resumen, container, false);


        final ArrayList<ArcProgressStackView.Model> models = new ArrayList<>();
        models.add(new ArcProgressStackView.Model("Circle", 25,Color.parseColor("#ce747e")));
        models.add(new ArcProgressStackView.Model("Progress", 50, Color.parseColor("#f6c358")));
        models.add(new ArcProgressStackView.Model("Stack", 75, Color.parseColor("#3ea69b")));
        models.add(new ArcProgressStackView.Model("View", 100, Color.parseColor("#000000")));

        final ArcProgressStackView arcProgressStackView = (ArcProgressStackView) v.findViewById(R.id.arc);
        arcProgressStackView.setModels(models);



/**********************scroll view ***********************************************************************/
        UltraViewPager ultraViewPager = (UltraViewPager)v.findViewById(R.id.ultra_viewpager_resumen);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        ultraViewPager.setMultiScreen(0.6f);
        ultraViewPager.setItemRatio(1.0f);
       // ultraViewPager.setAutoMeasureHeight(true);
        ultraViewPager.setInfiniteRatio(100);
        ultraViewPager.setPageTransformer(false, new UltraDepthScaleTransformer());
//initialize UltraPagerAdapter，and add child view to UltraViewPager
        MyPagerAdapter2 adapter = new MyPagerAdapter2();
        ultraViewPager.setAdapter(adapter);

//initialize built-in indicator
        ultraViewPager.initIndicator();
//set style of indicators
        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(Color.GREEN)
                .setNormalColor(Color.WHITE)
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));
//set the alignment
        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
//construct built-in indicator, and add it to  UltraViewPager
        ultraViewPager.getIndicator().build();

//set an infinite loop
        ultraViewPager.setInfiniteLoop(true);
//enable auto-scroll mode
        ultraViewPager.setAutoScroll(2000);
/*********************************************************************************************/

/**************** Estado del silo ********************************************************/
       /* ImageView im = (ImageView) v.findViewById(R.id.silo_estado);

        WaveDrawable mWaveDrawable = new WaveDrawable(globalContext, R.drawable.silo_estado);

// Use as common drawable

        im.setImageDrawable(mWaveDrawable);
        mWaveDrawable.setIndeterminate(true);
*/
/**********************************************************************************************/


        return v;



    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
