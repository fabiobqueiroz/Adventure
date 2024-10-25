import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel;
    JLabel titleNameLabel;
    Font titleNameFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton;
    JTextArea mainTextArea;

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        // Window
        window = new JFrame();
        window.setSize(800, 600); // tamanho da janela
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // função para fechar janela
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null); // tiro o layout básico do Java
        window.setVisible(true); // para ver a janela
        con = window.getContentPane();

        // Título
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Adventure");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleNameFont);

        // Botão Start
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.BLACK);

        startButton = new JButton("Start");
        startButton.setForeground(Color.white);
        startButton.setBackground(Color.black);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false); // remove o foco visual no botão
        startButton.addActionListener(tsHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }

    public void createGameScreen() {
        // Remove ou oculta os elementos da tela inicial
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        // Painel principal de texto do jogo
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250); // ajusta as coordenadas
        mainTextPanel.setBackground(Color.blue);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.blue);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);

        mainTextPanel.add(mainTextArea);
        con.add(mainTextPanel);
        
        // Atualiza a interface para refletir as mudanças
        window.revalidate();
        window.repaint();
    }

    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }
}