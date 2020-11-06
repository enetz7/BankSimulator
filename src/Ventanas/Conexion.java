package Ventanas;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import java.util.Calendar;
import java.sql.ResultSet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Conexion {
	private static Connection conectarA(String ruta){
	//Metodo para conectar con la Base De Datos
	Connection conn=null;
			 try{
				 Class.forName("org.sqlite.JDBC");
			 }catch (ClassNotFoundException e){
				 e.printStackTrace();
			 }
			 try{
				 conn= DriverManager.getConnection("jdbc:sqlite:" + ruta);
				 System.out.println("Conexion Ok -Ruta : " + ruta);
			 }catch(SQLException e){
				 e.printStackTrace();
			 }
			 return conn;
			 }
	public  static int SacarNEvento(String ruta) throws SQLException{
		//Metodo para sacar el NumeroEvento
		ResultSet Evento;
		int nevento=0;
		Connection conn=conectarA(ruta);
		try{
			Statement enunciado =conn.createStatement();
			//Sacamos el ulitmo NEvento
			Evento=enunciado.executeQuery("SELECT MAX(NEvento) From Movimiento;");
			while ( Evento.next() ) {
		        nevento = Evento.getInt(1);
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return nevento;
	}
	
	public  static String Fecha() throws SQLException{
		//Metodo para sacar la fecha del momento
		Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String añoS = Integer.toString(año);
        String meS = Integer.toString(mes);
        String diaS = Integer.toString(dia);
        String fechaf= añoS+"-"+meS+"-"+diaS;
        return fechaf;
	}
	public  static int SacarSaldo(String numero, String ruta) throws SQLException{
		//Metodo para sacar el saldo de la Cuenta
		ResultSet dinero;
		int saldo=0;
		Connection conn=conectarA(ruta);
		try{
			Statement enunciado =conn.createStatement();
			dinero=enunciado.executeQuery("SELECT Saldo From Cuenta Where NCuenta='"+numero+"';");
			while ( dinero.next() ) {
		        saldo = dinero.getInt("Saldo");
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return saldo;
	}
	public static void Retirar100(String numerocuenta,String ruta) throws SQLException{
		//Metodo para retirar 100 euros de la cuenta
		Connection conn=conectarA(ruta);
		int saldo=SacarSaldo(numerocuenta,ruta);
		String fecha=Fecha();
		int id=(SacarNEvento(ruta))+1;
		if(saldo>=100) {
		try{
			Statement enunciado =conn.createStatement();
			saldo=saldo-100;
			enunciado.execute("INSERT INTO Movimiento values('"+id+"','"+numerocuenta+"','"+fecha+"','Retirar',100);");
			enunciado.execute("UPDATE Cuenta SET Saldo="+saldo+" Where NCuenta='"+numerocuenta+"';");
			JOptionPane.showMessageDialog(null,"Se ha retirado  correctamente");
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		}
		else {
			JOptionPane.showMessageDialog(null, "Dinero insuficiente");
		}
	}
	public  static void Retirar80(String numerocuenta,String ruta) throws SQLException{
		//Metodo para retirar 80 euros de la cuenta
		int saldo=SacarSaldo(numerocuenta,ruta);
		Connection conn=conectarA(ruta);
		String fecha=Fecha();
		int id=(SacarNEvento(ruta))+1;
		if(saldo>=80) {
		try{
			Statement enunciado =conn.createStatement();
			saldo=saldo-80;
			enunciado.execute("INSERT INTO Movimiento values('"+id+"','"+numerocuenta+"','"+fecha+"','Retirar',80);");
			enunciado.execute("UPDATE Cuenta SET Saldo="+saldo+" Where NCuenta='"+numerocuenta+"';");
			JOptionPane.showMessageDialog(null,"Se ha retirado  correctamente");
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		}
		else {
			JOptionPane.showMessageDialog(null, "Dinero insuficiente");
		}
	}
	public  static void Retirar60(String numerocuenta,String ruta) throws SQLException{
		//Metodo para retirar 60 euros de la cuenta
		int saldo=SacarSaldo(numerocuenta,ruta);
		Connection conn=conectarA(ruta);
		String fecha=Fecha();
		int id=(SacarNEvento(ruta))+1;
		if(saldo>=60) {
		try{
			Statement enunciado =conn.createStatement();
			saldo=saldo-60;
			enunciado.execute("INSERT INTO Movimiento values('"+id+"','"+numerocuenta+"','"+fecha+"','Retirar',60);");
			enunciado.execute("UPDATE Cuenta SET Saldo="+saldo+" Where NCuenta='"+numerocuenta+"';");
			JOptionPane.showMessageDialog(null,"Se ha retirado  correctamente");
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	else {
		JOptionPane.showMessageDialog(null, "Dinero insuficiente");
	}
	}
	public  static void Retirar40(String numerocuenta,String ruta) throws SQLException{
		//Metodo para retirar 40 euros de la cuenta
		int saldo=SacarSaldo(numerocuenta,ruta);
		Connection conn=conectarA(ruta);
		String fecha=Fecha();
		int id=(SacarNEvento(ruta))+1;
		if(saldo>=40) {
		try{
			Statement enunciado =conn.createStatement();
			JOptionPane.showMessageDialog(null,numerocuenta);
			saldo=saldo-40;
			enunciado.execute("INSERT INTO Movimiento values('"+id+"','"+numerocuenta+"','"+fecha+"','Retirar',40);");
			enunciado.execute("UPDATE Cuenta SET Saldo="+saldo+" Where NCuenta='"+numerocuenta+"';");
			JOptionPane.showMessageDialog(null,"Se ha retirado  correctamente");
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		}
		else {
			JOptionPane.showMessageDialog(null, "Dinero insuficiente");
		}
		
	}
	public  static void Retirar20(String numerocuenta,String ruta) throws SQLException{
		//Metodo para retirar 20 euros de la cuenta
		int saldo=SacarSaldo(numerocuenta,ruta);
		Connection conn=conectarA(ruta);
		String fecha=Fecha();
		int id=(SacarNEvento(ruta))+1;
		if(saldo>=20) {
		try{
			Statement enunciado =conn.createStatement();
			JOptionPane.showMessageDialog(null,numerocuenta);
			saldo=saldo-20;
			enunciado.execute("INSERT INTO Movimiento values('"+id+"','"+numerocuenta+"','"+fecha+"','Retirar',20);");
			enunciado.execute("UPDATE Cuenta SET Saldo="+saldo+" Where NCuenta='"+numerocuenta+"';");
			JOptionPane.showMessageDialog(null,"Se ha retirado  correctamente");
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	else {
		JOptionPane.showMessageDialog(null, "Dinero insuficiente");
	}
	}
	public  static void Retirar10(String numerocuenta,String ruta) throws SQLException{
		//Metodo para retirar 10 euros de la cuenta
		int saldo=SacarSaldo(numerocuenta,ruta);
		Connection conn=conectarA(ruta);
		String fecha=Fecha();
		int id=(SacarNEvento(ruta))+1;
		if(saldo>=10) {
		try{
			Statement enunciado =conn.createStatement();
			saldo=saldo-10;
			enunciado.execute("INSERT INTO Movimiento values('"+id+"','"+numerocuenta+"','"+fecha+"','Retirar',10);");
			enunciado.execute("UPDATE Cuenta SET Saldo="+saldo+" Where NCuenta='"+numerocuenta+"';");
			JOptionPane.showMessageDialog(null,"Se ha retirado  correctamente");
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		}
		else {
			JOptionPane.showMessageDialog(null, "Dinero insuficiente");
		}
	}
	public  static void Retirar5(String numerocuenta,String ruta) throws SQLException{
		//Metodo para retirar 5 euros de la cuenta
		int saldo=SacarSaldo(numerocuenta,ruta);
		Connection conn=conectarA(ruta);
		String fecha=Fecha();
		int id=(SacarNEvento(ruta))+1;
		if(saldo>=5) {
		try{
			Statement enunciado =conn.createStatement();
			saldo=saldo-5;
			enunciado.execute("INSERT INTO Movimiento values('"+id+"','"+numerocuenta+"','"+fecha+"','Retirar',5);");
			enunciado.execute("UPDATE Cuenta SET Saldo="+saldo+" Where NCuenta='"+numerocuenta+"';");
			JOptionPane.showMessageDialog(null,"Se ha retirado  correctamente");
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		}
		else {
			JOptionPane.showMessageDialog(null, "Dinero insuficiente");
		}
	}
	public  static void RetirarCantidad(int cantidad,String numerocuenta,String ruta) throws SQLException{
		//Metodo para retirar los euros que tu eligas
		int saldo=SacarSaldo(numerocuenta,ruta);
		Connection conn=conectarA(ruta);
		String fecha=Fecha();
		int id=(SacarNEvento(ruta))+1;
		if(saldo>=cantidad) {
		try{
			Statement enunciado =conn.createStatement();
			saldo=saldo-cantidad;
			enunciado.execute("INSERT INTO Movimiento values('"+id+"','"+numerocuenta+"','"+fecha+"','Retirar',"+cantidad+");");
			enunciado.execute("UPDATE Cuenta SET Saldo="+saldo+" Where NCuenta='"+numerocuenta+"';");
			JOptionPane.showMessageDialog(null,"Se ha retirado correctamente");
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	else {
		JOptionPane.showMessageDialog(null, "Dinero insuficiente");
	}
	}
	public  static void IngresarDinero(int cantidad,String numerocuenta,String ruta) throws SQLException{
		//Metodo para ingresar dinero a la Cuenta
		int saldo=SacarSaldo(numerocuenta,ruta);
		String fecha=Fecha();
		int id=(SacarNEvento(ruta))+1;
		Connection conn=conectarA(ruta);
		try{
			Statement enunciado =conn.createStatement();
			saldo=saldo+cantidad;
			enunciado.execute("INSERT INTO Movimiento values('"+id+"','"+numerocuenta+"','"+fecha+"','Ingresar',"+cantidad+");");
			enunciado.execute("UPDATE Cuenta SET Saldo="+saldo+" Where NCuenta='"+numerocuenta+"';");
			JOptionPane.showMessageDialog(null,"Se ha ingresado correctamente");
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	public  static void AñadirCuentaCajero(String numero,String ruta) throws SQLException{
		//Metodo para editar el NCuenta(cajero)
		Connection conn=conectarA(ruta);
		try{
			Statement enunciado =conn.createStatement();
			enunciado.execute("UPDATE Cajero SET NCuenta='"+numero+"';");
		}catch(SQLException e1){
			e1.printStackTrace();
		}try {
				conn.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
	public  static void AñadirCuentaVentanilla(String numero,String ruta) throws SQLException{
		//Metodo para editar el NCuenta(ventanilla)
		Connection conn=conectarA(ruta);
		try{
			Statement enunciado =conn.createStatement();
			enunciado.execute("UPDATE Oficina SET NCuenta='"+numero+"';");
		}catch(SQLException e1){
			e1.printStackTrace();
		}try {
				conn.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
	public  static void CrearCuenta(String dni,String nombre,String apellido,String fecha,String direccion,String ncuenta,String tipo,int pin,String ruta) throws SQLException{
		//Metodo para crearcuenta
		Connection conn=conectarA(ruta);
		boolean esta=false;
		esta=validar(dni);
		String dni2="";
		ResultSet dni3;
		//Comprobamos el DNI
		if(esta==true) {
			Statement enunciado=conn.createStatement();
			dni3=enunciado.executeQuery("SELECT Dni From Cliente Where Dni='"+dni+"'");
		while(dni3.next()) {
			dni2=dni3.getString(1);
		}
		//Comprobamos que el usuario exista
		if(dni2.equals(dni)){
			JOptionPane.showMessageDialog(null,"Ese usuario ya existe");
		}
		else {
		try {

			enunciado.execute("INSERT INTO Cliente values('"+dni+"','"+nombre+"','"+apellido+"','"+fecha+"','"+direccion+"');");
			enunciado.execute("INSERT INTO Cuenta values('"+ncuenta+"','"+tipo+"',0,"+pin+",'"+dni+"');");
			JOptionPane.showMessageDialog(null,"Tu numero de cuenta es: "+ncuenta+"\n PIN: "+pin + "\n Apuntelo,Por Favor.  ");
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try {	
				conn.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}}}
		else {
			JOptionPane.showMessageDialog(null,"El DNI no es correcto");
		}
		}
	
	
	public  static boolean InicioSesion(String variable1,String variable2,String ruta) throws SQLException{
		//Metodo para el login
		ResultSet resultado;
		Connection conn=conectarA(ruta);
		try {
			Statement enunciado=conn.createStatement();
			resultado=enunciado.executeQuery("SELECT * From Cuenta;");
			while(resultado.next()) {
				if(resultado.getString(1).equals(variable1) && resultado.getString(4).equals(variable2)) {
					try {	
						conn.close();
					}catch(SQLException e1){
						e1.printStackTrace();
					}
					return true;
				}
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return false;
	}
	public static String CogerPin(String variable1,String ruta) throws SQLException {
		//Metodo para coger el pin de la Cuenta
		ResultSet resultado;
		Connection conn=conectarA(ruta);
		String resultado2="";
		try {
		Statement enunciado=conn.createStatement();
		resultado=enunciado.executeQuery("SELECT Pin From Cuenta Where NCuenta='"+variable1+"';");
		while ( resultado.next() ) {
	        resultado2 = resultado.getString("Pin");
		}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return resultado2;
	}
	public static void CambiarPin(String variable1,String ruta,String variable2) throws SQLException {
		//Metodo para cambiar PIN
		Connection conn=conectarA(ruta);
		try {
		Statement enunciado=conn.createStatement();
		enunciado.execute("UPDATE Cuenta SET Pin="+variable2+" Where NCuenta='"+variable1+"';");
		}catch (SQLException e1) {
			e1.printStackTrace();
		}try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	public static void HacerRecibo(String ruta,String numerocuenta)throws SQLException, IOException {
		//Metodo para hacer el recibo
		String rut="C:/Recibo.txt";
		File archivo= new File(rut);
		FileWriter fichero =new FileWriter(archivo);
		PrintWriter pw =new PrintWriter(fichero);
		Connection conn=conectarA(ruta);
		ResultSet datos;
		try {
			Statement enunciado=conn.createStatement();
			datos=enunciado.executeQuery("SELECT * From Movimiento Where NCuenta ='"+numerocuenta+"';");
			pw.println("Numero de cuenta          Fecha      Tipo     Importe");
			while ( datos.next() ) {
		        pw.println(datos.getString("NCuenta")+"   "+datos.getString("Fecha")+"   "+datos.getString("Tipo")+"   "+datos.getInt("Importe"));
			}
			pw.close();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	static String SacarCuentaCajero(String ruta) throws SQLException{
		//Metodo para sacar la Cuenta de cajero
		ResultSet NumCuenta;
		String cuent="";
		Connection conn=conectarA(ruta);
		try{
			Statement enunciado =conn.createStatement();
			NumCuenta=enunciado.executeQuery("SELECT NCuenta From Cajero;");
			while ( NumCuenta.next() ) {
		        cuent = NumCuenta.getString("NCuenta");
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return cuent;
	}
	static int MirarDinero(String ruta) throws SQLException {
		//Metodo para mirar el saldo de la Cuenta
		ResultSet dinero;
		int dinero2=0;
		String NumCuenta=SacarCuentaCajero(ruta);
		Connection conn=conectarA(ruta);
		try {
			Statement enunciado=conn.createStatement();
			dinero=enunciado.executeQuery("SELECT Saldo From Cuenta Where NCuenta='"+NumCuenta+"';");
			while(dinero.next()) {
				dinero2=dinero.getInt("Saldo");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dinero2;
	}
	
	public static void CrearBase(String ruta) throws SQLException{
		//Metodo para crear la Base de Datos
		Connection conn=conectarA(ruta);
		try {
			Statement enunciado =conn.createStatement();
			enunciado.execute("DROP TABLE IF EXISTS Cliente");
			enunciado.execute("CREATE TABLE Cliente(DNI char(9) primary key not null,Nombre char (30),Apellido char(30), FechaNacimiento char(20), Direccion char(40));");
			enunciado.execute("INSERT INTO Cliente values('32423424V','Enetz','Rodriguez','2000-09-15','Palmera Montero');");
			enunciado.execute("DROP TABLE IF EXISTS Cuenta");
			enunciado.execute("CREATE TABLE Cuenta(NCuenta char(20) primary key not null,Tipo char(20),Saldo int,Pin char(4),DNI char(20),FOREIGN KEY (DNI) REFERENCES Cliente(DNI));");
			enunciado.execute("INSERT INTO Cuenta values('ES710030205306928591184','Cuenta bancaria',0,'5770','32423424V');");
			enunciado.execute("DROP TABLE IF EXISTS Oficina");
			enunciado.execute("CREATE TABLE Oficina(NCuenta char(20)primary key not null,FOREIGN KEY (NCuenta) REFERENCES Cuenta(NCuenta));");
			enunciado.execute("DROP TABLE IF EXISTS Cajero");
			enunciado.execute("CREATE TABLE Cajero(NCuenta char(20) primary key not null,FOREIGN KEY (NCuenta) REFERENCES Cuenta(NCuenta));");
			enunciado.execute("INSERT INTO Cajero values('ES710030205306928591184');");
			enunciado.execute("DROP TABLE IF EXISTS Movimiento");
			enunciado.execute("CREATE TABLE Movimiento(NEvento int not null,NCuenta char (20) ,Fecha char (30),Tipo char (30), Importe int,primary key(NEvento,NCuenta),FOREIGN KEY (NCuenta) REFERENCES Cuenta(NCuenta));");
			enunciado.execute("DROP TABLE IF EXISTS Dirige");
			enunciado.execute("CREATE TABLE Dirige(NConsulta char(20), Operacion char(30),Precio double ,NCuenta char(20),primary key(NConsulta,NCuenta) ,FOREIGN KEY (NCuenta) REFERENCES Cuenta(NCuenta));");
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
	}
	}
	public static boolean Darsedebaja(String dni,String ruta,String pin) throws SQLException {
		//Metodo para darse de baja
		ResultSet Consultadni, Consultapin;
		String fni="";
		String fpin="";
		Connection conn=conectarA(ruta);
		try {
		Statement enunciado=conn.createStatement();
		Consultadni=enunciado.executeQuery("SELECT DNI From Cuenta WHERE DNI = '"+dni+"';");
		while ( Consultadni.next() ) {
	        fni = Consultadni.getString(1);
		}
		Consultapin=enunciado.executeQuery("SELECT Pin From Cuenta WHERE Pin = '"+pin+"';");
		while ( Consultapin.next() ) {
	       fpin = Consultadni.getString(1);
		}
		if(fni.equals(dni) && fpin.equals(pin)) {
			enunciado.execute("DELETE FROM Cuenta WHERE DNI = '"+dni+"';");
			enunciado.execute("DELETE FROM Cliente WHERE DNI = '"+dni+"';");
			return true;
		}
		
		}catch (SQLException e1) {
			e1.printStackTrace();
		}try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return false;
	}
public static void Aval(String ruta, int precio) throws SQLException {
		//Metodo para hacer el Aval
		String ncuenta = SacarCuentaCajero(ruta);
		int nconsulta = NConsulta(ruta)+1;
		double precio2=precio;
		Connection conn=conectarA(ruta);
		try {
		Statement enunciado=conn.createStatement();
		enunciado.execute("INSERT INTO Dirige VALUES ("+nconsulta+",'Aval',"+precio2+",'"+ncuenta+"');");
		}catch (SQLException e1) {
			e1.printStackTrace();
		}try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	public  static int NConsulta(String ruta) throws SQLException{
		//Metodo para saber el NConsulta de Dirige
		ResultSet Consulta;
		int nconsulta=0;
		Connection conn=conectarA(ruta);
		try{
			Statement enunciado =conn.createStatement();
			Consulta=enunciado.executeQuery("SELECT MAX(NConsulta) From Dirige;");
			while ( Consulta.next() ) {
		        nconsulta = Consulta.getInt(1);
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return nconsulta;
	}
	public static void Prestamo(String ruta, int precioPrestamo) throws SQLException {
		//Metodo para hacer un prestamo
		int nconsulta = NConsulta(ruta)+1;
		String ncuenta = SacarCuentaCajero(ruta);
		double precioaval = 0.00;
		double precioPrestamo2=precioPrestamo;
		ResultSet avalprecio;
		Connection conn=conectarA(ruta);
		try {
		Statement enunciado=conn.createStatement();
		avalprecio = enunciado.executeQuery("SELECT Precio FROM Dirige Where NCuenta='"+ncuenta+"' and Operacion='Aval';");
		while (avalprecio.next()) 
		{
	        precioaval = avalprecio.getDouble("Precio");
		}
		JOptionPane.showMessageDialog(null,precioaval);
		//En caso de que el precio sera 0
		if(precioaval == 0){
			JOptionPane.showMessageDialog(null, "No tienes Aval");
		}
		//Si es precio del prestamo es superior a la mitad del aval
		else if((precioaval/2) <= precioPrestamo) {
			JOptionPane.showMessageDialog(null, "El precio del aval no es suficiente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Se te ha concedido el prestamo");
			enunciado.execute("INSERT INTO Dirige VALUES ("+nconsulta+",'Prestamo',"+precioPrestamo2+",'"+ncuenta+"');");
		}
		
		}catch (SQLException e1) {
			e1.printStackTrace();
		}try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
public static void RealizarHipoteca(String ruta, double precio) throws SQLException {
		//Metodo para Hacer una Hipoteca
		String ncuenta = SacarCuentaCajero(ruta);
		int nconsulta = NConsulta(ruta)+1;
		Connection conn=conectarA(ruta);
		try {
		Statement enunciado=conn.createStatement();
		enunciado.execute("INSERT INTO Dirige VALUES ("+nconsulta+",'Hipoteca',"+precio+",'"+ncuenta+"');");
		}catch (SQLException e1) {
			e1.printStackTrace();
		}try {	
			conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
public static String  HacerConexion() {
	//Metodo para coger la ruta para despues hacer la conexion
	String Ruta="C:/miBase.db";
	return Ruta;
}
public static boolean validar(String dni){
	//Comprueba el DNI
    String letraMayuscula="";
    if (dni.length() !=9 || Character.isLetter(dni.charAt(8)) == false){
        return false;
    }
    letraMayuscula =(dni.substring(8)).toUpperCase();

    if(soloNumeros(dni) == true && letraDNI(dni).equals(letraMayuscula)){
        return true;
    }
    else{
        return false;
    }
}
private static boolean soloNumeros(String dni){
	//Comprueba los numeros del DNI
    int i,j=0;
    String numero="";
    String miDNI="";
    String[] unoNueve={"0","1","2","3","4","5","6","7","8","9"};
    for(i=0; i<dni.length()-1; i++){
        numero=dni.substring(i,i+1);
        for(j=0; j<unoNueve.length; j++){
            if(numero.equals(unoNueve[j])){
                miDNI+= unoNueve[j];
            }
        }
    }
    if(miDNI.length() != 8){
        return false;
    }
    else{
        return true;
    }
}
private static String letraDNI(String dni){
	//Comprueba la letra del DNI
    int miDNI = Integer.parseInt(dni.substring(0,8));
    int resto=0;
    String miLetra = "";
    String[] asignacionLetra = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
    resto = miDNI % 23;
    miLetra=asignacionLetra[resto];
    return miLetra;
}
}