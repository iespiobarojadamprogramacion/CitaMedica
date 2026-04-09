package citamedica.Modelo;

import java.util.ArrayList;

public class AgendaMedica {

    private ArrayList<Medicos> listaMedicos;
    private ArrayList<Pacientes> listaPacientes;
    private ArrayList<CitaMedica> listaCitas;

    public AgendaMedica() {
        listaMedicos = new ArrayList<>();
        listaPacientes = new ArrayList<>();
        listaCitas = new ArrayList<>();
    }

    // ================= PACIENTES =================

    public void registrarPaciente(Pacientes paciente) {
        listaPacientes.add(paciente);
    }

    public ArrayList<Pacientes> getPacientes() {
        return listaPacientes;
    }

    // ================= MÉDICOS =================

    public void registrarMedico(Medicos medico) {
        listaMedicos.add(medico);
    }

    public ArrayList<Medicos> getMedicos() {
        return listaMedicos;
    }

    // ================= CITAS =================

    public void registrarCita(CitaMedica cita) {
        listaCitas.add(cita);
    }

    public ArrayList<CitaMedica> getCitas() {
        return listaCitas;
    }
}
