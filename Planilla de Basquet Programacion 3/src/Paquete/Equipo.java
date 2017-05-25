package Paquete;
import java.util.HashMap;
import java.util.LinkedList;
public class Equipo {
	protected String nombreEquipo;
	protected String nombreEntrenador;
	protected LinkedList<Partido> listaPartidos = new LinkedList<Partido>();
	protected HashMap<Integer,Jugador> plantel = new HashMap<Integer,Jugador>();

	public Equipo (String n, String e)
	{
		nombreEquipo=n;
		nombreEntrenador=e;
	} 

	public String getNombreEquipo()
	{
		return nombreEquipo;
	}

	public String getNombreEntrenador()
	{
		return nombreEntrenador;
	}

	public LinkedList<Partido> getListaPartidos()
	{
		return listaPartidos;
	}

	public HashMap<Integer,Jugador> getPlantel ()
	{
		return plantel;
	}

	public void agregarJugadorAPlantel(Jugador nuevo)
	{
		plantel.put(nuevo.getDorsal(),nuevo);
	}

	public void agregarPartidoAListaPartidos(Partido nuevo)
	{
		listaPartidos.add(nuevo);
	} 
}