package componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class PanelCarrusel extends JPanel implements ActionListener, Observable {

    /*
    Clase que implementa un carrusel de paneles con animaciones y transiciones automáticas.
    El intervalo de transición automática se puede configurar con el método setAutoScrollInterval.
    El carrusel permite agregar paneles mediante setPanelList o agregarPanel, y realizar animaciones de transición entre los paneles.
    Además, se utiliza el patrón Observable para notificar cambios a los observadores del componente que contiene al carrusel.
    */

    /*
    Se pueden modificar algunas de las propiedades en las propiedades del componente 
    al añadir el componente a la paleta de componentes de Swing.
    */
    
    private int indiceActual = 0;  // Indice del panel actual
    private int proximoIndice = 0;  // Indice del siguiente panel
    private float alpha = 0.0f;  // Opacidad para la transición de desvanecimiento

    private Timer autoScrollTimer;  // Timer para el cambio automático de paneles
    private final Timer timer;  // Timer para la animación del desvanecimiento

    private int autoScrollInterval = 4000;  // Intervalo de tiempo para el cambio automático de panel
    private Color btnColor = Color.WHITE;  // Color de los botones

    private final JButton btnIzquierda, btnDerecha;  // Botones para navegar entre los paneles
    private final JPanel contenedorPanel;  // Panel que contiene el panel actual
    private final JPanel veloBlanco;  // Panel para el efecto de desvanecimiento
    private boolean desvaneciendoIn = true;  // Indicador de si la transición está ocurriendo
    private final JLayeredPane layeredPane;  // Panel que permite apilar componentes
    private final List<Observer> observers = new ArrayList<>();  // Lista de observadores
    private final int ancho;  // Ancho del carrusel
    private final int alto;  // Alto del carrusel
    private int btnWidth = 50;  // Ancho de los botones
    private List<JPanel> panelList;  // Lista de paneles en el carrusel

    // Colores configurables para eventos del mouse en los botones
    private Color btnColorForMouseEntered = Color.BLACK;
    private Color btnColorForMouseExit = Color.WHITE;
    private Color btnColorForMousePressed = Color.GRAY;
    private Color btnColorForMouseReleased = Color.BLACK;

    // === CONSTRUCTOR PREDETERMINADO ===
    public PanelCarrusel() {
        this(700, 650);
    }

    // === CONSTRUCTOR CON TAMAÑO PERSONALIZADO ===
    public PanelCarrusel(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        setLayout(new BorderLayout());

        btnIzquierda = crearBotonPersonalizado("<");
        btnDerecha = crearBotonPersonalizado(">");

        btnIzquierda.setPreferredSize(new Dimension(btnWidth, alto));
        btnDerecha.setPreferredSize(new Dimension(btnWidth, alto));
        add(btnIzquierda, BorderLayout.WEST);
        add(btnDerecha, BorderLayout.EAST);

        layeredPane = new JLayeredPane();
        add(layeredPane, BorderLayout.CENTER);

        contenedorPanel = new JPanel(new BorderLayout());
        contenedorPanel.setOpaque(false);
        contenedorPanel.setBounds(0, 0, ancho, alto);
        setContenedorPanel();
        layeredPane.add(contenedorPanel, JLayeredPane.DEFAULT_LAYER);

        veloBlanco = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                g2.setColor(Color.WHITE);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();
            }
        };
        veloBlanco.setOpaque(false);
        veloBlanco.setLayout(null);
        veloBlanco.setBounds(0, 0, ancho, alto);
        veloBlanco.setVisible(false);
        layeredPane.add(veloBlanco, JLayeredPane.PALETTE_LAYER);

        panelList = new ArrayList<>();
        btnIzquierda.addActionListener(this);
        btnDerecha.addActionListener(this);

        timer = new Timer(40, e -> animarVelo());
    }

    // === METODOS OBSERVABLE ===
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);  // Agrega un nuevo observador
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);  // Elimina un observador
    }

    @Override
    public void notifyObservers() {
        // Notifica a todos los observadores sobre un cambio
        for (Observer o : observers) {
            o.update();  // Llama al método update de cada observador
        }
    }

    // === MANEJO DE PANELES ===
    public JPanel getCurrentPanel() {
        return panelList.get(indiceActual);  // Devuelve el panel actual
    }

    public void eliminarPanel(JPanel panel) {
        panelList.remove(panel);  // Elimina un panel del carrusel
        if (indiceActual >= panelList.size()) {
            indiceActual = Math.max(0, panelList.size() - 1);  // Ajusta el índice si el panel actual fue eliminado
        }
        if (!panelList.isEmpty()) {
            mostrarPanel(indiceActual);
        } else {
            contenedorPanel.removeAll();
            contenedorPanel.revalidate();
            contenedorPanel.repaint();
        }
        notifyObservers();  // Notifica a los observadores
    }

    public void agregarPanel(JPanel panel) {
        panel.setPreferredSize(new Dimension(ancho, alto));
        panelList.add(panel);  // Agrega un nuevo panel al carrusel
        if (panelList.size() == 1) {
            mostrarPanel(0);  // Muestra el primer panel si es el único
        }
    }

    public void removePanels() {
        panelList.clear();  // Elimina todos los paneles
    }

    private void mostrarPanel(int indice) {
        contenedorPanel.removeAll();
        JPanel panel = panelList.get(indice);
        panel.setPreferredSize(new Dimension(ancho, alto));
        contenedorPanel.add(panel, BorderLayout.CENTER);
        contenedorPanel.revalidate();
        contenedorPanel.repaint();
    }

    private void iniciarTransicion(int nuevoIndice) {
        if (nuevoIndice < 0 || nuevoIndice >= panelList.size()) {
            return;
        }

        proximoIndice = nuevoIndice;
        alpha = 0.0f;
        desvaneciendoIn = true;
        veloBlanco.setVisible(true);
        timer.start();
    }

    private void animarVelo() {
        if (desvaneciendoIn) {
            alpha += 0.1f;
            if (alpha >= 1.0f) {
                alpha = 1.0f;
                desvaneciendoIn = false;
                mostrarPanel(proximoIndice);  // Muestra el siguiente panel
            }
        } else {
            alpha -= 0.1f;
            if (alpha <= 0.0f) {
                alpha = 0.0f;
                timer.stop();
                veloBlanco.setVisible(false);
            }
        }
        veloBlanco.repaint();  // Refresca la animación del velo
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int nuevoIndice = indiceActual;

        if (e.getSource() == btnIzquierda) {
            nuevoIndice = (indiceActual == 0) ? panelList.size() - 1 : indiceActual - 1;
        } else if (e.getSource() == btnDerecha) {
            nuevoIndice = (indiceActual == panelList.size() - 1) ? 0 : indiceActual + 1;
        }

        if (nuevoIndice != indiceActual) {
            indiceActual = nuevoIndice;
            iniciarTransicion(indiceActual);  // Inicia la transición
        }
    }

    // === CREAR BOTON PERSONALIZADO CON COLORES CONFIGURABLES ===
    private JButton crearBotonPersonalizado(String texto) {
        JButton boton = new JButton(texto);
        configurarEstiloBoton(boton);
        return boton;
    }

    private void configurarEstiloBoton(JButton boton) {
        boton.setBackground(btnColor);
        boton.setFont(new Font("Arial", Font.BOLD, 20));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(true);
        boton.setOpaque(true);

        // Remover listeners anteriores
        for (MouseListener listener : boton.getMouseListeners()) {
            if (listener instanceof MouseAdapter) {
                boton.removeMouseListener(listener);
            }
        }

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(btnColorForMouseEntered);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(btnColorForMouseExit);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                boton.setBackground(btnColorForMousePressed);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                boton.setBackground(btnColorForMouseReleased);
            }
        });
    }

    // === GETTERS Y SETTERS DE NUEVOS ATRIBUTOS ===
    public Color getBtnColorForMouseReleased() {
        return btnColorForMouseReleased;
    }

    public void setBtnColorForMouseReleased(Color btnColorForMouseReleased) {
        this.btnColorForMouseReleased = btnColorForMouseReleased;
        refrescarEstilosBotones();
    }

    public Color getBtnColorForMousePressed() {
        return btnColorForMousePressed;
    }

    public void setBtnColorForMousePressed(Color btnColorForMousePressed) {
        this.btnColorForMousePressed = btnColorForMousePressed;
        refrescarEstilosBotones();
    }

    public Color getBtnColorForMouseExit() {
        return btnColorForMouseExit;
    }

    public void setBtnColorForMouseExit(Color btnColorForMouseExit) {
        this.btnColorForMouseExit = btnColorForMouseExit;
        refrescarEstilosBotones();
    }

    public Color getBtnColorForMouseEntered() {
        return btnColorForMouseEntered;
    }

    public void setBtnColorForMouseEntered(Color btnColorForMouseEntered) {
        this.btnColorForMouseEntered = btnColorForMouseEntered;
        refrescarEstilosBotones();
    }

    public int getAutoScrollInterval() {
        return autoScrollInterval;
    }

    public void setAutoScrollInterval(int autoScrollInterval) {
        this.autoScrollInterval = autoScrollInterval;
    }

    public List<JPanel> getPanelList() {
        return panelList;
    }

    public void setPanelList(List<JPanel> panelList) {
        this.panelList = panelList;
        mostrarPanel(0);
    }

    public int getBtnWidth() {
        return btnWidth;
    }

    public void setBtnWidth(int btnWidth) {
        this.btnWidth = btnWidth;
    }

    public Color getBtnColor() {
        return btnColor;
    }

    public void setBtnColor(Color btnColor) {
        this.btnColor = btnColor;
        refrescarEstilosBotones();
    }

    private void setContenedorPanel() {
        contenedorPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                detenerAutoScroll();  // Detiene el autoscroll cuando el mouse entra en el panel
            }

            @Override
            public void mouseExited(MouseEvent e) {
                iniciarAutoScroll(4000);  // Reinicia el autoscroll cuando el mouse sale del panel
            }
        });
    }

    public void iniciarAutoScroll(int delayMilisegundos) {
        if (autoScrollTimer != null && autoScrollTimer.isRunning()) {
            autoScrollTimer.stop();
        }

        autoScrollTimer = new Timer(delayMilisegundos, e -> {
            int nuevoIndice = (indiceActual == panelList.size() - 1) ? 0 : indiceActual + 1;

            if (nuevoIndice != indiceActual) {
                indiceActual = nuevoIndice;
                iniciarTransicion(indiceActual);  // Inicia la transición automática
            }
        });

        autoScrollTimer.start();
    }

    public void detenerAutoScroll() {
        if (autoScrollTimer != null) {
            autoScrollTimer.stop();  // Detiene el autoscroll
        }
    }

    private void refrescarEstilosBotones() {
        configurarEstiloBoton(btnIzquierda);
        configurarEstiloBoton(btnDerecha);
    }
}
