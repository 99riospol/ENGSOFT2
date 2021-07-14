package domini;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import persistencia.FitxerPropietatsSistema;


public class TetingCompteCorrentAdaptador {
	
	private CompteCorrentEuros cce;
	
	@Before
	public void setUp() throws Exception {
		cce=new CompteCorrentEuros();
		FitxerPropietatsSistema.getInstance();
	}

	@Test
	public void testEuros() {		
		//PENDENT D'IMPLEMENTAR
		cce.ingres(new Euros(30.0d));
		cce.carrec(new Euros(10.0d));
		double resultatObtingut = cce.getSaldoEuros();
		double resultatEsperat = 20.0d;
		assertEquals(resultatEsperat, resultatObtingut, 0.001d);
	}
	
	@Test
	public void testDolars() {	
		//PENDENT D'IMPLEMENTAR
		IConversio res=new AdaptadorDolars(cce);
		Dolars d=new Dolars (11.0d);
		res.ingres(d);
		d=new Dolars(1.0d);
		res.carrec(d);
		
		double resultatObtingut = cce.getSaldoEuros();		
		double resultatEsperat = 10.0 * Double.parseDouble(System.getProperty("canviDolar"));
		assertEquals(resultatEsperat, resultatObtingut, 0.001d);
	}
	
	@Test
	public void testYuans() {	
		//PENDENT D'IMPLEMENTAR
		IConversio res=new AdaptadorYuans(cce);
		Yuans d=new Yuans (11.0d);
		res.ingres(d);
		d=new Yuans(1.0d);
		res.carrec(d);
		
		double resultatObtingut = cce.getSaldoEuros();	
		double resultatEsperat = 10.0 * Double.parseDouble(System.getProperty("canviYuan"));
		assertEquals(resultatEsperat, resultatObtingut, 0.001d);
	}
}