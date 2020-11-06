
package Ventanas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.awt.Font;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;


public class LoginVentanilla extends JFrame {
	private JLabel numerocuenta;
	private JLabel pin;
	private JLabel titulo;
	public JButton boton1;
	public JButton boton2;
	public JButton boton3;
	//La ruta para la conexion
	String ruta=Conexion.HacerConexion();
	public JTextField textArea;
	public JPasswordField textArea2;
	boolean esta=false;
	public JLabel mal;
	Ventanilla ventana=new Ventanilla();
	public LoginVentanilla() {
		//Pantalla de LoginVentanilla
		setTitle("Acceso Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,650,500);
		JPanel miPanel=new JPanel();
		miPanel.setLayout(null);
		setContentPane(miPanel);
		titulo= new JLabel("Acceso Clientes");
		titulo.setBounds(130,-140,380,380);
		titulo.setFont(new Font("Courier New", Font.ITALIC,40));
		miPanel.add(titulo);
		numerocuenta= new JLabel("Numero de cuenta:");
		numerocuenta.setBounds(40,60,200,200);
		miPanel.add(numerocuenta);
		pin= new JLabel("Pin:");
		pin.setBounds(40,100,200,200);
		miPanel.add(pin);
		textArea= new JTextField(20);
		textArea.setBounds(200,150,200,20);
		miPanel.add(textArea);
		textArea2= new JPasswordField(20);
		textArea2.setBounds(200,190,200,20);
		miPanel.add(textArea2);
		boton1=new JButton("Entrar");
		boton1.setBounds(400,250,100,50);
		boton1.addActionListener(new InicioSesion());
		miPanel.add(boton1);
		boton2=new JButton("Volver");
		boton2.setBounds(35,400,160,50);
		boton2.addActionListener(new VolverAtras());
		miPanel.add(boton2);
		boton3=new JButton("Crear Cuenta");
		boton3.setBounds(450,400,160,50);
		boton3.addActionListener(new CrearCuenta());
		miPanel.add(boton3);
		mal= new JLabel("Datos erroneos");
		mal.setBounds(400,170,200,20);
		mal.setFont(new Font("Courier New", Font.ITALIC,20));
		mal.setForeground(Color.red);
		mal.setVisible(false);
		miPanel.add(mal);
		ImageIcon fondo= new ImageIcon("Imagenes"+File.separator+"Login.jpg");
		JLabel miEtiqueta= new JLabel(fondo);
		miEtiqueta.setBounds(0, 0,650,500);
		miPanel.add(miEtiqueta);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
}
	public class InicioSesion implements ActionListener {
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para hacer el login
			boolean confi=false;
			String NCuenta=textArea.getText();
			String pin=textArea2.getText();
			try {
				confi=Conexion.InicioSesion(NCuenta,pin,ruta);
				if(confi==true) {
						esta=true;
						try {
							Conexion.AñadirCuentaVentanilla(NCuenta,ruta);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						ventana.setVisible(true);
						dispose();
					}
				//Si los datos estan mal
				if(esta==false) {
					mal.setVisible(true);
				}
					
			}catch (SQLException e1) {
				e1.printStackTrace();
			}	
		}
		}
public class CrearCuenta implements ActionListener{
public void actionPerformed(ActionEvent e) {
	//Evento que sirve para volver a la pantalla de Crear Cuenta
	CrearCuenta1 pa1=new CrearCuenta1();
	pa1.setVisible(true);
	dispose();
}
}
public class VolverAtras implements ActionListener{
public void actionPerformed(ActionEvent e) {
	//Evento que sirve para volver a la pantalla de Pasillo
	Pasillo pass= new Pasillo();
	pass.setVisible(true);
	dispose();
}
}
}