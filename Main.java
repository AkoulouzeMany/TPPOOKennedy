import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
    private final VolDAO dao;
    private JTextField serialField;
    private JLabel resultLabel;

    public Main() {
        this.dao = new VolDAO();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Système de vérification d’objets volés");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 320);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Titre
        JLabel title = new JLabel("Contrôle de Numéro de Série");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Verdana", Font.BOLD, 20));
        title.setForeground(new Color(0x2E86C1));
        mainPanel.add(title);
        mainPanel.add(Box.createVerticalStrut(20));

        // Champ de recherche
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        serialField = new JTextField(20);
        JButton searchButton = new JButton("Rechercher");
        searchButton.addActionListener(this::handleSearch);
        inputPanel.add(new JLabel("Numéro de série :"));
        inputPanel.add(serialField);
        inputPanel.add(searchButton);
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(20));

        // Résultats
        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(new Color(0xF2F3F4));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Résultat"));
        resultLabel = new JLabel("Aucun résultat pour l'instant.");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        resultPanel.add(resultLabel);
        mainPanel.add(resultPanel);
        mainPanel.add(Box.createVerticalStrut(20));

        // Bouton Admin
        JButton adminButton = new JButton("Mode Admin");
        adminButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminButton.setBackground(new Color(0xAED6F1));
        adminButton.addActionListener(e -> {
            try {
                new Admin(dao).setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erreur : " + ex.getMessage(),
                        "Erreur Admin",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        mainPanel.add(adminButton);

        add(mainPanel);
    }

    private void handleSearch(ActionEvent e) {
        String serial = serialField.getText().trim();
        if (serial.isEmpty()) {
            resultLabel.setText("Veuillez entrer un numéro de série.");
            return;
        }

        try {
            Vol item = dao.searchByNumeroserie(serial);
            if (item != null) {
                resultLabel.setText("<html><span style='color:red;'>Objet volé trouvé !</span><br>Contact : " + item.getContactPerso() + "</html>");
            } else {
                resultLabel.setText("Aucune correspondance trouvée.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Erreur base de données : " + ex.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}