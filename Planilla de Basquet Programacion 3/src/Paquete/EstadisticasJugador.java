package Paquete;

public class EstadisticasJugador {
	protected int faltas;//1
	protected int simplesConvert;//2
	protected int simplesErrados;//3
	protected int doblesConvert;//4
	protected int doblesErrados;//5
	protected int triplesConvert;//6
	protected int triplesErrados;//7
	protected int asistencias;//8
	protected int perdidas;//9
	protected int rebotesAt;//10
	protected int rebotesDef;//11
	protected int tirosDeCampo;//12

	public int getFaltas()
	{
		return faltas;
	}

	public int getSimplesConvertidos()
	{
		return simplesConvert;
	}

	public int getSimplesErrados()
	{
		return simplesErrados;
	}

	public int getTriplesConvert()
	{
		return faltas;
	}

	public int getTriplesErrados()
	{
		return triplesErrados;
	}

	public int getAsistencias()
	{
		return asistencias;
	}

	public int getPerdidas()
	{
		return perdidas;
	}

	public int getRebotesAt()
	{
		return rebotesAt;
	}

	public int getRebotesDef()
	{
		return rebotesDef;
	}

	public int getTirosDeCampo()
	{
		return tirosDeCampo;
	}

	public String porcentajeTirosDeCampo()
	{
		return " "+(doblesConvert+triplesConvert)+"/"+tirosDeCampo;
	}
}