package persistencia;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

public class FitxerPropietatsSistema {

	private final String FITXER_CONFIGURACIO = "FitxerConfiguracio.properties";
	//private static boolean fitxerCarregat = false;
	private static FitxerPropietatsSistema instance;
	
	public static synchronized FitxerPropietatsSistema getInstance() {
		if(instance==null) instance=new FitxerPropietatsSistema();
		return instance;
	}
	
	
	private FitxerPropietatsSistema() {
		/*if (!fitxerCarregat) {
			fitxerCarregat = true;*/
			try {
				// Obrirel fitxer de propietats
				FileInputStream f = new FileInputStream(FITXER_CONFIGURACIO);
				// crear un nou obj amb les propietats actuals del sistema
				Properties propietats = new Properties(System.getProperties());
				propietats.load(f);// Afegir les propietats del fitxer extern
				f.close();
				// Carregar totes les propietats en el Sistema
				Set<?> clausPropietats = propietats.keySet();
				for (Object clau : clausPropietats) {
					String valor = propietats.getProperty((String) clau);
					System.setProperty((String) clau, valor);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
	//}
}