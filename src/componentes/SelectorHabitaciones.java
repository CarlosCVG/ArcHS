/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.util.Observer;
import modelo.vo.Habitacion;
import modelo.vo.Reservacion;
import repositorio.RepHabitaciones;
import vista.paneles.PanHabitacion;

/**
 *
 * @author edwin
 */
public class SelectorHabitaciones extends JPanel {

    private static final String IMAGE_FOLDER_PATH = "src/vista/images/habitacionIMG/";
    private static final String IMAGE_PREFIX = "habitacion";

    private List<Habitacion> habitaciones;
    private List<RectCelda> celdas = new ArrayList<>();
    private List<Habitacion> habitacionesSeleccionadas = new ArrayList<>();
    private Map<Integer, Color> colorHabitaciones = new HashMap<>();
    private Map<Integer, Image> imagenesHabitaciones = new HashMap<>();

    private int fontSize = 21;

    public SelectorHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
        this.setBackground(new Color(45, 52, 54));
        generarColoresHabitaciones();
        cargarImagenes();
        configurarMouseListener();
    }

    public SelectorHabitaciones() {
        this.habitaciones = new ArrayList<>();
        for (int i = 1; i < 25; i++) {
            Habitacion h = new Habitacion();
            h.setId_habitacion(i);
            habitaciones.add(h);
        }
        this.setBackground(new Color(45, 52, 54));
        generarColoresHabitaciones();
        cargarImagenes();
        configurarMouseListener();
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
        this.setBackground(new Color(45, 52, 54));
        generarColoresHabitaciones();
        cargarImagenes();
        configurarMouseListener();
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    
    public List<Habitacion> getHabitacionesSeleccionadas(){
        return habitacionesSeleccionadas;
    }
    
    private void configurarMouseListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Habitacion habitacionSeleccionada = getSelectedRoom(e);
                if (habitacionSeleccionada != null) {
                    if (habitacionesSeleccionadas.contains(habitacionSeleccionada)) {
                        habitacionesSeleccionadas.remove(habitacionSeleccionada);
                    } else {
                        habitacionesSeleccionadas.add(habitacionSeleccionada);
                    }
                    repaint();
                }
            }
        });
    }

    private void generarColoresHabitaciones() {
        Random rnd = new Random();
        colorHabitaciones.clear();
        for (Habitacion h : habitaciones) {
            colorHabitaciones.put(h.getId_habitacion(), new Color(1, rnd.nextInt(100), rnd.nextInt(200)));
        }
    }

    private void cargarImagenes() {
        int imageCount = countFilesInFolder(IMAGE_FOLDER_PATH);
        if (imageCount == 0) {
            return;
        }

        for (Habitacion h : habitaciones) {
            int id = h.getId_habitacion();
            int index = getRandomInt(0, imageCount - 1);
            String imagePath = IMAGE_FOLDER_PATH + IMAGE_PREFIX + index + ".jpg";
            File file = new File(imagePath);
            if (file.exists()) {
                ImageIcon icon = new ImageIcon(imagePath);
                imagenesHabitaciones.put(id, icon.getImage());
            }
        }
    }

    private Habitacion getSelectedRoom(MouseEvent e) {
        for (RectCelda celda : celdas) {
            if (celda.area.contains(e.getPoint())) {
                return celda.room;
            }
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawHabitaciones(g);
    }

    private void drawHabitaciones(Graphics g) {
        celdas.clear();

        int panelWidth = this.getWidth() - this.getWidth() / 6;
        int panelHeight = this.getHeight() - this.getHeight() / 8;
        int cols = 7;
        int rows = (int) Math.ceil(habitaciones.size() / (double) cols);
        int roomWidth = panelWidth / cols;
        int roomHeight = panelHeight / rows;

        int offsetX = (this.getWidth() - panelWidth) / 2;
        int offsetY = (this.getHeight() - panelHeight) / 2;

        g.setFont(new Font("Monospace", Font.PLAIN, fontSize));

        int roomCounter = 0;
        for (int row = 0; row < rows && roomCounter < habitaciones.size(); row++) {
            for (int col = 0; col < cols && roomCounter < habitaciones.size(); col++) {
                Habitacion habitacion = habitaciones.get(roomCounter);

                int x = offsetX + col * roomWidth;
                int y = offsetY + row * roomHeight;
                int diameter = Math.min(roomWidth, roomHeight) - 10;
                int circleX = x + (roomWidth - diameter) / 2;
                int circleY = y + (roomHeight - diameter) / 2;

                Rectangle rect = new Rectangle(circleX, circleY, diameter, diameter);
                celdas.add(new RectCelda(habitacion, rect));

                // Fondo color según selección
                g.setColor(habitacionesSeleccionadas.contains(habitacion) ? colorHabitaciones.get(habitacion.getId_habitacion()) : Color.GRAY);
                g.fillOval(circleX, circleY, diameter, diameter);

                // Imagen
                Image img = imagenesHabitaciones.get(habitacion.getId_habitacion());
                if (img != null) {
                    g.drawImage(img.getScaledInstance(diameter, diameter, Image.SCALE_SMOOTH), circleX, circleY, null);
                }

                // Borde
                g.setColor(Color.BLACK);
                g.drawOval(circleX, circleY, diameter, diameter);

                // Texto
                String label = "Hab " + habitacion.getId_habitacion();
                FontMetrics fm = g.getFontMetrics();
                int textWidth = fm.stringWidth(label);
                int textX = circleX + (diameter - textWidth) / 2;
                int textY = circleY + diameter - 5;
                g.setColor(Color.WHITE);
                g.drawString(label, textX, textY);

                roomCounter++;
            }
        }
    }

    public List<Habitacion> getHabitacionesSeleccionadas() {
        return habitacionesSeleccionadas;
    }

    private int getRandomInt(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    private int countFilesInFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));
        return files != null ? files.length : 0;
    }

    private static class RectCelda {

        Habitacion room;
        Rectangle area;

        RectCelda(Habitacion room, Rectangle area) {
            this.room = room;
            this.area = area;
        }
    }
}
