package Ventanas;
import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
public class Entrada extends JFrame{
	Pasillo mi = new Pasillo();
	//La ruta para la conexion
	String ruta=Conexion.HacerConexion();
	public Entrada(){
		//Pantalla de la Entrada
		JPanel miPanel= new JPanel();
		miPanel.setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,650,500);
		miPanel= new JPanel();
		miPanel.setLayout(null);
		setContentPane(miPanel);
		JButton boton = new JButton("Entrar");
		boton.setBounds(390,310,100,40);
		boton.addActionListener(new EventoEntrar());
		miPanel.add(boton);
		JButton base = new JButton("Crear BBDD");
		base.setBounds(30,430,120,30);
		base.addActionListener(new EventoCrearBase());
		miPanel.add(base);
		ImageIcon entrada = new ImageIcon("Imagenes"+File.separator+"fiddle.png");
		JLabel miEtiqueta = new JLabel(entrada);
		miEtiqueta.setBounds(0, 0, 650, 500);
		miPanel.add(miEtiqueta);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
}
	public class EventoEntrar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para volver a la pantalla de Pasillo
			JOptionPane.showMessageDialog(null, "Bienvenido a Fiddle");
			mi.setVisible(true);
			dispose();
	}
	}
	public class EventoCrearBase implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para crear la Base de Datos
			try {
				Conexion.CrearBase(ruta);
				JOptionPane.showMessageDialog(null, "Su base de datos se ha creado correctamente en: " + ruta);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
	}
}