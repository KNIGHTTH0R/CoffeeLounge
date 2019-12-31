

public class Pastry implements Product {
	String name;
	String description;
	double cost;
	
	int quantity;
	
	//SizesSML size;
	PastryTypeIngredient ingred;
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return name + " -- " + ingred + " -- " + description + " -- " + quantity;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public void setQuantity(int i) {
		// TODO Auto-generated method stub
		this.quantity = i;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}

	@Override
	public double getNewCost() {
		// TODO Auto-generated method stub
		return 0 ;
	}

	@Override
	public void setCost(double i) {
		// TODO Auto-generated method stub
		cost = i;
	}

}

class Crossaint extends Pastry {
	double heatPrice;
	public Crossaint(PastryTypeIngredient option3, Object quantity2, Object heating) {
		super.cost = 2;
		super.name = "Crossaint";
		super.description = (String) heating;
		//this.size = size;
		super.ingred = option3;
		super.quantity = (int) quantity2;
		if (heating.equals("yesHeat")) {
			heatPrice = 0.50;
		}
	}

	
	public double getCost() {
		System.out.println("calling -> getCost Croissant");
		return super.cost * super.quantity + heatPrice;
	}

}

class Cookie extends Pastry {
	public Cookie(PastryTypeIngredient option3, Object quantity2) {
		super.name = "Cookie ";
		super.description = "cookie decsrip";
		super.ingred = option3;
		super.quantity = (int) quantity2;
	}
	@Override
	public double getCost() {
		System.out.println("calling -> getCost Cookie");
			int remainder = super.quantity % 3;
			int batchesOfThree = super.quantity / 3;
	
			double indiv = remainder * 1.50;
			double batches = batchesOfThree * 3.00;
			
			return indiv + batches;
			
	}
	
	
}

class Macaroon extends Pastry {
	public Macaroon(PastryTypeIngredient option3, Object quantity2) {
		super.name = "Macaroon";
		super.description = "Macaroon decsrip";
		super.ingred = option3;
		super.quantity = (int) quantity2;
	}
	@Override
	public double getCost() {
		System.out.println("calling -> getCost Maccaroon");
		int remainder = super.quantity % 6;
		int batchesOfSix = super.quantity / 6;

		double indiv = remainder * 2.00;
		double batches = batchesOfSix * 9.00;
		
		return indiv + batches;
	}
	
}

class nonPastry extends Pastry {
	public nonPastry() {
		super.name = "Macaroon";
		super.description = "Macaroon decsrip";
	}
	@Override
	public double getCost() {
		
		return 0;
	}
	
	public double getNewCost() {
		
		return 0;
	}
}

