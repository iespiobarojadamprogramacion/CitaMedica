package citamedica.Modelo;

import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
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

			case 1:
				int opPaciente;
				do {
					System.out.println("\n--- Área Pacientes ---");
					System.out.println("1. Registrar nuevo paciente");
					System.out.println("2. Consultar todos los pacientes");
					System.out.println("3. Volver al menú principal");
					System.out.print("Seleccione una opción: ");
					opPaciente = scanner.nextInt();
					scanner.nextLine();

					switch (opPaciente) {
					case 1:
						System.out.print("DNI: ");
						String dni = scanner.nextLine();

						System.out.print("Nombre completo: ");
						String nombreCompleto = scanner.nextLine();

						System.out.print("Edad: ");
						int edad = scanner.nextInt();
						scanner.nextLine();

						System.out.print("Sexo: ");
						String sexo = scanner.nextLine();

						System.out.print("Teléfono: ");
						int telefono = scanner.nextInt();
						scanner.nextLine();

						Pacientes paciente = new Pacientes(dni, nombreCompleto, edad, sexo, telefono);
						AgendaMedica.registrarPaciente(paciente);
						break;

					case 2:
						System.out.println("\n--- Lista de Pacientes ---");
						AgendaMedica.todosLosPacientes();
						break;

					case 3:
						System.out.println("Volviendo al menú principal...");
						break;

					default:
						System.out.println("Opción no válida.");
					}

				} while (opPaciente != 3);
				break;

			case 2:
				int opMedico;
				do {
					System.out.println("\n--- Área Médicos ---");
					System.out.println("1. Registrar nuevo médico");
					System.out.println("2. Consultar todos los médicos");
					System.out.println("3. Volver al menú principal");
					System.out.print("Seleccione una opción: ");
					opMedico = scanner.nextInt();
					scanner.nextLine();

					switch (opMedico) {
					case 1:
						System.out.print("Nombre completo: ");
						String nombreMedico = scanner.nextLine();

						System.out.print("Número colegial: ");
						String numeroColegial = scanner.nextLine();

						System.out.println("Especialidad médica:");
						EspecialidadMedica[] especialidades = EspecialidadMedica.values();
						for (int i = 0; i < especialidades.length; i++) {
							System.out.println((i + 1) + ". " + especialidades[i]);
						}
						System.out.print("Seleccione una opción: ");
						int opEspecialidad = scanner.nextInt();
						scanner.nextLine();
						EspecialidadMedica especialidad = especialidades[opEspecialidad - 1];

						Medicos medico = new Medicos(nombreMedico, numeroColegial, especialidad);
						AgendaMedica.registrarMedicos(medico);
						break;

					case 2:
						System.out.println("\n--- Lista de Médicos ---");
						AgendaMedica.todosLosMedicos();
						break;

					case 3:
						System.out.println("Volviendo al menú principal...");
						break;

					default:
						System.out.println("Opción no válida.");
					}

				} while (opMedico != 3);
				break;

			case 3:
			    int opCita;
			    do {
			        System.out.println("\n--- Área Citas ---");
			        System.out.println("1. Crear nueva cita");
			        System.out.println("2. Ver todas las citas");
			        System.out.println("3. Volver al menú principal");
			        System.out.print("Seleccione una opción: ");
			        opCita = scanner.nextInt();
			        scanner.nextLine();

			        switch (opCita) {

			        case 1:
			            if (AgendaMedica.listaMedicos.isEmpty() || AgendaMedica.listaPacientes.isEmpty()) {
			                System.out.println("Debe haber al menos un médico y un paciente registrados.");
			                break;
			            }

			            // Seleccionar paciente
			            System.out.println("\nSeleccione paciente:");
			            for (int i = 0; i < AgendaMedica.listaPacientes.size(); i++) {
			                System.out.println((i + 1) + ". " + AgendaMedica.listaPacientes.get(i));
			            }
			            int indexPaciente = scanner.nextInt() - 1;
			            scanner.nextLine();
			            Pacientes paciente = AgendaMedica.listaPacientes.get(indexPaciente);

			            // Seleccionar médico
			            System.out.println("\nSeleccione médico:");
			            for (int i = 0; i < AgendaMedica.listaMedicos.size(); i++) {
			                System.out.println((i + 1) + ". " + AgendaMedica.listaMedicos.get(i));
			            }
			            int indexMedico = scanner.nextInt() - 1;
			            scanner.nextLine();
			            Medicos medico = AgendaMedica.listaMedicos.get(indexMedico);

			            // Datos comunes
			            System.out.print("Fecha: ");
			            String fecha = scanner.nextLine();

			            System.out.print("Hora: ");
			            String hora = scanner.nextLine();

			            // Tipo de cita
			            System.out.println("Tipo de cita:");
			            TipoCita[] tipos = TipoCita.values();
			            for (int i = 0; i < tipos.length; i++) {
			                System.out.println((i + 1) + ". " + tipos[i]);
			            }
			            int tipoSeleccionado = scanner.nextInt() - 1;
			            scanner.nextLine();

			            TipoCita tipo = tipos[tipoSeleccionado];

			            CitaMedica cita = null;

			            switch (tipo) {

			            case CONSULTA_MEDICA:
			                cita = new CitaMedica(medico, paciente, fecha, hora, tipo);
			                break;

			            case CITA_URGENTE:
			                System.out.print("Nivel de urgencia (1-5): ");
			                // Con mas alto sea el numero, mas urgente es
			                int nivel = scanner.nextInt();
			                scanner.nextLine();
			                cita = new CitaUrgente(medico, paciente, fecha, hora, tipo, nivel);
			                break;

			            case REVISION_MEDICA:
			                System.out.print("Duración (minutos): ");
			                int duracion = scanner.nextInt();
			                scanner.nextLine();

			                System.out.println("Tipo de cita anterior:");
			                for (int i = 0; i < tipos.length; i++) {
			                    System.out.println((i + 1) + ". " + tipos[i]);
			                }
			                int anterior = scanner.nextInt() - 1;
			                scanner.nextLine();

			                cita = new RevisionMedica(medico, paciente, fecha, hora, tipo, duracion, tipos[anterior]);
			                break;
			            }

			            AgendaMedica.registrarCita(cita);
			            break;

			        case 2:
			            System.out.println("\n--- Lista de Citas ---");
			            AgendaMedica.todasLasCitas();
			            break;

			        case 3:
			            System.out.println("Volviendo al menú principal...");
			            break;

			        default:
			            System.out.println("Opción no válida.");
			        }

			    } while (opCita != 3);
			    break;
			case 4:
			    System.out.println("Saliendo del sistema. ¡Hasta luego!");
			    break;
				
			default:
				System.out.println("Opción no válida. Intente de nuevo.");
			}

		} while (opcion != 4);

		scanner.close();
	}
}