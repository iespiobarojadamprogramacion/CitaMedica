package citamedica.Modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AgendaMedica agenda = new AgendaMedica();

        int opcion;

        do {
            System.out.println("\n========== AGENDA MÉDICA ==========");
            System.out.println("1. Área Pacientes");
            System.out.println("2. Área Médicos");
            System.out.println("3. Área Citas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                // ================= PACIENTES =================
                case 1:

                    int opPaciente;
                    do {
                        System.out.println("\n--- Área Pacientes ---");
                        System.out.println("1. Registrar nuevo paciente");
                        System.out.println("2. Consultar todos los pacientes");
                        System.out.println("3. Volver");
                        System.out.print("Opción: ");
                        opPaciente = scanner.nextInt();
                        scanner.nextLine();

                        switch (opPaciente) {

                            case 1:
                                System.out.print("DNI: ");
                                String dni = scanner.nextLine();

                                System.out.print("Nombre completo: ");
                                String nombre = scanner.nextLine();

                                System.out.print("Edad: ");
                                int edad = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Sexo: ");
                                String sexo = scanner.nextLine();

                                System.out.print("Teléfono: ");
                                int telefono = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Especialidad del paciente:");
                                EspecialidadMedica[] especialidades = EspecialidadMedica.values();

                                for (int i = 0; i < especialidades.length; i++) {
                                    System.out.println((i + 1) + ". " + especialidades[i]);
                                }

                                int opEsp = scanner.nextInt() - 1;
                                scanner.nextLine();

                                EspecialidadMedica espPaciente = especialidades[opEsp];

                                Pacientes paciente = new Pacientes(dni, nombre, edad, sexo, telefono, espPaciente);

                                agenda.registrarPaciente(paciente);
                                System.out.println("Paciente registrado.");
                                break;

                            case 2:
                                System.out.println("\n--- LISTA PACIENTES ---");
                                for (Pacientes p : agenda.getPacientes()) {
                                    System.out.println(p);
                                }
                                break;
                        }

                    } while (opPaciente != 3);

                    break;

                // ================= MÉDICOS =================
                case 2:

                    int opMedico;
                    do {
                        System.out.println("\n--- Área Médicos ---");
                        System.out.println("1. Registrar médico");
                        System.out.println("2. Ver médicos");
                        System.out.println("3. Volver");
                        System.out.print("Opción: ");
                        opMedico = scanner.nextInt();
                        scanner.nextLine();

                        switch (opMedico) {

                            case 1:
                                System.out.print("Nombre: ");
                                String nombreMedico = scanner.nextLine();

                                System.out.print("Número colegial: ");
                                String num = scanner.nextLine();

                                System.out.println("Especialidad:");
                                EspecialidadMedica[] esp = EspecialidadMedica.values();

                                for (int i = 0; i < esp.length; i++) {
                                    System.out.println((i + 1) + ". " + esp[i]);
                                }

                                int op = scanner.nextInt() - 1;
                                scanner.nextLine();

                                Medicos medico = new Medicos(nombreMedico, num, esp[op]);

                                agenda.registrarMedico(medico);
                                System.out.println("Médico registrado.");
                                break;

                            case 2:
                                System.out.println("\n--- LISTA MÉDICOS ---");
                                for (Medicos m : agenda.getMedicos()) {
                                    System.out.println(m);
                                }
                                break;
                        }

                    } while (opMedico != 3);

                    break;

                // ================= CITAS =================
                case 3:

                    int opCita;
                    do {
                        System.out.println("\n--- Área Citas ---");
                        System.out.println("1. Crear cita");
                        System.out.println("2. Ver citas");
                        System.out.println("3. Volver");
                        System.out.print("Opción: ");
                        opCita = scanner.nextInt();
                        scanner.nextLine();

                        switch (opCita) {

                            case 1:

                                if (agenda.getPacientes().isEmpty() || agenda.getMedicos().isEmpty()) {
                                    System.out.println("Debe haber pacientes y médicos registrados.");
                                    break;
                                }

                                // PACIENTE
                                System.out.println("\nSeleccione paciente:");
                                for (int i = 0; i < agenda.getPacientes().size(); i++) {
                                    System.out.println((i + 1) + ". " + agenda.getPacientes().get(i));
                                }

                                int iPac = scanner.nextInt() - 1;
                                scanner.nextLine();
                                Pacientes pacienteSel = agenda.getPacientes().get(iPac);

                                // MÉDICOS FILTRADOS
                                ArrayList<Medicos> disponibles = new ArrayList<>();

                                for (Medicos m : agenda.getMedicos()) {
                                    if (m.getEspecialidadMedica() == pacienteSel.getEspecialidadMedica()) {
                                        disponibles.add(m);
                                    }
                                }

                                if (disponibles.isEmpty()) {
                                    System.out.println("No hay médicos para esta especialidad.");
                                    break;
                                }

                                System.out.println("\nMédicos disponibles:");
                                for (int i = 0; i < disponibles.size(); i++) {
                                    System.out.println((i + 1) + ". " + disponibles.get(i));
                                }

                                int iMed = scanner.nextInt() - 1;
                                scanner.nextLine();
                                Medicos medicoSel = disponibles.get(iMed);

                                // DATOS CITA
                                System.out.print("Fecha: ");
                                String fecha = scanner.nextLine();

                                System.out.print("Hora: ");
                                String hora = scanner.nextLine();

                                System.out.println("Tipo de cita:");
                                TipoCita[] tipos = TipoCita.values();

                                for (int i = 0; i < tipos.length; i++) {
                                    System.out.println((i + 1) + ". " + tipos[i]);
                                }

                                int t = scanner.nextInt() - 1;
                                scanner.nextLine();

                                TipoCita tipo = tipos[t];

                                CitaMedica cita = null;

                                switch (tipo) {

                                    case CONSULTA_MEDICA:
                                        cita = new ConsultaMedica(medicoSel, pacienteSel, fecha, hora, tipo, 0);
                                        break;

                                    case CITA_URGENTE:
                                        System.out.print("Nivel urgencia (1-5): ");
                                        int nivel = scanner.nextInt();
                                        scanner.nextLine();

                                        cita = new CitaUrgente(medicoSel, pacienteSel, fecha, hora, tipo, nivel);
                                        break;

                                    case REVISION_MEDICA:
                                        System.out.print("Duración: ");
                                        int dur = scanner.nextInt();
                                        scanner.nextLine();

                                        cita = new RevisionMedica(medicoSel, pacienteSel, fecha, hora, tipo, dur, tipo);
                                        break;
                                }

                                agenda.registrarCita(cita);
                                System.out.println("Cita creada.");
                                break;

                            case 2:
                                System.out.println("\n--- LISTA CITAS ---");
                                for (CitaMedica c : agenda.getCitas()) {
                                    System.out.println(c);
                                }
                                break;
                        }

                    } while (opCita != 3);

                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}