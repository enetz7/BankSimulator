package Ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.*;



public class Ventanilla extends JFrame {
	
	

	

	
	public Ventanilla(){
		//Ventana de Ventanilla
		JPanel miPanel= new JPanel();
		miPanel.setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,650,500);
		miPanel= new JPanel();
		miPanel.setLayout(null);
		setContentPane(miPanel);
		
		
		JButton Aval_Boton = new JButton("Aval");
		Aval_Boton.setBounds(110,125,75,50);
		Aval_Boton.addActionListener(new EventoAval());
		miPanel.add(Aval_Boton);

		
		JButton Hipoteca_Boton = new JButton("Hipoteca");
		Hipoteca_Boton.setBounds(95,225,100,50);
		Hipoteca_Boton.addActionListener(new EventoHipoteca());
		miPanel.add(Hipoteca_Boton);
		
		

		JButton Prestamo_Boton = new JButton("Prestamo");
		Prestamo_Boton.setBounds(435,125,100,50);
		Prestamo_Boton.addActionListener(new EventoPrestamo());
		miPanel.add(Prestamo_Boton);
		

		JButton DarseDeBaja_Boton = new JButton("Darse de Baja");
		DarseDeBaja_Boton.setBounds(422,225,125,50);
		DarseDeBaja_Boton.addActionListener( new EventoDarsedebaja());
		miPanel.add(DarseDeBaja_Boton);
		
		JButton Atras_Boton = new JButton("Volver");
		Atras_Boton.setBounds(285,300,75,50);
		Atras_Boton.addActionListener(new EventoAtrasVentanilla ());
		miPanel.add(Atras_Boton);
	
		ImageIcon entrada = new ImageIcon("Imagenes"+File.separator+"Vantanilla_menu.jpg");
		JLabel miEtiqueta = new JLabel(entrada);
		miEtiqueta.setBounds(0, 0, 650, 500);
		miPanel.add(miEtiqueta);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
	}
		public class EventoAval implements ActionListener{
				public void actionPerformed (ActionEvent e){
					//Evento que sirve para ir a la pantalla de Aval
					Aval ventana_aval = new Aval ();
					ventana_aval.setVisible(true);
					dispose();
				}
		}
		
		
		public class EventoDarsedebaja implements ActionListener{
			public void actionPerformed (ActionEvent e){
				//Evento que sirve para ir a la pantalla de Darsedebaja
				Darsedebaja ventana_darsedebaja = new Darsedebaja ();
				ventana_darsedebaja.setVisible(true);
				dispose();
			}
		}
			
	
		public class EventoHipoteca implements ActionListener{
			public void actionPerformed (ActionEvent e){
				//Evento que sirve para ir a la pantalla de Hipoteca
				Hipoteca ventana_hipoteca = new Hipoteca ();
				ventana_hipoteca.setVisible(true);
				dispose();
			}
		}
	
		

		public class EventoPrestamo implements ActionListener{
			public void actionPerformed (ActionEvent e){
				//Evento que sirve para ir a la pantalla de Prestamo
				Prestamo ventana_prestamo = new Prestamo ();
				ventana_prestamo.setVisible(true);
				dispose();
			}
		}
		
		public class EventoAtrasVentanilla implements ActionListener{
			public void actionPerformed (ActionEvent e){
				//Evento que sirve para volver a la pantalla de LoginVetanilla
				LoginVentanilla ventana_Loginventanilla = new LoginVentanilla();
				ventana_Loginventanilla.setVisible(true);
				dispose();
			}
		}
}

