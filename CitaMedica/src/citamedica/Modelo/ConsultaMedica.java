package citamedica.Modelo;



public class ConsultaMedica extends CitaMedica {
	private int duracion;

	public ConsultaMedica(String fecha, String hora, TipoCita tipoCita, int duracion) {
		super(fecha, hora, tipoCita);
		this.duracion = duracion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "ConsultaMedica [duracion=" + duracion + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
