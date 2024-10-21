package com.tlr.sorts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChartDrawer extends JFrame {
    public ChartDrawer(String title) {
        super(title);

        List<double[]> dataSorted = CSVDataReader.readCSV("sort_data.csv");
        List<double[]> dataReversed = CSVDataReader.readCSV("sort_data_revsorted.csv");
        List<double[]> dataPartial = CSVDataReader.readCSV("sort_data_partial.csv");

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel combinedChartPanel = createCombinedChartPanel(dataSorted, dataReversed, dataPartial);
        tabbedPane.addTab("Общий график", combinedChartPanel);

        JPanel sortedChartPanel = createSingleChartPanel(dataSorted, "График отсортированных данных", Color.BLUE);
        tabbedPane.addTab("Отсортированные", sortedChartPanel);

        JPanel reversedChartPanel = createSingleChartPanel(dataReversed, "График обратно отсортированных данных", Color.RED);
        tabbedPane.addTab("Обратно отсортированные", reversedChartPanel);

        JPanel partialChartPanel = createSingleChartPanel(dataPartial, "График частично отсортированных данных", Color.YELLOW);
        tabbedPane.addTab("Частично отсортированные", partialChartPanel);

        setContentPane(tabbedPane);
    }

    private JPanel createCombinedChartPanel(List<double[]> dataSorted, List<double[]> dataReversed, List<double[]> dataPartial) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries sortedSeries = createSeries(dataSorted, "Отсортированные данные");
        dataset.addSeries(sortedSeries);

        XYSeries reversedSeries = createSeries(dataReversed, "Обратно отсортированные данные");
        dataset.addSeries(reversedSeries);

        XYSeries partialSeries = createSeries(dataPartial, "Частично отсортированные данные");
        dataset.addSeries(partialSeries);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Общий график", "Размер массива", "Время", dataset, PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesShapesVisible(2, true);
        renderer.setSeriesLinesVisible(2, true);

        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesPaint(2, Color.YELLOW);

        plot.setRenderer(renderer);

        return new ChartPanel(chart);
    }

    private JPanel createSingleChartPanel(List<double[]> data, String title, Color color) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = createSeries(data, title);
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                title, "Размер массива", "Время", dataset, PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesLinesVisible(0, true);

        renderer.setSeriesPaint(0, color);
        plot.setRenderer(renderer);

        return new ChartPanel(chart);
    }

    private XYSeries createSeries(List<double[]> data, String name) {
        XYSeries series = new XYSeries(name);
        for (double[] row : data) {
            if (row.length >= 2) {
                series.add(row[0], row[1]);
            }
        }
        return series;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChartDrawer example = new ChartDrawer("Графики сортировки");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}

