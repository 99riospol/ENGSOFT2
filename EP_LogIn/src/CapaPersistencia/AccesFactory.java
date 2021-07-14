package CapaPersistencia;

import CapaPresentacio.IType;
import CapaPresentacio.LoginFrame;

public class AccesFactory {
	
	public static AccesFactory instancia=null;
	private IType tipus;
	
	public static synchronized AccesFactory getInstancia() {
		if(instancia==null) instancia =new AccesFactory();
		return instancia;
	}
	
	public IType getAccess(String format) {
		try {
			Class<?>res=Class.forName("CapaPresentacio."+format);
			return this.tipus=(IType) res.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return this.tipus=new LoginFrame();
		}
	}
}
