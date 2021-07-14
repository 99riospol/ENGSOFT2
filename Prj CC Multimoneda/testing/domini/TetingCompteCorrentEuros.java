package domini;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import persistencia.FitxerPropietatsSistema;

public class TetingCompteCorrentEuros {
	
	private CompteCorrentEuros cc;
	private double canviDolars, canviYuans;

	@Before
	public void setUp() throws Exception {
		FitxerPropietatsSistema.getInstance();
		canviDolars = Double.parseDouble(System.getProperty("canviDolar"));
		canviYuans = Double.parseDouble(System.getProperty("canviYuan"));
		cc = new CompteCorrentEuros();
	}

	@Test
	public void testEuros() {		
		cc.ingres(new Euros(30.0d));
		cc.carrec(new Euros(10.0d));
		double resultatObtingut = cc.getSaldoEuros();
		double resultatEsperat = 20.0d;
		assertEquals(resultatEsperat, resultatObtingut, 0.001d);
	}
	
	@Test
	public void testDolars() {	
		Dolars d = new Dolars(11.0d);
		Euros e = new Euros (d.getQuantitat() * canviDolars);
		cc.ingres(e);
		
		d = new Dolars(1.0d);
		e = new Euros (d.getQuantitat() * canviDolars);
		cc.carrec(e);
		
		double resultatObtingut = cc.getSaldoEuros();		
		double resultatEsperat = 10.0 *canviDolars;
		assertEquals(resultatEsperat, resultatObtingut, 0.001d);	
	}
	
	@Test
	public void testYuans() {	
		Yuans d = new Yuans(11.0d);
		Euros e = new Euros (d.getQuantitat() * canviYuans);
		cc.ingres(e);
		
		d = new Yuans(1.0d);
		e = new Euros (d.getQuantitat() * canviYuans);
		cc.carrec(e);
		
		double resultatObtingut = cc.getSaldoEuros();
		double resultatEsperat = 10d * canviYuans;
		assertEquals(resultatEsperat, resultatObtingut, 0.001d);	
	}
}