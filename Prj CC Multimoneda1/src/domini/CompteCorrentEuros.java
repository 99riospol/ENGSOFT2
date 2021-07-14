package domini;

public class CompteCorrentEuros { //adaptable
	
	private Euros saldo;
	
	public CompteCorrentEuros () {
		saldo = new Euros ();
	}
	
	public void ingres (Euros moneda) {
		if (moneda.esPositiu()) {
			saldo.setQuantitat(saldo.getQuantitat() + moneda.getQuantitat());
		}
	}
	
	public void carrec (Euros moneda) {
		if (moneda.esPositiu()) {
			saldo.setQuantitat(saldo.getQuantitat() - moneda.getQuantitat());
		}
	}
	
	public double getSaldoEuros () {
		return saldo.getQuantitat();
	}
}