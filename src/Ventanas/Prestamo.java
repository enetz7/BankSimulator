package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

	public class Prestamo extends JFrame {
		
		private int precio;
		private int precioPrestamo;
		//La ruta para la conexion
		String ruta=Conexion.HacerConexion();
		private JPanel contentPane;
		private JTextField textField;
		
		public Prestamo() {
			//Pantalla de Prestamo
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 466, 319);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblPrestamo = new JLabel("Prestamo");
			lblPrestamo.setBounds(175, 11, 103, 31);
			lblPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 25));
			contentPane.add(lblPrestamo);
			
			JLabel Cantidad = new JLabel("Introduzca la cantidad del prestamo :");
			Cantidad.setBounds(91, 68, 276, 37);
			Cantidad.setHorizontalAlignment(SwingConstants.LEFT);
			Cantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPane.add(Cantidad);
			
			textField = new JTextField();
			textField.setBounds(101, 109, 241, 31);
			textField.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPane.add(textField);
			textField.setColumns(10);
			
			
			
			JLabel euro = new JLabel("€");
			euro.setBounds(341, 104, 26, 37);
			euro.setHorizontalAlignment(SwingConstants.LEFT);
			euro.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPane.add(euro);
			
			JButton Aceptar = new JButton("Aceptar");
			Aceptar.setBounds(100, 226, 89, 31);
			Aceptar.addActionListener(new EventoPrestamo());
			contentPane.add(Aceptar);
			
			JLabel CantidadNO = new JLabel("(La cantidad no podra ser superior al 50% de su aval)");
			CantidadNO.setBounds(100, 130, 251, 37);
			CantidadNO.setHorizontalAlignment(SwingConstants.LEFT);
			CantidadNO.setFont(new Font("Tahoma", Font.PLAIN, 10));
			contentPane.add(CantidadNO);
		
			
			
			JButton Atras = new JButton("Volver");
			Atras.addActionListener(new EventoAtrasPrestamo());
			Atras.setBounds(220,226,99,33);
			contentPane.add(Atras);
			setLocationRelativeTo(null);
			setResizable(false);
			setUndecorated(true);
			getRootPane().setWindowDecorationStyle(JRootPane.NONE);
			
			
			ImageIcon pantallac = new ImageIcon("Imagenes"+File.separator+"Blog-Portada-Prestamos-DIA-2-v3.jpg");
			JLabel miEtiqueta = new JLabel(pantallac);
			miEtiqueta.setBounds(0, 0, 466,319);
			contentPane.add(miEtiqueta);
			
		}
		
		public class EventoAtrasPrestamo implements ActionListener{
			public void actionPerformed (ActionEvent e){
				//Evento que sirve para volver a la pantalla de Ventanilla
				Ventanilla ventana_prestamo = new Ventanilla();
				ventana_prestamo.setVisible(true);
				dispose();
			}
		}
		
		
		public class EventoPrestamo implements ActionListener{
			public void actionPerformed(ActionEvent e){
				//Evento que sirve para hacer un prestamo
				String precioPrestamo2=textField.getText();
				if(precioPrestamo2==null || precioPrestamo2.equals("")) {
					JOptionPane.showMessageDialog(null,"Mete una cantidad");
				}
				else {
					precioPrestamo = Integer.parseInt(textField.getText());
				try {
					Conexion.Prestamo(ruta,precioPrestamo);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				Ventanilla ventana_prestamo = new Ventanilla();
				ventana_prestamo.setVisible(true);
				dispose();
		}
			}
	}
}


