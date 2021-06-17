package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelIzq = new JPanel();
		contentPane.add(panelIzq, BorderLayout.WEST);
		panelIzq.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panelIzq.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("GENERAR FACTURA");
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		panelIzq.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JPanel grilla = new JPanel();
		panelCentral.add(grilla, BorderLayout.CENTER);
		grilla.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		grilla.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ASOCIADOS");
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		grilla.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(6, 2, 0, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_4.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("DNI");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_4.add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefono");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_4.add(textField_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Domicilio");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_4.add(textField_4);
		
		JButton btnNewButton_1 = new JButton("AGREGAR");
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("ELIMINAR");
		panel_4.add(btnNewButton_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JPanel panelDer = new JPanel();
		contentPane.add(panelDer, BorderLayout.EAST);
		panelDer.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelDer.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSerializar = new JButton("Serializar");
		panel.add(btnSerializar);
		
		JButton btnNewButton_2 = new JButton("Cargar");
		panel.add(btnNewButton_2);
	}

}
