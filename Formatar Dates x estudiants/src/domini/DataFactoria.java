package domini;

import domini.estrategia.FormatDDMMAA;
import domini.estrategia.IEstrategia;

public class DataFactoria {
	
	public static DataFactoria instancia=null;
	private IEstrategia ex;
	
	public static synchronized DataFactoria getInstancia() {
		if(instancia==null) instancia =new DataFactoria();
		return instancia;
	}
	
	public IEstrategia getEstrategia(String tipo) {
		try {
			Class<?>res=Class.forName("domini.estrategia."+tipo);
			return this.ex=(IEstrategia) res.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return this.ex=new FormatDDMMAA();
		}
	}
}
