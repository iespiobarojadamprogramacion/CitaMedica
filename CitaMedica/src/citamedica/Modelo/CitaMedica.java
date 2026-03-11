package citamedica.Modelo;

public class CitaMedica {
	private String fecha;
	private String hora;
	TipoCita tipoCita;
	public CitaMedica(String fecha, String hora, TipoCita tipoCita) {
		
		this.fecha = fecha;
		this.hora = hora;
		this.tipoCita = tipoCita;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public TipoCita getTipoCita() {
		return tipoCita;
	}
	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}
	@Override
	public String toString() {
		return "CitaMedica [fecha=" + fecha + ", hora=" + hora + ", tipoCita=" + tipoCita + ", toString()="
				+ super.toString() + "]";
	}
	
}
