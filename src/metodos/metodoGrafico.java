/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author villa
 */
public class metodoGrafico {

    XYSeries serie1, serie2, serie3;
    XYSeriesCollection dataset;
    JFreeChart chart;
    ChartPanel panel;
    XYPlot pt;
    XYLineAndShapeRenderer render;
    

    public metodoGrafico() {
    }

    public ChartPanel graficar(double inicio, double fin) {
        serie1 = new XYSeries("funcion");
        serie2 = new XYSeries("X");
        serie3 = new XYSeries("Y");
        dataset = new XYSeriesCollection();
        render = new XYLineAndShapeRenderer();

        for (double i = inicio; i <= fin; i += 0.1) {
            serie1.add(i, funcion(i));
        }
        serie2.add(-100, 0);
        serie2.add(100, 0);
        serie3.add(0, -100);
        serie3.add(0, 100);

        dataset.addSeries(serie1);
        dataset.addSeries(serie2);
        dataset.addSeries(serie3);
        chart = ChartFactory.createXYLineChart("", "X", "Y", dataset, PlotOrientation.VERTICAL, false, true, false);
        panel = new ChartPanel(chart);

        pt = chart.getXYPlot();
        
        
        render.setSeriesShapesVisible(0, Boolean.FALSE);
        render.setSeriesShapesVisible(1, Boolean.FALSE);
        render.setSeriesShapesVisible(2, Boolean.FALSE);
        render.setSeriesPaint(0, Color.RED);
        render.setSeriesPaint(1, Color.BLACK);
        render.setSeriesPaint(2, Color.BLACK);
        render.setDrawOutlines(true);
        render.setItemLabelsVisible(Boolean.TRUE);
        
        panel.setDomainZoomable(true);
        panel.setMouseWheelEnabled(true);
        panel.setHorizontalAxisTrace(true);
        panel.setVerticalAxisTrace(true);
        pt.setBackgroundPaint(Color.WHITE);
        pt.setDomainPannable(true);
        pt.setRangePannable(true);
        pt.setRenderer(render);

        return panel;
    }

    public double funcion(double i) {
        return (Math.exp(i - 1)) - (1.5 * i);
    }
}
