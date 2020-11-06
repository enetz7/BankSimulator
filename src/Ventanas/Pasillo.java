package Ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class Pasillo extends JFrame {
	//Pantalla de Pasillo
	LoginVentanilla vent=new LoginVentanilla();
	LoginCajero caje=new LoginCajero();
	public Pasillo() {
	JPanel miPanel= new JPanel();
	miPanel.setLayout(new FlowLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0,0,650,500);
	miPanel= new JPanel();
	miPanel.setLayout(null);
	setContentPane(miPanel);
	JButton ventana = new JButton("Ventanilla");
	ventana.setBounds(100,240,100,40);
	ventana.addActionListener(new EventoVentanilla());
	miPanel.add(ventana);
	JButton cajer = new JButton("Cajero");
	cajer.setBounds(410,240,100,40);
	cajer.setVisible(true);
	cajer.addActionListener(new EventoCajero());
	miPanel.add(cajer);
	JButton atras=new JButton("Salir");
	atras.setBounds(280,400,100,40);
	atras.addActionListener(new Salir());
	miPanel.add(atras);
	ImageIcon ventanilla = new ImageIcon("Imagenes"+File.separator+"ventanilla.jpg");
	JLabel miV = new JLabel(ventanilla);
	miV.setBounds(0, 0, 320,500);
	miPanel.add(miV);
	ImageIcon cajero = new ImageIcon("Imagenes"+File.separator+"Cajero.PNG");
	JLabel miC = new JLabel(cajero);
	miC.setBounds(270, 0, 430,500);
	miPanel.add(miC);
	setLocationRelativeTo(null);
	setResizable(false);
	setUndecorated(true);
	getRootPane().setWindowDecorationStyle(JRootPane.NONE);
}
public class EventoVentanilla implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//Evento que sirve para ir a la pantalla de LoginVentanilla
		vent.setVisible(true);
		dispose();
}
}
public class EventoCajero implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//Evento que sirve para ir a la pantalla de LoginCajero
		caje.setVisible(true);
		dispose();
}
}
public class Salir implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		//Evento que sirve para cerrar la aplicacion
		dispose();
	}
}
}
