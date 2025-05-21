/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

/**
 *
 * @author edwin
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.time.LocalDate;
import java.util.List;
import modelo.vo.Reservacion;

// Interfaz del patrón Observer
public class Calendario extends JPanel {

    private int year;
    private int month;
    private int fontSize = 21;
    private List<RectCelda> celdas = new ArrayList<>();
    private List<Reservacion> reservaciones;
    private boolean currentClick = false;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Observer> observers = new ArrayList<>();
    private Map<Integer, Color> colorHabitaciones = new HashMap<>();

    public Calendario(int year, int month, List<Reservacion> reservaciones) {
        this.year = year;
        this.month = month;
        this.reservaciones = reservaciones;
        this.setBackground(Color.WHITE); //Color de fondo
        generarColoresHabitaciones();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LocalDate selectedDate = getSelectedDate(e);
                if (selectedDate == null) {
                    return;
                }

                if (selectedDate.isBefore(LocalDate.now())) {
                    mostrarMensaje("¡Error! No se puede seleccionar un día anterior a hoy.");
                    return;  // No permite seleccionar días pasados
                }

                if (currentClick) {
                    setFechaFin(selectedDate);
                    if (fechaInicio != null && fechaFin != null && !fechaFin.isBefore(fechaInicio)) {
                        if (esPeriodoValido(fechaInicio, fechaFin)) {
                            repaint();
                            mostrarMensaje("Periodo seleccionado\ncon exito, de click en reservar.");
                        } else {
                            mostrarMensaje("El periodo seleccionado\nse empalma con otro existente.");
                            setFechaFin(null);
                        }
                    }
                    currentClick = false;
                } else {
                    setFechaInicio(selectedDate);
                    setFechaFin(null);
                    currentClick = true;
                }
                repaint();
            }
        });
    }

    private void mostrarMensaje(String mensaje) {
        ImageIcon originalIcon = new ImageIcon("src/vista/images/LOGO.png");  // Cambia esta ruta por la de tu imagen

        // Redimensionar la imagen
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(75, 90, Image.SCALE_SMOOTH); // Ajusta el tamaño (ancho y alto)

        // Crear el nuevo ImageIcon con la imagen redimensionada
        ImageIcon customIcon = new ImageIcon(resizedImage);
        JOptionPane optionPane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, customIcon);
        JDialog dialog = optionPane.createDialog(this, "Advertencia");
        dialog.setLocationRelativeTo(this);

        dialog.setVisible(true);
    }

    public Calendario() {
        LocalDate now = LocalDate.now();
        this.year = now.getYear();
        this.month = now.getMonthValue();
        this.reservaciones = new ArrayList<>();
        this.setBackground(new Color(45, 52, 54));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LocalDate selectedDate = getSelectedDate(e);
                if (selectedDate == null) {
                    return;
                }

                if (selectedDate.isBefore(LocalDate.now())) {
                    mostrarMensaje("¡Error! No se puede seleccionar un día anterior a hoy.");
                    return;  // No permite seleccionar días pasados
                }

                if (currentClick) {
                    setFechaFin(selectedDate);
                    if (fechaInicio != null && fechaFin != null && !fechaFin.isBefore(fechaInicio)) {
                        if (esPeriodoValido(fechaInicio, fechaFin)) {
                            repaint();
                            mostrarMensaje("Periodo seleccionado\ncon exito, de click en reservar.");
                        } else {
                            mostrarMensaje("El periodo seleccionado\nse empalma con otro existente.");
                            setFechaFin(null);
                        }
                    }
                    currentClick = false;
                } else {
                    setFechaInicio(selectedDate);
                    setFechaFin(null);
                    currentClick = true;
                }
                repaint();
            }
        });
    }

    public void setYear(int year) {
        this.year = year;
        repaint();
    }

    public void setMonth(int month) {
        this.month = month;
        repaint();
    }

    public void setReservaciones(List<Reservacion> reservaciones) {
        this.reservaciones = reservaciones;
        generarColoresHabitaciones();
        repaint();
    }

    private void generarColoresHabitaciones() {
        Random rnd = new Random();
        colorHabitaciones.clear();
        for (Reservacion r : reservaciones) {
            if (!colorHabitaciones.containsKey(r.getId_habitacion())) {
                //[1,74,173]
                colorHabitaciones.put(r.getId_habitacion(), new Color(1, rnd.nextInt(0, 100), rnd.nextInt(0, 200)));
            }
        }
    }

    private boolean esPeriodoValido(LocalDate inicio, LocalDate fin) {
        for (Reservacion r : reservaciones) {
            if (!(fin.isBefore(r.getF_entrada()) || inicio.isAfter(r.getF_salida()))) {
                return false;
            }
        }
        return true;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    private LocalDate getSelectedDate(MouseEvent e) {
        for (RectCelda celda : celdas) {
            if (celda.area.contains(e.getPoint())) {
                return LocalDate.of(year, month, celda.dia);
            }
        }
        return null;
    }

    public void setFontSize(int size) {
        this.fontSize = size;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCalendar(g);
    }

    private void drawCalendar(Graphics g) {
        celdas.clear();

        String[] daysOfWeek = {"Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"};
        int panelWidth = this.getWidth() - this.getWidth() / 6; // Para que no se extienda todo el ancho de la ventana se divide entre 6
        int panelHeight = this.getHeight() - this.getHeight() / 8;
        int dayWidth = panelWidth / 7; // Para 7 columnas
        int headerHeight = 40;
        int rows = 5; // 6 renglones
        int dayHeight = (panelHeight - headerHeight) / rows;

        int totalCalendarHeight = headerHeight + rows * dayHeight;
        int offsetX = (this.getWidth() - panelWidth) / 2; // Centrado horizontal
        int offsetY = (this.getHeight() - totalCalendarHeight) / 2; // Centrado vertical

        g.setFont(new Font("Monospace", Font.PLAIN, fontSize));

        for (int i = 0; i < 7; i++) {
            g.setColor(new Color(255, 204, 0));

            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(daysOfWeek[i]);
            int x = offsetX + i * dayWidth + (dayWidth - textWidth) / 2;
            

            g.drawString(daysOfWeek[i], x, offsetY + headerHeight / 2);
        }

        Calendar calendar = new GregorianCalendar(year, month - 1, 1);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        int dayCounter = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < 7; col++) {
                if (row == 0 && col < firstDayOfWeek) {
                    continue;
                }
                if (dayCounter > daysInMonth) {
                    return;
                }

                int x = offsetX + col * dayWidth;
                int y = offsetY + row * dayHeight + headerHeight; // Se toma en cuenta el alto de los titulos

                int diameter = Math.min(dayWidth, dayHeight) - 10; // Menos 10 para que no este empalmado feo
                int circleX = x + (dayWidth - diameter) / 2;
                int circleY = y + (dayHeight - diameter) / 2;

                Rectangle rect = new Rectangle(x, y, dayWidth, dayHeight); // Los rectangulos se crean solo para los clicks
                LocalDate currentDate = LocalDate.of(year, month, dayCounter); // Dia que se esta dibujando actualmente

                Color colorFondo = null;
                Integer habitacion = null;

                if (currentDate.isBefore(LocalDate.now())) {
                    colorFondo = new Color(1, 80, 180);
                }

                if (fechaInicio != null && fechaFin == null) { // Pintar el primer click
                    if (currentDate.equals(fechaInicio)) {
                        colorFondo = new Color(255, 204, 0);
                    }
                }

                for (Reservacion r : reservaciones) { // Pintar las reservaciones
                    if (!currentDate.isBefore(r.getF_entrada()) && !currentDate.isAfter(r.getF_salida())) {
                        habitacion = r.getId_habitacion();
                        colorFondo = colorHabitaciones.get(habitacion);
                        break;
                    }
                }

                if (fechaInicio != null && fechaFin != null && !fechaFin.isBefore(fechaInicio)) { // Pintar el periodo seleccionado
                    if (!currentDate.isBefore(fechaInicio) && !currentDate.isAfter(fechaFin)) {
                        colorFondo = new Color(255, 204, 0);
                        habitacion = null;
                    }
                }

                if (colorFondo != null) { // Pintar dias sin informacion
                    g.setColor(colorFondo);
                    g.fillOval(circleX, circleY, diameter, diameter);
                    g.setColor(Color.WHITE); // COlor de la fuente
                } else {
                    g.setColor(new Color(255, 204, 0));
                    g.drawOval(circleX, circleY, diameter, diameter);
                }

                FontMetrics fm = g.getFontMetrics();
                String diaStr = String.valueOf(dayCounter);
                int textWidth = fm.stringWidth(diaStr);
                int textX = circleX + (diameter - textWidth) / 2;
                int textY = circleY + (diameter + fm.getAscent()) / 2 - 4;

                g.drawString(diaStr, textX, textY); // Pintar con el color establecido antes (En los if)

                if (habitacion != null) {
                    String habStr = "Hab #" + habitacion;
                    int habWidth = fm.stringWidth(habStr);
                    g.drawString(habStr, x + (dayWidth - habWidth) / 2, y + dayHeight - 5);
                }

                celdas.add(new RectCelda(dayCounter, rect));
                dayCounter++;
            }
        }
    }

    private static class RectCelda {

        int dia;
        Rectangle area;

        RectCelda(int dia, Rectangle area) {
            this.dia = dia;
            this.area = area;
        }
    }
}
