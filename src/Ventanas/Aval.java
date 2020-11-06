package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

	public class Aval extends JFrame {
		//La ruta para la conexion
		String ruta=Conexion.HacerConexion();		
		private String tipo;
		private int precioS;
		private JPanel contentPane;
		private JTextField dinero;
		private JComboBox comboBox;

		public Aval() {
			//Ventana de Aval
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel Tipo = new JLabel("Elija el tipo de aval");
			Tipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			Tipo.setBounds(129, 11, 180, 24);
			contentPane.add(Tipo);
			
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Otro", "Vivienda", "Vehiculo", "Embarcacion", "Empresa", "Local", "Marca"}));
			comboBox.setBounds(129, 79, 180, 20);
			contentPane.add(comboBox);
			
			JLabel Precio = new JLabel("Precio");
			Precio.setBounds(129, 123, 46, 14);
			contentPane.add(Precio);
			
			dinero = new JTextField();
			dinero.setHorizontalAlignment(SwingConstants.RIGHT);
			dinero.setBounds(189, 120, 112, 20);
			contentPane.add(dinero);
			dinero.setColumns(10);
		

			
			JLabel label = new JLabel("€");
			label.setBounds(301, 123, 46, 14);
			contentPane.add(label);
			
			JButton Aceptar = new JButton("Aceptar");
			Aceptar.setBounds(100, 186, 99, 33);
			Aceptar.addActionListener(new EventoAval());
			contentPane.add(Aceptar);
			
			JButton Atras = new JButton("Volver");
			Atras.addActionListener(new EventoAtrasAval());
			Atras.setBounds(250,186,99,33);
			contentPane.add(Atras);
			ImageIcon pantallac = new ImageIcon("Imagenes"+File.separator+"prestamos.png");
			JLabel miEtiqueta = new JLabel(pantallac);
			miEtiqueta.setBounds(0, 0, 450,300);
			contentPane.add(miEtiqueta);
			setLocationRelativeTo(null);
			setResizable(false);
			setUndecorated(true);
			getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		}
	
		public class EventoAtrasAval implements ActionListener{
			public void actionPerformed (ActionEvent e){
				//Evento que sirve para mostrar la pantalla de Ventanilla
				Ventanilla ventana_aval = new Ventanilla();
				ventana_aval.setVisible(true);
				dispose();
			}
		}
			
		public class EventoAval implements ActionListener{
			public void actionPerformed(ActionEvent e){
				//Evento que sirve para hacer la accion del Aval
				int precio2=0;
				try {
					String precioS = dinero.getText();
					tipo = (String) comboBox.getSelectedItem();
					//Te comprueba que no meta valores nules o sin rellenar
					if(precioS==null || precioS.equals("")) { 
						precioS="";
						comboBox.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null,"Por favor, meta valores");
					}
					else {
						precio2=Integer.parseInt(precioS);
						Conexion.Aval(ruta,precio2);
						JOptionPane.showMessageDialog(null,"Tu aval ha sido creado");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
			
}


