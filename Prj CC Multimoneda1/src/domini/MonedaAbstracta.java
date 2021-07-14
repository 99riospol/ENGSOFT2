package domini;

public class MonedaAbstracta {

	private double quantitat;
	
	public MonedaAbstracta (double quantitat)  {
		this.quantitat = quantitat;
	}
	
	public double getQuantitat() {
		return quantitat;
	}	

	public void setQuantitat(double quantitat) {
		this.quantitat = quantitat;		
	}

	public boolean esPositiu() {
		return quantitat > 0.0d;
	}
}