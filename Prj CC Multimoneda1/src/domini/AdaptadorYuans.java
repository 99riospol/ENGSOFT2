package domini;

import persistencia.FitxerPropietatsSistema;

public class AdaptadorYuans implements IAdaptadorCC {//Adaptador

	private CompteCorrentEuros cce;
	private double canvi;
	
	public AdaptadorYuans(CompteCorrentEuros cc) {
		this.cce=cc;
		FitxerPropietatsSistema.getInstance(); //tenim les propietats carregades
		canvi = Double.parseDouble(System.getProperty("canviYuan"));
	}
	 
	@Override
	public void ingres(MonedaAbstracta moneda) {
		Euros e = new Euros(moneda.getQuantitat() * canvi);	
		cce.ingres(e);
	}

	@Override
	public void carrec(MonedaAbstracta moneda) {
		Euros e = new Euros(moneda.getQuantitat() * canvi);	
		cce.carrec(e);		
	}

	@Override
	public double getSaldoEuros() {
		return cce.getSaldoEuros();
	}

}
