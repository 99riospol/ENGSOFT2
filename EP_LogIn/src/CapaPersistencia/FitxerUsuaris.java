package CapaPersistencia;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FitxerUsuaris {
	
	private Properties Usuaris = new Properties();
	private final String NOM_FITXER = "src/CapaPersistencia/BBDD_usuaris.properties";;

	private static FitxerUsuaris instance;
	
	public static synchronized FitxerUsuaris getInstance() {
		if(instance==null) instance=new FitxerUsuaris();
		return instance;
	}

	public FitxerUsuaris(){
		FileInputStream f;
		try {
			f = new FileInputStream(NOM_FITXER);
			Usuaris.load(f);
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public Boolean checkLogIn (String user, String password){
		String UserPassword = Usuaris.getProperty(user);
		return password.equals(UserPassword);
	}
	
	public Boolean checkSignIn (String user){
		if( Usuaris == null) return false;
		String UserPassword = Usuaris.getProperty(user);
		if(UserPassword != null)
			return false;
		return true;
	}
	
	public Boolean addUser( String user, String password ){
		if( checkSignIn(user) )
		{
			Usuaris.setProperty(user, password);
			try {
				FileOutputStream f = new FileOutputStream(NOM_FITXER);
				Usuaris.store(f, "Insert a new user");
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
