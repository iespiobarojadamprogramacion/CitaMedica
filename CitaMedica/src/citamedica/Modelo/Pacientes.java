package citamedica.Modelo;

public class Pacientes {
	private String dni;
	private String nombreCompleto;
	private int edad;
	private String sexo;
	private int telefono;

	public Pacientes(String dni, String nombreCompleto, int edad, String sexo, int telefono) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.sexo = sexo;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Pacientes [dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", edad=" + edad + ", sexo=" + sexo
				+ ", telefono=" + telefono + "]";
	}

}
