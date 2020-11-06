package Ventanas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.awt.image.*;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Cajero extends JFrame {
	Ingresar in = new Ingresar();
	Retirar re = new Retirar();
	Ajustes aj = new Ajustes();
	//La ruta para la conexion
	String ruta=Conexion.HacerConexion();
	private String NumeroCuenta;
	
	public Cajero(){
		//Ventana de Cajero
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,650,500);
		JPanel miPanel= new JPanel();
		miPanel.setLayout(null);
		setContentPane(miPanel);
		JLabel ing = new JLabel("<----- Ingresar dinero");
		ing.setBounds(90,200,200,50);
		ing.setForeground(Color.WHITE);
		ing.setFont(new Font("Courier New",Font.ITALIC,14));
		miPanel.add(ing);
		JButton ingre = new JButton();
		ingre.setBounds(20,206,40,30);
		ingre.addActionListener(new EventoIngresar());
		miPanel.add(ingre);
		JLabel ret = new JLabel("<----- Retirar dinero");
		ret.setBounds(90,254,200,50);
		ret.setForeground(Color.WHITE);
		ret.setFont(new Font("Courier New",Font.ITALIC,14));
		miPanel.add(ret);
		JButton reti = new JButton();
		reti.setBounds(20,260,40,30);
		reti.addActionListener(new EventoRetirar());
		miPanel.add(reti);
		JLabel recir = new JLabel("Imprimir recibo ----->");
		recir.setBounds(385,200,200,50);
		recir.setForeground(Color.WHITE);
		recir.setFont(new Font("Courier New",Font.ITALIC,14));
		miPanel.add(recir);
		JButton reci = new JButton();
		reci.setBounds(595,206,40,30);
		reci.addActionListener(new EventoRecibo());
		miPanel.add(reci);
		JLabel ajus = new JLabel("Ajustes ----->");
		ajus.setBounds(448,254,200,50);
		ajus.setForeground(Color.WHITE);
		ajus.setFont(new Font("Courier New",Font.ITALIC,14));
		miPanel.add(ajus);
		JButton aju = new JButton();
		aju.setBounds(595,260,40,30);
		aju.setVisible(true);
		aju.addActionListener(new EventoAjustes());
		miPanel.add(aju);
		JLabel mirarDinero=new JLabel("<----- Mirar Saldo");
		mirarDinero.setBounds(90,304,200,50);
		mirarDinero.setForeground(Color.WHITE);
		mirarDinero.setFont(new Font("Courier New",Font.ITALIC,14));
		miPanel.add(mirarDinero);
		JButton mirar=new JButton();
		mirar.setBounds(20,315,40,30);
		mirar.addActionListener(new Dinero());
		miPanel.add(mirar);
		JButton volver = new JButton("Volver");
		volver.setBounds(250,425,160,50);
		volver.addActionListener(new EventoVolver());
		miPanel.add(volver);
		ImageIcon pantallac = new ImageIcon("Imagenes"+File.separator+"pantallac.png");
		JLabel miEtiqueta = new JLabel(pantallac);
		miEtiqueta.setBounds(0, 0, 650,500);
		miPanel.add(miEtiqueta);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
}
	public class EventoIngresar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para ir a la pantalla de Ingresar
			in.setVisible(true);
			dispose();
	}
}
	public class EventoRetirar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para ir a la pantalla de Retirar
			re.setVisible(true);
			dispose();
	}
}
	public class EventoRecibo implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para hacer el recibo
			try {
				Conexion.HacerRecibo(ruta,NumeroCuenta);
			} catch (SQLException | IOException e1) {
				e1.printStackTrace();
			}
	}
}
	public class EventoAjustes implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para ir a la pantalla de Ajustes
			aj.setVisible(true);
			dispose();
	}
}
	public class EventoVolver implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para volver a la pantalla de Pasillo
			Pasillo er = new Pasillo();
			er.setVisible(true);
			dispose();
	}
	}
	public class Dinero implements ActionListener{
		//Evento que sirve para mostrar el saldo de tu cuenta
		public void actionPerformed(ActionEvent e) {
			int saldo=0;
			try {
				saldo=Conexion.MirarDinero(ruta);
			}catch(SQLException e1) {
				e1.printStackTrace();
			}

			JOptionPane.showMessageDialog(null,"Tu saldo es: " + saldo + "€");
		}
	}
	public void CogerNCuenta(){
		//Metodo que coje el numero de cuenta
		try {
			NumeroCuenta=Conexion.SacarCuentaCajero(ruta);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
