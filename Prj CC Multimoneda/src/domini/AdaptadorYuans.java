package domini;

import persistencia.FitxerPropietatsSistema;

public class AdaptadorYuans implements IConversio{

	private CompteCorrentEuros cce;
	private double canvi;
	
	public AdaptadorYuans(CompteCorrentEuros cce) {
		this.cce=cce;
		FitxerPropietatsSistema.getInstance();
		canvi=Double.parseDouble(System.getProperty("canviYuan"));
	}

	@Override
	public void ingres(MonedaAbstracta m) {
		Euros e=new Euros(m.getQuantitat()*canvi);
		cce.ingres(e);
	}

	@Override
	public void carrec(MonedaAbstracta m) {
		Euros e=new Euros(m.getQuantitat()*canvi);
		cce.carrec(e);
	}

	@Override
	public double getSaldoEuros() {
		return cce.getSaldoEuros();
	}
}
