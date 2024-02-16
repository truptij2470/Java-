package core;

public enum Colors {
	WHITE(5000), BLACK(10000), GREY(6500), SILVER(8000);
	
	private int additionalCost;
	
	private Colors(int additionalCost) {
		
		this.additionalCost = additionalCost;
	}
	
	public int getAdditionalCost() {
		return additionalCost;
	}
	public void setAdditionalCost(int additionalCost) {
		this.additionalCost = additionalCost;
	}
	
	@Override
	public String toString()
	{
		return name()+" with additional cost "+additionalCost;
	}
}
