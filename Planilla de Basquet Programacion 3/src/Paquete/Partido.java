package Paquete;
import java.util.LinkedList;
import java.util.HashMap;
public class Partido {

	protected HashMap<String,Equipo> equipos = new HashMap<String,Equipo>();//L o V
	protected LinkedList<Incidencia> listaIncidencias = new LinkedList<Incidencia>();
	protected int periodo;
	//fecha: date
	protected int puntosL;  
	protected int puntosV; 

}