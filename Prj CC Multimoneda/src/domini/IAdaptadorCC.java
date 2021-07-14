package domini;

public interface IAdaptadorCC {
	
	public void ingres(MonedaAbstracta moneda);
	
	public void carrec (MonedaAbstracta moneda);
	
	public double getSaldoEuros();
}
