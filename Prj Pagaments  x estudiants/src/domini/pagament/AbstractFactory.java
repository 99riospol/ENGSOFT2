package domini.pagament;

public abstract class AbstractFactory {
	
	public abstract IFuncionalitats crearPagament(double quantitatAPagar);
	
	public static IFuncionalitats getPagament(double quantitatAPagar, String format) {
		try {
			AbstractFactory InstanciaCreadora=(AbstractFactory) Class.forName(format).getDeclaredConstructor().newInstance();
			return InstanciaCreadora.crearPagament(quantitatAPagar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new FactoriaMetallic().crearPagament(quantitatAPagar);
		}
		
	}

	
}
