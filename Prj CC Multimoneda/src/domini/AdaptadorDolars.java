package domini;

import persistencia.FitxerPropietatsSistema;

public class AdaptadorDolars implements IConversio {
	private CompteCorrentEuros cce;
	private double canvi;
	
	public AdaptadorDolars(CompteCorrentEuros cce) {
		this.cce=cce;
		FitxerPropietatsSistema.getInstance();
		canvi=Double.parseDouble(System.getProperty("canviDolar"));
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
