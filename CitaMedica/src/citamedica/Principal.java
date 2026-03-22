package citamedica;

import java.util.Scanner;
import citamedica.Modelo.AgendaMedica;
import citamedica.Modelo.EspecialidadMedica;
import citamedica.Modelo.Medicos;
import citamedica.Modelo.Pacientes;

public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n========== AGENDA MÉDICA ==========");
			System.out.println("1. Área Pacientes");
			System.out.println("2. Área Médicos");
			System.out.println("3. Salir");
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
				System.out.println("Saliendo del sistema. ¡Hasta luego!");
				break;

			default:
				System.out.println("Opción no válida. Intente de nuevo.");
			}

		} while (opcion != 3);

		scanner.close();

	}
}
