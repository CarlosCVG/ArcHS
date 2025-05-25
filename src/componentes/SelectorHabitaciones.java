package componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import modelo.vo.Habitacion;

public class SelectorHabitaciones extends JPanel {

    private static final String IMAGE_FOLDER_PATH = "src/vista/images/habitacionIMG/";
    private static final String IMAGE_PREFIX = "habitacion";

    private List<Habitacion> habitaciones;
    private List<RectCelda> celdas = new ArrayList<>();
    private List<Habitacion> habitacionesSeleccionadas = new ArrayList<>();
    private Map<Integer, Color> colorHabitaciones = new HashMap<>();
    private Map<Integer, ImageIcon> imagenesHabitaciones = new HashMap<>();

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
        this.habitacionesSeleccionadas.clear();
        this.celdas.clear();
        this.colorHabitaciones.clear();
        this.imagenesHabitaciones.clear();
        generarColoresHabitaciones();
        cargarImagenes();
        repaint();
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public List<Habitacion> getHabitacionesSeleccionadas() {
        return habitacionesSeleccionadas;
    }

    private void configurarMouseListener() {
        this.addMouseListener(new MouseAdapter() {
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

        int imageSize = 100; // Ajusta al tamaño deseado

        for (Habitacion h : habitaciones) {
            int id = h.getId_habitacion();
            int index = getRandomInt(0, imageCount - 1);
            String imagePath = IMAGE_FOLDER_PATH + IMAGE_PREFIX + index + ".jpg";
            File file = new File(imagePath);
            if (file.exists()) {
                ImageIcon original = new ImageIcon(imagePath);
                Image scaled = original.getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
                imagenesHabitaciones.put(id, new ImageIcon(scaled));
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

        // Usamos Graphics2D para mejor control
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Monospace", Font.BOLD, fontSize));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int roomCounter = 0;
        for (int row = 0; row < rows && roomCounter < habitaciones.size(); row++) {
            for (int col = 0; col < cols && roomCounter < habitaciones.size(); col++) {
                if (row > 0) {
                    if (cols % 2 == 0) {
                        // Par: saltar las dos columnas del centro
                        int midLeft = (cols / 2) - 1;
                        int midRight = cols / 2;
                        if (col == midLeft || col == midRight) {
                            continue; // No dibujar ni contar habitación en estas posiciones
                        }
                    } else {
                        // Impar: saltar la columna del centro
                        int mid = cols / 2;
                        if (col == mid) {
                            continue; // No dibujar ni contar habitación en esta posición
                        }
                    }
                }
                
                Habitacion habitacion = habitaciones.get(roomCounter);

                int x = offsetX + col * roomWidth;
                int y = offsetY + row * roomHeight;
                int diameter = Math.min(roomWidth, roomHeight) - 10;
                int circleX = x + (roomWidth - diameter) / 2;
                int circleY = y + (roomHeight - diameter) / 2;

                Rectangle rect = new Rectangle(circleX, circleY, diameter, diameter);
                celdas.add(new RectCelda(habitacion, rect));

                // Fondo color según selección
                if (habitacionesSeleccionadas.contains(habitacion)) {
                    g2.setColor(Color.YELLOW); // Amarillo para selección
                } else {
                    g2.setColor(Color.GRAY);
                }
                g2.fillOval(circleX, circleY, diameter, diameter);

                // Imagen (más pequeña para que no sobresalga)
                ImageIcon icon = imagenesHabitaciones.get(habitacion.getId_habitacion());
                if (icon != null) {
                    int padding = diameter / 10;
                    int imgSize = diameter - 2 * padding;
                    g2.drawImage(icon.getImage(), circleX + padding, circleY + padding, imgSize, imgSize, this);
                }

                // Borde negro
                g2.setColor(Color.BLACK);
                g2.drawOval(circleX, circleY, diameter, diameter);

                // Texto con contorno para mayor visibilidad
                String label = "Hab " + habitacion.getId_habitacion();
                FontMetrics fm = g2.getFontMetrics();
                int textWidth = fm.stringWidth(label);
                int textX = circleX + (diameter - textWidth) / 2;
                int textY = circleY + diameter - 5;

                // Dibujo contorno negro
                g2.setColor(Color.BLACK);
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (dx != 0 || dy != 0) {
                            g2.drawString(label, textX + dx, textY + dy);
                        }
                    }
                }

                // Dibujo texto blanco encima
                g2.setColor(Color.WHITE);
                g2.drawString(label, textX, textY);

                roomCounter++;
            }
        }
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
