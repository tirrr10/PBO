package Sesi12;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApkBiodata extends JFrame {

    // Komponen Input
    private JTextField txtNim, txtNama, txtProdi;
    private JButton btnTampilkan, btnReset;

    // Komponen Output
    private JTextArea txtAreaOutput;

    public ApkBiodata() {
        // 1. Pengaturan Frame Utama
        setTitle("Aplikasi Biodata Mahasiswa");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ================= PANELS & COMPONENTS =================

        // --- Panel Input Data ---
        JPanel panelInput = new JPanel();
        panelInput.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Input Data", TitledBorder.LEFT, TitledBorder.TOP));
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        // Label & TextField NIM
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        panelInput.add(new JLabel("NIM"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.8;
        txtNim = new JTextField();
        panelInput.add(txtNim, gbc);

        // Label & TextField Nama
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.2;
        panelInput.add(new JLabel("Nama"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.8;
        txtNama = new JTextField();
        panelInput.add(txtNama, gbc);

        // Label & TextField Program Studi
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.2;
        panelInput.add(new JLabel("Program Studi"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.8;
        txtProdi = new JTextField();
        panelInput.add(txtProdi, gbc);

        // --- Panel Tombol ---
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btnTampilkan = new JButton("Tampilkan");
        btnReset = new JButton("Reset");
        panelTombol.add(btnTampilkan);
        panelTombol.add(btnReset);

        // Gabungkan Input dan Tombol ke bagian atas (North)
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelInput, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        // --- Panel Output ---
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Output", TitledBorder.LEFT, TitledBorder.TOP));

        txtAreaOutput = new JTextArea();
        txtAreaOutput.setEditable(false);
        txtAreaOutput.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Agar format spasi rapi/sejajar
        JScrollPane scrollPane = new JScrollPane(txtAreaOutput);
        panelOutput.add(scrollPane, BorderLayout.CENTER);

        // Tambahkan semua sub-panel ke Frame utama
        add(panelAtas, BorderLayout.NORTH);
        add(panelOutput, BorderLayout.CENTER);

        // ================= EVENT HANDLING =================

        // 2. Logika ketika klik tombol Tampilkan
        btnTampilkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = txtNim.getText();
                String nama = txtNama.getText();
                String prodi = txtProdi.getText();

                String hasil = "========== BIODATA MAHASISWA ==========\n\n"
                        + "NIM            : " + nim + "\n"
                        + "Nama           : " + nama + "\n"
                        + "Program Studi  : " + prodi;

                txtAreaOutput.setText(hasil);
            }
        });

        // 3. Logika ketika klik tombol Reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Bersihkan input field
                txtNim.setText("");
                txtNama.setText("");
                txtProdi.setText("");
                // Bersihkan area output
                txtAreaOutput.setText("");
            }
        });
    }

    public static void main(String[] args) {
        // Menyesuaikan tampilan agar mengikuti sistem OS (opsional)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        // Jalankan program
        SwingUtilities.invokeLater(() -> {
            new ApkBiodata().setVisible(true);
        });
    }
}