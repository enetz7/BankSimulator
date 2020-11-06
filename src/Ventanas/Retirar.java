package Ventanas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import Ventanas.Cajero.EventoVolver;


public class Retirar extends JFrame {
	private String NumeroCuenta;
	//La ruta para la conexion
	String ruta=Conexion.HacerConexion();	
	public Retirar(){
		//Pantalla de Retirar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,650,500);
		JPanel miPanel= new JPanel();
		miPanel.setLayout(null);
		setContentPane(miPanel);
		JLabel ing1 = new JLabel("100");
		ing1.setBounds(100,200,200,50);
		ing1.setForeground(Color.WHITE);
		ing1.setFont(new Font("Courier New",Font.ITALIC,20));
		miPanel.add(ing1);
		JButton ingre100 = new JButton("");
		ingre100.setBounds(20,206,40,30);
		ingre100.addActionListener(new EventoRetirar100());
		miPanel.add(ingre100);
		JLabel ing2 = new JLabel("80");
		ing2.setBounds(520,200,200,50);
		ing2.setForeground(Color.WHITE);
		ing2.setFont(new Font("Courier New",Font.ITALIC,20));
		miPanel.add(ing2);
		JButton ingre80 = new JButton("");
		ingre80.setBounds(590,206,40,30);
		ingre80.addActionListener(new EventoRetirar80());
		miPanel.add(ingre80);
		JLabel ing3 = new JLabel("60");
		ing3.setBounds(100,254,200,50);
		ing3.setForeground(Color.WHITE);
		ing3.setFont(new Font("Courier New",Font.ITALIC,20));
		miPanel.add(ing3);
		JButton ingre60 = new JButton("");
		ingre60.setBounds(20,260,40,30);
		ingre60.addActionListener(new EventoRetirar60());
		miPanel.add(ingre60);
		JLabel ing4 = new JLabel("40");
		ing4.setBounds(520,254,200,50);
		ing4.setForeground(Color.WHITE);
		ing4.setFont(new Font("Courier New",Font.ITALIC,20));
		miPanel.add(ing4);
		JButton ingre40 = new JButton("");
		ingre40.setBounds(590,260,40,30);
		ingre40.setVisible(true);
		ingre40.addActionListener(new EventoRetirar40());
		miPanel.add(ingre40);
		JLabel ing5 = new JLabel("20");
		ing5.setBounds(100,307,200,50);
		ing5.setForeground(Color.WHITE);
		ing5.setFont(new Font("Courier New",Font.ITALIC,20));
		miPanel.add(ing5);
		JButton ingre20 = new JButton("");
		ingre20.setBounds(20,314,40,30);
		ingre20.addActionListener(new EventoRetirar20());
		miPanel.add(ingre20);
		JLabel ing6 = new JLabel("10");
		ing6.setBounds(520,307,200,50);
		ing6.setForeground(Color.WHITE);
		ing6.setFont(new Font("Courier New",Font.ITALIC,20));
		miPanel.add(ing6);
		JButton ingre10 = new JButton("");
		ingre10.setBounds(590,314,40,30);
		ingre10.addActionListener(new EventoRetirar10());
		miPanel.add(ingre10);
		JLabel ing7 = new JLabel("5");
		ing7.setBounds(100,361,200,50);
		ing7.setForeground(Color.WHITE);
		ing7.setFont(new Font("Courier New",Font.ITALIC,20));
		miPanel.add(ing7);
		JButton ingre5 = new JButton("");
		ingre5.setBounds(20,368,40,30);
		ingre5.addActionListener(new EventoRetirar5());
		miPanel.add(ingre5);
		JLabel ing8 = new JLabel("Otra Cantidad");
		ing8.setBounds(390,361,200,50);
		ing8.setForeground(Color.WHITE);
		ing8.setFont(new Font("Courier New",Font.ITALIC,20));
		miPanel.add(ing8);
		JButton otro = new JButton("");
		otro.setBounds(590,368,40,30);
		otro.setVisible(true);
		otro.addActionListener(new EventoOtro());
		miPanel.add(otro);
		JButton volver = new JButton("Volver");
		volver.setBounds(250,425,160,50);
		volver.addActionListener(new Volver());
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
	public class EventoRetirar100 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para retirar 100 euros
			CogerNCuenta();
			Cajero rec = new Cajero();
			rec.setVisible(true);
			dispose();
			try {
				Conexion.Retirar100(NumeroCuenta,ruta);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
	}
}
	public class EventoRetirar80 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para retirar 80 euros
			CogerNCuenta();
			Cajero rec = new Cajero();
			rec.setVisible(true);
			dispose();
			try {
				Conexion.Retirar80(NumeroCuenta,ruta);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

	}
}
	public class EventoRetirar60 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para retirar 60 euros
			CogerNCuenta();
			Cajero rec = new Cajero();
			rec.setVisible(true);
			dispose();
			try {
				Conexion.Retirar60(NumeroCuenta,ruta);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
}
	public class EventoRetirar40 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para retirar 40 euros
			CogerNCuenta();
			Cajero rec = new Cajero();
			rec.setVisible(true);
			dispose();
			try {
				Conexion.Retirar40(NumeroCuenta,ruta);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
}
	public class EventoRetirar20 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para retirar 20 euros
			CogerNCuenta();
			Cajero rec = new Cajero();
			rec.setVisible(true);
			dispose();
			try {
				Conexion.Retirar20(NumeroCuenta,ruta);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
}
	public class EventoRetirar10 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para retirar 10 euros
			CogerNCuenta();
			Cajero rec = new Cajero();
			rec.setVisible(true);
			dispose();
			try {
				Conexion.Retirar10(NumeroCuenta,ruta);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
}
	public class EventoRetirar5 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para retirar 5 euros
			CogerNCuenta();
			Cajero rec = new Cajero();
			rec.setVisible(true);
			dispose();
			try {
				Conexion.Retirar5(NumeroCuenta,ruta);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
}
	public class EventoOtro implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para retirar cualquier dinero
			String cantidad=JOptionPane.showInputDialog("Introduce el dinero que desea retirar");
			//Comprobamos que no meta valores nulos
            while(cantidad==null || cantidad.equals("")) {
            JOptionPane.showMessageDialog(null, "No ha introducido un valor valido");
            cantidad=JOptionPane.showInputDialog("Introduce el dinero que desea retirar");
            }
            int cantidad2=Integer.parseInt(cantidad);
			CogerNCuenta();
			Cajero rec = new Cajero();
			rec.setVisible(true);
			dispose();
			try {
				Conexion.RetirarCantidad(cantidad2,NumeroCuenta,ruta);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
}
		public void CogerNCuenta(){
			//Metodo para cojer el NCuenta de Cuenta
		try {
			NumeroCuenta=Conexion.SacarCuentaCajero(ruta);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
		public class Volver implements ActionListener{
			public void actionPerformed(ActionEvent e){
				//Evento que sirve para volver a la pantalla de Cajero
				Cajero er = new Cajero();
				er.setVisible(true);
				dispose();
		}
	}
	}