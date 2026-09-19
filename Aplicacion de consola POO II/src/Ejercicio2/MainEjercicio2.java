package Ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class MainEjercicio2 {

	public static void main(String[] args) {		
		ArrayList<Edificio> listaEdificios = new ArrayList<Edificio>();
		
		// 1. Carga manual de Polideportivos
		int itera = 0;
		String inputItera = JOptionPane.showInputDialog("Ingrese la cantidad de polideportivos a agregar:");
		if (inputItera == null) {
			JOptionPane.showMessageDialog(null, "Operación cancelada. Finalizando programa.");
			return; // Termina la ejecución del programa
		}
		
		boolean esValido = false;
		while (!esValido) {
			try {
				itera = Integer.parseInt(inputItera.trim());
				esValido = true; 
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
				inputItera = JOptionPane.showInputDialog("Reingrese la cantidad de polideportivos a agregar:");
				if (inputItera == null) {
					JOptionPane.showMessageDialog(null, "Operación cancelada. Finalizando programa.");
					return;
				}
			}
		}
		
		for (int i = 0; i < itera; i++) {
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del polideportivo " + (i + 1) + ":");
			if (nombre == null) {
				JOptionPane.showMessageDialog(null, "Carga cancelada.");
				return;
			}
			
			String inputSuperficie = JOptionPane.showInputDialog("Ingrese la superficie del polideportivo " + (i + 1) + ":");
			if (inputSuperficie == null) {
				JOptionPane.showMessageDialog(null, "Carga cancelada.");
				return;
			}
			double superficie = 0;
			try {
				superficie = Double.parseDouble(inputSuperficie.trim());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Superficie inválida. Se asignará 0 por defecto.");
			}
			
			String inputTipo = JOptionPane.showInputDialog("Ingrese el Tipo de polideportivo " + (i + 1) + ":");
			if (inputTipo == null) {
				JOptionPane.showMessageDialog(null, "Carga cancelada.");
				return;
			}
			int tipo = 0;
			try {
				tipo = Integer.parseInt(inputTipo.trim());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Tipo inválido. Se asignará 0 por defecto.");
			}
			
			listaEdificios.add(new Polideportivo(nombre, superficie, tipo));
		}
		
		// 2. Carga manual de Edificios de Oficinas
		itera = 0;
		String inputIteraOfi = JOptionPane.showInputDialog("Ingrese la cantidad de Edificios de Oficina a agregar:");
		if (inputIteraOfi == null) {
			JOptionPane.showMessageDialog(null, "Carga de oficinas cancelada.");
			return;
		}
		
		boolean esValidoOfi = false;
		while (!esValidoOfi) {
			try {
				itera = Integer.parseInt(inputIteraOfi.trim());
				esValidoOfi = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
				inputIteraOfi = JOptionPane.showInputDialog("Reingrese la cantidad de Edificios de Oficina a agregar:");
				if (inputIteraOfi == null) {
					JOptionPane.showMessageDialog(null, "Carga cancelada.");
					return;
				}
			}
		}
		
		for (int i = 0; i < itera; i++) {
			String inputSuperficie = JOptionPane.showInputDialog("Ingrese la superficie del edificio de oficinas " + (i + 1) + ":");
			if (inputSuperficie == null) {
				JOptionPane.showMessageDialog(null, "Carga cancelada.");
				return;
			}
			double superficie = 0;
			try {
				superficie = Double.parseDouble(inputSuperficie.trim());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Superficie inválida. Se asignará 0 por defecto.");
			}
			
			String inputOficinas = JOptionPane.showInputDialog("Ingrese la cantidad de oficinas del edificio " + (i + 1) + ":");
			if (inputOficinas == null) {
				JOptionPane.showMessageDialog(null, "Carga cancelada.");
				return;
			}
			int oficinas = 0;
			try {
				oficinas = Integer.parseInt(inputOficinas.trim());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Cantidad inválida. Se asignará 0 por defecto.");
			}
			
			listaEdificios.add(new EdificioOficinas(superficie, oficinas));
		}
		
		// 3. Recorrido de la lista
		Iterator<Edificio> iterator = listaEdificios.iterator();
		
		while(iterator.hasNext()) {
			Edificio edificio = iterator.next();
			System.out.println("----------------------------------------");

			if(edificio instanceof Polideportivo) {
				Polideportivo polideportivo = (Polideportivo) edificio;
				
				System.out.println("------------ Polideportivo ------------");
				System.out.println("Nombre: " + polideportivo.getNombre());
				System.out.println("Superficie: " + polideportivo.getSuperficieEdificio());
				System.out.println("Tipo de instalacion: " + polideportivo.getTipoDeInstalacion());				
			}
			
			if(edificio instanceof EdificioOficinas) {
				EdificioOficinas edificioOficinas = (EdificioOficinas) edificio;

				System.out.println("------------ Edificio de Oficinas ------------");
				System.out.println("Superficie: " + edificioOficinas.getSuperficieEdificio());
				System.out.println("Numero de oficinas: " + edificioOficinas.getNumeroOficinas());
			}
			
			System.out.println("----------------------------------------");
		}
	}
}