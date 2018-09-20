
public class Mappa implements ISupervisore {

	private int maxX;
	private int minX;
	private int maxY;
	private int minY;
	PuntoXY obiettivo;
	 
	public Mappa(int minX, int maxX, int minY, int maxY, PuntoXY obiettivo) {
		if(minX>maxX || minY>maxY) 
			throw new RobotException();
			else {
				this.maxX = maxX;
				this.minX = minX;
				this.maxY = maxY;
				this.minY = minY;
			}
		if(obiettivo==null || !this.posizioneValida(obiettivo))
			throw new RobotException();
		else 
			this.obiettivo = obiettivo;
	}

	@Override
	public boolean posizioneValida(PuntoXY posizione) {
		if(posizione.getX()>maxX || posizione.getX()<minX)
			return false;
		if( posizione.getY()>maxY || posizione.getY()<minY)
			return false;
		else 
			return true;
	}

	@Override
	public boolean obiettivoRaggiunto(PuntoXY posizione) {
		return(posizione.equals(obiettivo));
	}
	
	
}