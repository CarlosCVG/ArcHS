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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class PanelCarrusel extends JPanel implements ActionListener, Observable {

    private int indiceActual = 0;
    private int proximoIndice = 0;
    private float alpha = 0.0f;

    private Timer autoScrollTimer;
    private final Timer timer;

    private int autoScrollInterval = 4000;
    private Color btnColor = Color.WHITE;

    private final JButton btnIzquierda, btnDerecha;
    private final JPanel contenedorPanel;
    private final JPanel veloBlanco;
    private boolean desvaneciendoIn = true;
    private final JLayeredPane layeredPane;
    private final List<Observer> observers = new ArrayList<>();
    private final int ancho;
    private final int alto;
    private int btnWidth = 50;
    private List<JPanel> panelList;

    private Color btnColorForMouseEntered = new Color(254, 220, 221);
    private Color btnColorForMouseExit = Color.WHITE;
    private Color btnColorForMousePressed = new Color(254, 220, 221);
    private Color btnColorForMouseReleased = new Color(254, 220, 221);

    public PanelCarrusel() {
        this(800, 650);
    }

    public PanelCarrusel(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        setLayout(null);
        setPreferredSize(new Dimension(ancho, alto));

        btnIzquierda = crearBotonPersonalizado("<");
        btnDerecha = crearBotonPersonalizado(">");

        btnIzquierda.setBounds(0, 0, btnWidth, alto);
        btnDerecha.setBounds(ancho - btnWidth, 0, btnWidth, alto);
        add(btnIzquierda);
        add(btnDerecha);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(btnWidth, 0, ancho - 2 * btnWidth, alto);
        add(layeredPane);

        contenedorPanel = new JPanel(null);
        contenedorPanel.setOpaque(false);
        contenedorPanel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
        layeredPane.add(contenedorPanel, JLayeredPane.DEFAULT_LAYER);
        setContenedorPanel();

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
        veloBlanco.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
        veloBlanco.setVisible(false);
        layeredPane.add(veloBlanco, JLayeredPane.PALETTE_LAYER);

        panelList = new ArrayList<>();
        btnIzquierda.addActionListener(this);
        btnDerecha.addActionListener(this);

        timer = new Timer(40, e -> animarVelo());

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int w = getWidth();
                int h = getHeight();

                btnIzquierda.setBounds(0, 0, btnWidth, h);
                btnDerecha.setBounds(w - btnWidth, 0, btnWidth, h);

                layeredPane.setBounds(btnWidth, 0, w - 2 * btnWidth, h);
                contenedorPanel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
                veloBlanco.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());

                for (JPanel panel : panelList) {
                    panel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
                }
                if (!panelList.isEmpty()) {
                    mostrarPanel(indiceActual);
                }
            }
        });
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public JPanel getCurrentPanel() {
        return panelList.get(indiceActual);
    }

    public void eliminarPanel(JPanel panel) {
        panelList.remove(panel);
        if (indiceActual >= panelList.size()) {
            indiceActual = Math.max(0, panelList.size() - 1);
        }
        if (!panelList.isEmpty()) {
            mostrarPanel(indiceActual);
        } else {
            contenedorPanel.removeAll();
            contenedorPanel.revalidate();
            contenedorPanel.repaint();
        }
        notifyObservers();
    }

    public void agregarPanel(JPanel panel) {
        panel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
        panelList.add(panel);
        if (panelList.size() == 1) {
            mostrarPanel(0);
        }
    }

    public void removePanels() {
        panelList.clear();
    }

    private void mostrarPanel(int indice) {
        contenedorPanel.removeAll();
        JPanel panel = panelList.get(indice);
        contenedorPanel.add(panel);
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
                mostrarPanel(proximoIndice);
            }
        } else {
            alpha -= 0.1f;
            if (alpha <= 0.0f) {
                alpha = 0.0f;
                timer.stop();
                veloBlanco.setVisible(false);
            }
        }
        veloBlanco.repaint();
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
            iniciarTransicion(indiceActual);
        }
    }

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

    public Color getBtnColorForMouseReleased() {
        return btnColorForMouseReleased;
    }

    public void setBtnColorForMouseReleased(Color c) {
        this.btnColorForMouseReleased = c;
        refrescarEstilosBotones();
    }

    public Color getBtnColorForMousePressed() {
        return btnColorForMousePressed;
    }

    public void setBtnColorForMousePressed(Color c) {
        this.btnColorForMousePressed = c;
        refrescarEstilosBotones();
    }

    public Color getBtnColorForMouseExit() {
        return btnColorForMouseExit;
    }

    public void setBtnColorForMouseExit(Color c) {
        this.btnColorForMouseExit = c;
        refrescarEstilosBotones();
    }

    public Color getBtnColorForMouseEntered() {
        return btnColorForMouseEntered;
    }

    public void setBtnColorForMouseEntered(Color c) {
        this.btnColorForMouseEntered = c;
        refrescarEstilosBotones();
    }

    public int getAutoScrollInterval() {
        return autoScrollInterval;
    }

    public void setAutoScrollInterval(int interval) {
        this.autoScrollInterval = interval;
    }

    public List<JPanel> getPanelList() {
        return panelList;
    }

    public void setPanelList(List<JPanel> list) {
        this.panelList = list;
        for (JPanel panel : panelList) {
            panel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
        }
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

    public int getIndiceActual() {
        return indiceActual;
    }

    private void setContenedorPanel() {
        contenedorPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                detenerAutoScroll();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                iniciarAutoScroll(4000);
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
                iniciarTransicion(indiceActual);
            }
        });

        autoScrollTimer.start();
    }

    public void detenerAutoScroll() {
        if (autoScrollTimer != null) {
            autoScrollTimer.stop();
        }
    }

    private void refrescarEstilosBotones() {
        configurarEstiloBoton(btnIzquierda);
        configurarEstiloBoton(btnDerecha);
    }

}
