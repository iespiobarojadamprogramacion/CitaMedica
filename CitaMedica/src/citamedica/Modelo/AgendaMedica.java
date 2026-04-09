package citamedica.Modelo;

import java.util.ArrayList;

public class AgendaMedica {

	static ArrayList<Medicos> listaMedicos = new ArrayList<>();
	static ArrayList<Pacientes> listaPacientes = new ArrayList<>();
	static ArrayList<CitaMedica> listaCitas = new ArrayList<>();
	
	// ================================Citas============================
		// Registrar Citas
	public static void registrarCita(CitaMedica cita) {
	    listaCitas.add(cita);
	    System.out.println("Cita registrada correctamente.");
	}

	public static void todasLasCitas() {
	    for (CitaMedica c : listaCitas) {
	        System.out.println(c.toString());
	    }
	}

	// ================================Pacientes============================
	// Registrar Pacientes
	public static void registrarPaciente(Pacientes paciente) {
		listaPacientes.add(paciente);
		System.out.println("Paciente registrado exitosamente.");
	}

	// Mostrar todos los pacientes
	public static void todosLosPacientes() {
		for (Pacientes p : listaPacientes) {
			System.out.println(p.toString());
		}
	}

	// ================================Medicos============================
	// Registrar Medicos
	public static void registrarMedicos(Medicos medic) {
		listaMedicos.add(medic);
		System.out.println("Medico registrado exitosamente.");
	}

	// Mostrar todos los Medicos
	public static void todosLosMedicos() {
		for (Medicos medic : listaMedicos) {
			System.out.println(medic.toString());
		}
	}
}

