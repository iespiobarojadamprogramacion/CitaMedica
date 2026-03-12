package citamedica.Modelo;
public class RevisionMedica  extends CitaMedica{
	private int duracion;
	private TipoCita citaAnterior;
	public RevisionMedica(Medicos medicos, Pacientes pacientes, String fecha, String hora, TipoCita tipoCita,
			int duracion, TipoCita citaAnterior) {
		super(medicos, pacientes, fecha, hora, tipoCita);
		this.duracion = duracion;
		this.citaAnterior = citaAnterior;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public TipoCita getCitaAnterior() {
		return citaAnterior;
	}
	public void setCitaAnterior(TipoCita citaAnterior) {
		this.citaAnterior = citaAnterior;
	}
	@Override
	public String toString() {
		return "RevisionMedica [duracion=" + duracion + ", citaAnterior=" + citaAnterior + ", toString()="
				+ super.toString() + "]";
	}
	
}
