package Ventanas;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import java.awt.Color;
import java.awt.Font;
public class Ajustes extends JFrame {
	private JLabel Pin;
	public Ajustes(){
		//Ventana de ajustes
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,650,500);
		JPanel miPanel= new JPanel();
		miPanel.setLayout(null);
		setContentPane(miPanel);
		Pin= new JLabel("<---- Cambiar PIN");
		Pin.setBounds(90,200,200,50);
		Pin.setForeground(Color.WHITE);
		Pin.setFont(new Font("Courier New",Font.ITALIC,14));
		miPanel.add(Pin);
		JButton cambiar = new JButton();
		cambiar.setBounds(20,206,40,30);
		cambiar.addActionListener(new EventoCambiarPin());
		miPanel.add(cambiar);
		JButton atras= new JButton("Volver");
		atras.setBounds(250,425,160,50);
		atras.addActionListener(new Volver());
		miPanel.add(atras);
		ImageIcon pantallac = new ImageIcon("Imagenes"+File.separator+"pantallac.png");
		JLabel miEtiqueta = new JLabel(pantallac);
		miEtiqueta.setBounds(0, 0, 650,500);
		miPanel.add(miEtiqueta);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	}
	public class EventoCambiarPin implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para mostrar la pantalla de cambiar PIN
			CambiarPin cam= new CambiarPin();
			cam.setVisible(true);
			dispose();
	}
}
	public class Volver implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Evento que sirve para volver a la pantalla de Cajero
			Cajero cam= new Cajero();
			cam.setVisible(true);
			dispose();
		}
	}
}