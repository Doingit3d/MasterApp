package com.example.dann.pcsilos;

import android.graphics.Color;
import android.util.Log;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dann on 06/12/2017.
 */


public class UtilityGraph {

    public static void LineGraphAnual(LineChart chart, ArrayList<Silo> silos) {
        ArrayList<Integer> color = new ArrayList<>();
        color.add(Color.BLUE);
        color.add(Color.RED);
        color.add(Color.YELLOW);
        color.add(Color.CYAN);
        color.add(Color.GREEN);
        color.add(Color.MAGENTA);



        float pesoEspecific;
        List<Entry> siloEntries;
        LineDataSet setSilo;
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        LineData data;

        //Recorro el array de los silos dados de alta
        for (int i = 0; i < silos.size(); i++) {
            siloEntries = new ArrayList<Entry>();
            Log.e("loop del silo", silos.get(i).getNombre());
            ArrayList<Float> pesos = silos.get(i).getListPeso();
            Log.e("depues del silo", silos.get(i).getNombre());

            for (int j = 0; j < pesos.size(); j++) {
                Log.e("inicio peso silo", pesos.get(j).toString());
                pesoEspecific = pesos.get(j);
                siloEntries.add(new Entry(j, pesoEspecific));
                Log.e("inicio peso silo", "PAsó");
            }//for de pesos de cada silo

            setSilo = new LineDataSet(siloEntries, silos.get(i).getNombre()); // le paso el entrie y el nombre del silo
            setSilo.setCircleColors(color.get(i));
            setSilo.setColors(color.get(i));

            setSilo.setHighlightEnabled(true);
            setSilo.setDrawHighlightIndicators(true);
            setSilo.setHighLightColor(Color.RED);
            dataSets.add(setSilo);
            data = new LineData(dataSets);
            chart.setData(data);
            chart.setDoubleTapToZoomEnabled(true);
            chart.setDragEnabled(true);
            chart.setScaleEnabled(true);
            chart.setDragDecelerationEnabled(true);
            chart.animateXY(3000, 3000);


        }



        final String[] period = new String[]{"ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEPT", "OCT", "NOV", "DIC"};
        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return period[(int) value];
            }

            // we don't draw numbers, so no decimal digits needed

        };

        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setDrawLabels(false);

    }

    public static void LineGraphMensual(LineChart chart, ArrayList<Silo> silos) {
        float pesoEspecific;
        List<Entry> siloEntries;
        LineDataSet setSilo;
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        LineData data;

        //Recorro el array de los silos dados de alta
        for (int i = 0; i < silos.size(); i++) {
            siloEntries = new ArrayList<Entry>();
            Log.e("loop del silo", silos.get(i).getNombre());
            ArrayList<Float> pesos = silos.get(i).getListPeso();
            Log.e("depues del silo", silos.get(i).getNombre());

            for (int j = 0; j < pesos.size(); j++) {
                Log.e("inicio peso silo", pesos.get(j).toString());
                pesoEspecific = pesos.get(j);
                siloEntries.add(new Entry(j, pesoEspecific));
                Log.e("inicio peso silo", "PAsó");
            }//for de pesos de cada silo

            setSilo = new LineDataSet(siloEntries, silos.get(i).getNombre()); // le paso el entrie y el nombre del silo
            //Estilo del grafico
            setSilo.setHighlightEnabled(true);
            setSilo.setDrawHighlightIndicators(true);
            setSilo.setHighLightColor(Color.BLACK);
            dataSets.add(setSilo);
            data = new LineData(dataSets);
            chart.setData(data);
            chart.setDoubleTapToZoomEnabled(true);
            chart.setDragEnabled(true);
            chart.setScaleEnabled(true);
            chart.setDragDecelerationEnabled(true);
            chart.animateX(3000, Easing.EasingOption.EaseInBack);
            chart.animateY(3000, Easing.EasingOption.EaseInElastic);

        }


        final String[] period = new String[]{"01", "01", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
                "25", "26", "27", "28", "29", "30", "31"};
        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return period[(int) value];
            }

            // we don't draw numbers, so no decimal digits needed

        };

        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);

        xAxis.setTextColor(Color.RED);
        YAxis leftAxis = chart.getAxisLeft();
        LimitLine ll = new LimitLine(140f, "Critical Blood Pressure");
        ll.setLineColor(Color.RED);
        ll.setLineWidth(4f);
        ll.setTextColor(Color.RED);
        ll.setTextSize(12f);
// .. and more styling options

        leftAxis.addLimitLine(ll);

    }
}

