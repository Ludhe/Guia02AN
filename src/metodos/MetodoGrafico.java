/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
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
public class MetodoGrafico {

    XYSeries serie1;
    XYSeriesCollection dataset;
    JFreeChart chart;
    ChartPanel panel;
    XYPlot plot;
    XYLineAndShapeRenderer render;
    Robot robot;

    public MetodoGrafico() {
    }

    public ChartPanel graficar(double inicio, double fin) {
        serie1 = new XYSeries("funcion");
        dataset = new XYSeriesCollection();
        render = new XYLineAndShapeRenderer();

        for (double i = inicio; i <= fin; i += 0.1) {
            serie1.add(i, funcion(i));
        }

        dataset.addSeries(serie1);
        chart = ChartFactory.createXYLineChart("", "", "", dataset, PlotOrientation.VERTICAL, false, true, false);
        panel = new ChartPanel(chart);

        plot = chart.getXYPlot();

        render.setSeriesShapesVisible(0, Boolean.FALSE);
        render.setSeriesPaint(0, Color.RED);

        panel.setDomainZoomable(true);
        panel.setRangeZoomable(true);
        panel.setMouseWheelEnabled(true);
        panel.setHorizontalAxisTrace(true);
        panel.setVerticalAxisTrace(true);
        panel.addChartMouseListener(new ChartMouseListener() {

            @Override
            public void chartMouseMoved(ChartMouseEvent event) {
                try {
                    robot = new Robot();
                    robot.keyPress(KeyEvent.VK_CONTROL);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            @Override
            public void chartMouseClicked(ChartMouseEvent event) {
            }
        });

        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);

        plot.setRenderer(render);
        return panel;
    }

    public double funcion(double i) {
        return i*i;
//        return (Math.exp(i - 1)) - (1.5 * i);
    }
    
}
