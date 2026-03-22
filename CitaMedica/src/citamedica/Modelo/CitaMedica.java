package citamedica.Modelo;

public class CitaMedica {
	private Medicos medicos;
	private Pacientes pacientes;
	private String fecha;
	private String hora;
	TipoCita tipoCita;

	public CitaMedica(Medicos medicos, Pacientes pacientes, String fecha, String hora, TipoCita tipoCita) {
		super();
		this.medicos = medicos;
		this.pacientes = pacientes;
		this.fecha = fecha;
		this.hora = hora;
		this.tipoCita = tipoCita;
	}

	public Medicos getMedicos() {
		return medicos;
	}

	public void setMedicos(Medicos medicos) {
		this.medicos = medicos;
	}

	public Pacientes getPacientes() {
		return pacientes;
	}

	public void setPacientes(Pacientes pacientes) {
		this.pacientes = pacientes;
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

	@Override
	public String toString() {
		return "CitaMedica [medicos=" + medicos + ", pacientes=" + pacientes + ", fecha=" + fecha + ", hora=" + hora
				+ ", tipoCita=" + tipoCita + "]";
	}
}
