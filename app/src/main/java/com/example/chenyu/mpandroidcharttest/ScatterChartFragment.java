package com.example.chenyu.mpandroidcharttest;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by Think on 2015/11/29.
 */
public class ScatterChartFragment extends Fragment {
    public ScatterChart scatterChart;
    public ArrayList<String> x = new ArrayList<String>();
    public ArrayList<Entry> y = new ArrayList<Entry>();
    public ArrayList<ScatterDataSet> scatterDataSets = new ArrayList<ScatterDataSet>();
    public ScatterData scatterData = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scatter_chart, container, false);
        scatterChart = (ScatterChart) view.findViewById(R.id.scatter_chart);
        ScatterData resultScatterData = getRadarData(40, 100);
        showChart();
        return view;
    }

    /**
     * gv
     * 初始化数据
     * count 表示坐标点个数，range表示等下y值生成的范围
     */
    public ScatterData getRadarData(int count, float range) {
        for (int i = 0; i < count; i++) {  //X轴显示的数据
            x.add(i + "");
        }
        for (int i = 0; i < count; i++) {//y轴的数据
            float result = (float) (Math.random() * range) + 3;
            y.add(new Entry(result, i));
        }
        ScatterDataSet scatterDataSet = new ScatterDataSet(y, "散状图");//y轴数据集合
        scatterDataSet.setColor(Color.RED);//现实颜色
        scatterDataSet.setScatterShapeSize(6f);
        scatterDataSet.setDrawValues(true);
        scatterDataSet.setHighLightColor(Color.WHITE);//高度线的颜色
        scatterDataSets.add(scatterDataSet);
        scatterData = new ScatterData(x, scatterDataSets);
        return scatterData;
    }

    /**
     * 设置样式
     */
    public void showChart() {
        scatterChart.setDrawBorders(false);//是否添加边框
        scatterChart.setDescription("有风险的数据");//数据描述
        scatterChart.setNoDataTextDescription("我需要数据");//没数据显示
        scatterChart.setDrawGridBackground(true);//是否显示表格颜色
        scatterChart.setBackgroundColor(Color.YELLOW);//背景颜色
        scatterChart.setData(scatterData);//设置数据
        Legend legend = scatterChart.getLegend();//设置比例图片标示，就是那一组Y的value
        legend.setForm(Legend.LegendForm.CIRCLE);//样式
        legend.setFormSize(6f);//字体
        legend.setTextColor(Color.WHITE);//设置颜色
        scatterChart.animateX(2000);//X轴的动画
    }
}
