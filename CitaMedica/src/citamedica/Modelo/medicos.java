package citamedica.Modelo;

public class medicos {
	
	public String nombreCompleto;
	public String numeroColegial;
	public EspecialidadMedica especialidadMedica;
	
	public medicos(String nombreCompleto, String numeroColegial, EspecialidadMedica especialidadMedica) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.numeroColegial = numeroColegial;
		this.especialidadMedica = especialidadMedica;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getNumeroColegial() {
		return numeroColegial;
	}

	public void setNumeroColegial(String numeroColegial) {
		this.numeroColegial = numeroColegial;
	}

	public EspecialidadMedica getEspecialidadMedica() {
		return especialidadMedica;
	}

	public void setEspecialidadMedica(EspecialidadMedica especialidadMedica) {
		this.especialidadMedica = especialidadMedica;
	}

	@Override
	public String toString() {
		return "medicos [nombreCompleto=" + nombreCompleto + ", numeroColegial=" + numeroColegial
				+ ", especialidadMedica=" + especialidadMedica + "]";
	}
	
	
}
