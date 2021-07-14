package domini;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import CapaPersistencia.FitxerUsuaris;

class TestinFitxerUsuaris {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void CheckLoginCorrectLogin() {
		
		FitxerUsuaris file = FitxerUsuaris.getInstance();
		file.checkLogIn("admin", "admin");
		assertEquals(file.checkLogIn("admin", "admin"), file.checkLogIn("admin", "admin"));
	}
	
	@Test
	public void CheckLoginIncorrectLogin() {
		
		FitxerUsuaris file = FitxerUsuaris.getInstance();
		boolean expected = file.checkLogIn("admin1", "admin1");
		assertEquals(expected, false);
	}
	
	@Test
	public void AddExistingUser() {
		
		FitxerUsuaris file = FitxerUsuaris.getInstance();
		boolean expected = file.addUser("admin", "admin");
		assertEquals(expected, false);
	}
	
	@Test 
	public void AddNewUser() {
		
		FitxerUsuaris file = FitxerUsuaris.getInstance();
		boolean expected = file.addUser("admin1", "admin1");
		assertEquals(expected, true);
	}

}
