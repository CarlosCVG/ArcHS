package vista.paneles;

import controlador.CtrlAdmin;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Map;
import modelo.util.ScrollPaneCustomizer;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class PanAdminCE extends JPanel {

    private CtrlAdmin ctrlad;
    private int year;

    public PanAdminCE() {
        initComponents(); // Aquí se inicializan panelCostos, panelGanancias, etc.
        ScrollPaneCustomizer.customizeScrollPane(jScrollPane1);
        ctrlad = new CtrlAdmin();
        this.year = LocalDate.now().getYear();

        generarGraficoCostos();
        generarGraficoGanancias();
        generarGraficoReservaciones();
        generarGraficoCostosPorcentaje(); // <- nuevo

    }

    private void generarGraficoCostos() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10000, "Costos", "Empleado 1");
        dataset.addValue(7500, "Costos", "Empleado 2");
        dataset.addValue(8500, "Costos", "Empleado 3");
        dataset.addValue(1200, "Costos", "Agua");
        dataset.addValue(1800, "Costos", "Luz");
        dataset.addValue(1000, "Costos", "Internet");

        JFreeChart chart = ChartFactory.createBarChart(
                "Costos por Sueldos y Servicios",
                "Concepto", "Monto ($)", dataset,
                PlotOrientation.VERTICAL, false, true, false);

        personalizarGrafico(chart);

        mostrarGraficoEnPanel(chart, panelCostos);
    }

    private void generarGraficoGanancias() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int precio = 300;

        Map<Integer, Integer> reservasPorMes = ctrlad.cantRxM(year);

        for (int mes = 1; mes <= 12; mes++) {
            int cantidad = reservasPorMes.getOrDefault(mes, 0);
            dataset.addValue(cantidad * precio, "Ganancia", "Mes " + mes);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Ganancias por Reservaciones",
                "Mes", "Ganancias ($)", dataset,
                PlotOrientation.VERTICAL, false, true, false);

        personalizarGrafico(chart);

        mostrarGraficoEnPanel(chart, panelGanancias);
    }

    private void generarGraficoReservaciones() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<Integer, Integer> reservasPorMes = ctrlad.cantRxM(year);

        for (int mes = 1; mes <= 12; mes++) {
            int cantidad = reservasPorMes.getOrDefault(mes, 0);
            dataset.addValue(cantidad, "Reservaciones", "Mes " + mes);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Reservaciones por Mes",
                "Mes", "Cantidad", dataset,
                PlotOrientation.VERTICAL, false, true, false);

        personalizarGrafico(chart);

        mostrarGraficoEnPanel(chart, panelReservaciones);
    }

    private void generarGraficoCostosPorcentaje() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        double sueldoTotal = 10000 + 7500 + 8500;
        double agua = 1200;
        double luz = 1800;
        double internet = 1000;

        dataset.setValue("Sueldos", sueldoTotal);
        dataset.setValue("Agua", agua);
        dataset.setValue("Luz", luz);
        dataset.setValue("Internet", internet);

        JFreeChart chart = ChartFactory.createPieChart(
                "Distribución de Costos",
                dataset,
                true, true, false);

        personalizarGraficoPie(chart);

        panelCostos2.removeAll();
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setOpaque(false);
        chartPanel.setBackground(new Color(1, 74, 173));
        panelCostos2.setLayout(new BorderLayout());
        panelCostos2.add(chartPanel, BorderLayout.CENTER);
        panelCostos2.revalidate();
        panelCostos2.repaint();
    }

    private void personalizarGraficoPie(JFreeChart chart) {
        chart.setBackgroundPaint(new Color(1, 74, 173));
        chart.getTitle().setPaint(Color.WHITE);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(1, 74, 173));
        plot.setOutlineVisible(false);
        plot.setLabelBackgroundPaint(Color.WHITE);
        plot.setLabelPaint(Color.BLACK);
        plot.setSectionPaint("Sueldos", new Color(255, 204, 0));
        plot.setSectionPaint("Agua", new Color(0, 191, 255));    // Celeste
        plot.setSectionPaint("Luz", new Color(255, 140, 0));     // Naranja
        plot.setSectionPaint("Internet", new Color(144, 238, 144)); // Verde claro
    }

    private void mostrarGraficoEnPanel(JFreeChart chart, JPanel panel) {
        panel.removeAll();
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setOpaque(false);
        chartPanel.setBackground(new Color(1, 74, 173));
        panel.setLayout(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }

    private void personalizarGrafico(JFreeChart chart) {
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(1, 74, 173));
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.WHITE);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(255, 204, 0));
        renderer.setDrawBarOutline(false);

        chart.setBackgroundPaint(new Color(1, 74, 173));
        chart.getTitle().setPaint(Color.WHITE);
        plot.getDomainAxis().setTickLabelPaint(Color.WHITE);
        plot.getDomainAxis().setLabelPaint(Color.WHITE);
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE);
        plot.getRangeAxis().setLabelPaint(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();
        panelGanancias = new javax.swing.JPanel();
        panelCostos2 = new javax.swing.JPanel();
        panelCostos = new javax.swing.JPanel();
        panelReservaciones = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        body.setBackground(new java.awt.Color(1, 74, 173));
        body.setInheritsPopupMenu(true);
        body.setLayout(new java.awt.GridLayout(4, 1));

        panelGanancias.setLayout(new java.awt.BorderLayout());
        body.add(panelGanancias);

        panelCostos2.setLayout(new java.awt.BorderLayout());
        body.add(panelCostos2);

        panelCostos.setLayout(new java.awt.BorderLayout());
        body.add(panelCostos);

        panelReservaciones.setLayout(new java.awt.BorderLayout());
        body.add(panelReservaciones);

        jScrollPane1.setViewportView(body);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        header.setBackground(new java.awt.Color(1, 74, 173));
        header.setInheritsPopupMenu(true);
        header.setLayout(new java.awt.BorderLayout());

        lblTitulo.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Aqui puedes observar las estadisticas del hotel");
        lblTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        header.add(lblTitulo, java.awt.BorderLayout.CENTER);

        add(header, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelCostos;
    private javax.swing.JPanel panelCostos2;
    private javax.swing.JPanel panelGanancias;
    private javax.swing.JPanel panelReservaciones;
    // End of variables declaration//GEN-END:variables
}
