package presentacio;

import domini.pagament.Metallic;
import domini.pagament.TargetaDeCredit;
import domini.pagament.IFuncionalitats;
import persistencia.TPV;

public class ProvarPagament {

	public static void main(String[] args) {
		double quantitat = 120.50;
		
		try {
			IFuncionalitats pagament= domini.pagament.AbstractFactory.getPagament(quantitat, "FactoriaMetallic");
	
			pagament.quantitatLliurada(130);
			System.out.println("El canvi és de : " + pagament.quantitatDeCanvi());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String dadesTarjeta = TPV.llegirDadesTarjeta();
			IFuncionalitats pagament=domini.pagament.AbstractFactory.getPagament(quantitat, "FactoriaMetallic");
			if (pagament.quantitatDeCanvi() < 0)
				System.out.println("Error en la transacció del pagament amb tarjeta de crèdit.");
			else
				System.out.println("Pagment amb tarjeta de crèdit ok.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}