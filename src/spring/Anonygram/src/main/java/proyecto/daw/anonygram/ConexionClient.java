package proyecto.daw.anonygram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import proyecto.daw.anonygram.models.Mensaje;

public class ConexionClient  extends Thread implements Observer{
	
	private Socket socket;
	private Mensaje mensaje;
	private DataInputStream entradaDatos;
	private DataOutputStream salidaDatos;
	
	public ConexionClient(Socket socket, Mensaje mensaje) {
		this.socket = socket;
		this.mensaje = mensaje;
		
		try {
			entradaDatos = new DataInputStream(socket.getInputStream());
			salidaDatos = new DataOutputStream(socket.getOutputStream());
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			salidaDatos.writeUTF(arg.toString());
		}catch (IOException e) {
			System.out.println("EROR: Error al enviar mensaje al cliente. "+e.getMessage());
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		String mensajeRecibido;
		boolean conectado = true;
		
		mensaje.addObserver(this);
		
		while(conectado) {
			try {
				mensajeRecibido = entradaDatos.readUTF();
				mensaje.setMessage(mensajeRecibido);
			}catch (IOException e) {
				System.out.println("Cliente con la IP: "+socket.getInetAddress().getHostName()+" Desconectado");
				conectado = false;
				try {
					entradaDatos.close();
					salidaDatos.close();
				}catch(IOException ex) {
					System.out.println("EROR: Error al cerrar los stream de entrada y salida: "+ex.getMessage());
				}
			}
		}
		
		
	}

}
