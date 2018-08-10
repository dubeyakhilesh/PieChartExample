package xipe.com.pichartdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(15.0f, "2014"));
        entries.add(new PieEntry(5.0f, "2015"));
        entries.add(new PieEntry(20.0f, "2016"));
        entries.add(new PieEntry(15.0f, "2074"));
        entries.add(new PieEntry(25.0f, "2018"));
        piChart(entries);
    }

    private void piChart(ArrayList<PieEntry> entries){
        PieChart piChart = (PieChart) findViewById(R.id.pi_chart);
        String cost = "Demo";
        PieDataSet dataSet = new PieDataSet(entries, cost);

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        //data.setValueTypeface(mTfLight);
        piChart.setData(data);

        // undo all highlights
        piChart.highlightValues(null);
        piChart.setDrawHoleEnabled(false);
        piChart.setUsePercentValues(true);

        piChart.invalidate();
    }
}
