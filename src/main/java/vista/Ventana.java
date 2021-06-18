package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import paciente.Paciente;

import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDNI;
	private JTextField tfTelefono;
	private JTextField tfDomicilio;
	JButton btnFactura = new JButton("GENERAR FACTURA");
	JButton btnAgregar = new JButton("AGREGAR");
	JButton btnEliminar = new JButton("ELIMINAR");

	JScrollPane scrollPane = new JScrollPane();
	JList listAtencion;

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 637);
		setTitle("Clinica");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelIzq = new JPanel();
		panelIzq.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panelIzq, BorderLayout.WEST);
		panelIzq.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(0, 250, 154));
		panelIzq.add(panel_1, BorderLayout.SOUTH);
		
		
		btnFactura.setActionCommand("GENERARFACTURA");
		btnFactura.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_1.add(btnFactura);
		
		scrollPane = new JScrollPane();
		panelIzq.add(scrollPane, BorderLayout.CENTER);
		
		listAtencion = new JList();
		listAtencion.setBorder(new LineBorder(new Color(0, 0, 0)));
		listAtencion.setBackground(UIManager.getColor("Button.light"));
		listAtencion.setFont(new Font("Verdana", Font.PLAIN, 14));
		scrollPane.setViewportView(listAtencion);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(new Color(0, 250, 154));
		panelIzq.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblPacientesEnAtencion = new JLabel("PACIENTES EN ATENCION");
		lblPacientesEnAtencion.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_5.add(lblPacientesEnAtencion);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JPanel grilla = new JPanel();
		panelCentral.add(grilla, BorderLayout.CENTER);
		grilla.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		grilla.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ASOCIADOS");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		grilla.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(6, 2, 0, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel_4.add(panel);
		
		tfNombre = new JTextField();
		panel.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1_1);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		
		tfApellido = new JTextField();
		panel_7.add(tfApellido);
		tfApellido.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("DNI");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1_2);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		
		tfDNI = new JTextField();
		panel_8.add(tfDNI);
		tfDNI.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefono");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1_3);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		
		tfTelefono = new JTextField();
		panel_9.add(tfTelefono);
		tfTelefono.setColumns(10);
		
		JLabel lblNewLabel_1_4 = new JLabel("Domicilio");
		lblNewLabel_1_4.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1_4);
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);
		
		tfDomicilio = new JTextField();
		panel_10.add(tfDomicilio);
		tfDomicilio.setColumns(10);
		
		
		btnAgregar.setBackground(new Color(0, 128, 0));
		btnAgregar.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_4.add(btnAgregar);
		
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_4.add(btnEliminar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JPanel panelDer = new JPanel();
		panelDer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panelDer, BorderLayout.EAST);
		panelDer.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 127, 80));
		panelDer.add(panel_6, BorderLayout.NORTH);
		
		JLabel lblAmbulancia = new JLabel("AMBULANCIA");
		lblAmbulancia.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_6.add(lblAmbulancia);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panelDer.add(scrollPane_2, BorderLayout.CENTER);
		
		JList list_2 = new JList();
		scrollPane_2.setViewportView(list_2);
	}
	
	public void setListenerBotones(ActionListener controlador) {
		btnAgregar.addActionListener(controlador);
		btnEliminar.addActionListener(controlador);
		btnFactura.addActionListener(controlador);
	}
	
	public void actualizarPacientesAtencion(ArrayList<Paciente> arrayList) {
		this.listAtencion = new JList<Object>(arrayList.toArray());
		scrollPane.setViewportView(listAtencion);
	}
	
	public Paciente getPacienteSeleccionado() {
		return (Paciente) listAtencion.getSelectedValue();
		
	}
	
}
