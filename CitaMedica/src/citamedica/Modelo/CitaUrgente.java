package citamedica.Modelo;

public class CitaUrgente  extends CitaMedica{
	private int nivelUrgencia;

	public CitaUrgente(Medicos medicos, Pacientes pacientes, String fecha, String hora, TipoCita tipoCita,
			int nivelUrgencia) {
		super(medicos, pacientes, fecha, hora, tipoCita);
		this.nivelUrgencia = nivelUrgencia;
	}

	public int getNivelUrgencia() {
		return nivelUrgencia;
	}

	public void setNivelUrgencia(int nivelUrgencia) {
		this.nivelUrgencia = nivelUrgencia;
	}

	@Override
	public String toString() {
		return "CitaUrgente [nivelUrgencia=" + nivelUrgencia + ", toString()=" + super.toString() + "]";
	}

	
}
