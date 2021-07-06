package vista;

import concurrencia.Asociado;
import persona.paciente.Paciente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * Esta clase es la encargada de mostrar informacion por pantalla como tambien de determinar la valides del formato de los datos que el usuario ingresa<br>
 * <b> Patron aplicado: </b> MVC
 *
 * @author Los Cafeteros
 */

public class Ventana extends JFrame implements IVista{

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDNI;
	private JTextField tfTelefono;
	private JTextField tfDomicilio;
	JButton btnFactura = new JButton("GENERAR FACTURA");
	JButton btnAgregar = new JButton("AGREGAR");
	JButton btnEliminar = new JButton("ELIMINAR");
	JButton btnSerializar;
	JButton btnSimulacion;
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane();
	JList listAtencion;

	JScrollPane scrollPane_1 = new JScrollPane();
	JScrollPane scrollPaneAsociados = new JScrollPane();
	JList listAsociados;

	JScrollPane scrollPane_2 = new JScrollPane();
	JList list_2;

	JTextArea textEstadoAmb = new JTextArea();

	JRadioButton rdbtnDomicilio;
	JRadioButton rdbtnTraslado;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfCantidadConsultas;

	public Ventana() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("img/cruzroja.png"));
		setIconImage(getIconImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 690);
		setTitle("Clinica Los Cafeteros");
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
		lblPacientesEnAtencion.setFont(new Font("Verdana", Font.BOLD, 14));
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
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		panel_2.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		grilla.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(8, 2, 0, 15));

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel_4.add(panel);

		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Verdana", Font.PLAIN, 12));
		tfNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfNombre);
		tfNombre.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1_1);

		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);

		tfApellido = new JTextField();
		tfApellido.setFont(new Font("Verdana", Font.PLAIN, 12));
		tfApellido.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(tfApellido);
		tfApellido.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("DNI");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1_2);

		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);

		tfDNI = new JTextField();
		tfDNI.setFont(new Font("Verdana", Font.PLAIN, 12));
		tfDNI.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(tfDNI);
		tfDNI.setColumns(10);

		JLabel lblNewLabel_1_3 = new JLabel("Telefono");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1_3);

		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);

		tfTelefono = new JTextField();
		tfTelefono.setFont(new Font("Verdana", Font.PLAIN, 12));
		tfTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(tfTelefono);
		tfTelefono.setColumns(10);

		JLabel lblNewLabel_1_4 = new JLabel("Domicilio");
		lblNewLabel_1_4.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1_4);

		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);

		tfDomicilio = new JTextField();
		tfDomicilio.setFont(new Font("Verdana", Font.PLAIN, 12));
		tfDomicilio.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(tfDomicilio);
		tfDomicilio.setColumns(10);

		rdbtnDomicilio = new JRadioButton("Atencion a domicilio");
		rdbtnDomicilio.setSelected(true);
		buttonGroup.add(rdbtnDomicilio);
		rdbtnDomicilio.setFont(new Font("Verdana", Font.PLAIN, 12));
		rdbtnDomicilio.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(rdbtnDomicilio);

		rdbtnTraslado = new JRadioButton("Traslado a clinica");
		buttonGroup.add(rdbtnTraslado);
		rdbtnTraslado.setRolloverEnabled(false);
		rdbtnTraslado.setFont(new Font("Verdana", Font.PLAIN, 12));
		rdbtnTraslado.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(rdbtnTraslado);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad de consultas");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);
		
		JPanel panel_15 = new JPanel();
		panel_4.add(panel_15);
		
		tfCantidadConsultas = new JTextField();
		panel_15.add(tfCantidadConsultas);
		tfCantidadConsultas.setText("1");
		tfCantidadConsultas.setHorizontalAlignment(SwingConstants.CENTER);
		tfCantidadConsultas.setFont(new Font("Verdana", Font.PLAIN, 12));
		tfCantidadConsultas.setColumns(10);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnAgregar.setBackground(new Color(0, 128, 0));
		btnAgregar.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_4.add(btnAgregar);

		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_4.add(btnEliminar);

		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(SystemColor.activeCaption);
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_11.add(panel_12, BorderLayout.SOUTH);

		btnSimulacion = new JButton("INICIAR SIMULACION");
		btnSimulacion.setActionCommand("INICIARSIMULACION");
		btnSimulacion.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_12.add(btnSimulacion);

		scrollPaneAsociados = new JScrollPane();
		panel_11.add(scrollPaneAsociados, BorderLayout.CENTER);

		listAsociados = new JList();
		listAsociados.setFont(new Font("Tahoma", Font.PLAIN, 58));
		scrollPaneAsociados.setViewportView(listAsociados);

		JPanel panelDer = new JPanel();
		panelDer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panelDer, BorderLayout.EAST);
		panelDer.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 127, 80));
		panelDer.add(panel_6, BorderLayout.NORTH);

		JLabel lblAmbulancia = new JLabel("AMBULANCIA");
		lblAmbulancia.setFont(new Font("Verdana", Font.BOLD, 14));
		panel_6.add(lblAmbulancia);

		JPanel panel_13 = new JPanel();
		panelDer.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout(0, 0));

		JPanel panelEstadoAmb = new JPanel();
		panel_13.add(panelEstadoAmb, BorderLayout.NORTH);
		textEstadoAmb.setBackground(UIManager.getColor("CheckBox.light"));
		textEstadoAmb.setText("Estado");
		textEstadoAmb.setFont(new Font("Verdana", Font.BOLD, 16));

		panelEstadoAmb.add(textEstadoAmb);

		panel_13.add(scrollPane_1, BorderLayout.CENTER);

		scrollPane_1.setViewportView(textArea);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(70, 130, 180));
		panelDer.add(panel_14, BorderLayout.SOUTH);
		
		btnSerializar = new JButton("SERIALIZAR");
		btnSerializar.setFont(new Font("Verdana", Font.PLAIN, 12));
		panel_14.add(btnSerializar);
	}

	public void setListenerBotones(ActionListener controlador) {
		btnAgregar.addActionListener(controlador);
		btnEliminar.addActionListener(controlador);
		btnFactura.addActionListener(controlador);
		btnSimulacion.addActionListener(controlador);
		btnSerializar.addActionListener(controlador);
	}

	@Override
	public void setWindowListener(WindowListener windowListener) {
		this.addWindowListener(windowListener);
	}

	public void actualizarPacientesAtencion(ArrayList<Paciente> arrayList) {
		this.listAtencion = new JList<Object>(arrayList.toArray());
		scrollPane.setViewportView(listAtencion);
	}

	public void actualizarAsociados(ArrayList<Asociado> arrayList) {
		this.listAsociados = new JList<Object>(arrayList.toArray());
		scrollPaneAsociados.setViewportView(listAsociados);
	}

	public Paciente getPacienteSeleccionado() {
		return (Paciente) listAtencion.getSelectedValue();
	}

	public Asociado getAsociadoSeleccionado() {
		return (Asociado) listAsociados.getSelectedValue();
	}

	public String getNombre() {
		return tfNombre.getText();
	}

	public String getApellido() {
		return tfApellido.getText();
	}

	public String getDNI() {
		return tfDNI.getText();
	}

	public String getTelefono() {
		return tfTelefono.getText();
	}

	public String getDomicilio() {
		return tfDomicilio.getText();
	}

	public void setEstadoAmbulancia(String texto) {
		this.textEstadoAmb.setText(texto);
	}

	public void nuevoSuceso(String suceso) {
		this.textArea.append(suceso);
	}

	public String getActividad() {
		if (rdbtnDomicilio.isSelected())
			return "DOMICILIO";
		else if (rdbtnTraslado.isSelected())
			return "TRASLADO";
		else return null; //No pasa nunca, solo hay dos botones
	}
	public String getCantidadConsultas() {
		return tfCantidadConsultas.getText();
		
	}
}
