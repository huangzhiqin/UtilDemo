package com.first.alina.utilsdemo.kline.viewholer;

import android.content.Context;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;

/**
 * Created by alina on 2018/8/28.
 */
@BindLayout(R.layout.viewholder_broken_line1)
public class BrokenLine1ViewHolder extends ViewHolder<LineData>{
    private Context context;
    private LineChart lineChart;
    public BrokenLine1ViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        lineChart=getView(R.id.lineChar1);
    }

    @Override
    public void setContent(LineData item, int position) {
        lineChart.getDescription().setEnabled(false);
        lineChart.setDrawGridBackground(false);

        XAxis xAxis=lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);


        YAxis leftXAis=lineChart.getAxisLeft();
        leftXAis.setLabelCount(4);

        YAxis rightAxis=lineChart.getAxisRight();
        rightAxis.setLabelCount(3);

        lineChart.setData(item);

        lineChart.animateX(750);
    }
}
