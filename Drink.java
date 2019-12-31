

public class Drink implements Product {
	protected String name;
	protected String description;
	protected double cost;
	
	SizesSML size;
	milk thisMilk ;
	Sweetness sugar ;
	CoffeeSpecific coffeeSpecificVar;
	TeaSpecific teaSpecificVar;
	AllDrinkSpecific allSpecDrinkVar;
	
	
	public String getDescription() {
		return name +  " - " + size + " - " + thisMilk + " - " + sugar ;
	}
	
	public double getCost() {
		System.out.println("calling -> super getCost");
		return cost;
	}

	@Override
	public void setQuantity(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	///useless: is for pastry quantity
	@Override
	public double getNewCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCost(double i) {
		// TODO Auto-generated method stub
		cost = i;
		System.out.println("super setCost: " + cost);
	}
}
/*
class Coffee extends Drink{

	public Coffee(SizesSML size, milk insertMilk) {
		this.name = "Coffee";
		this.size = size;
		super.cost = 2.00;
		if(insertMilk == null) {
			this.thisMilk = milk.NO_MILK;
		}
		else if((insertMilk == milk.HALF_MILK)){
			this.thisMilk = insertMilk;
			cost += 0.50;
		}
		else if((insertMilk == milk.SOY_MILK)){
			this.thisMilk = insertMilk;
			cost += 0.75;
		}
	}
	
	public double getCost() {
		System.out.println("calling ---> coffee getCost" + super.cost);
		switch(this.size) {
			case S:
				return 0.10 + cost;
			case M:
				return 0.25 + cost;
			case L:
				return 0.50 + cost;
		}
		return 0;
	}

}*/

class Coffee extends Drink{
	double milkPrice;
	public Coffee(SizesSML size, milk insertMilk, Sweetness optionSugar, CoffeeSpecific specDrink) {
		System.out.println("Coffee new constructor  insertmilk -> " + insertMilk);
		super.name = "Coffee";
		super.size = size;
		//super.cost = 2.00;
		if(insertMilk == milk.NO_MILK) {
			System.out.println("Coffee class chekc milk");
			super.thisMilk = milk.NO_MILK;
			milkPrice = 0;
		}
		else if((insertMilk == milk.HALF_MILK)){
			System.out.println("Coffee class chekc milk");
			super.thisMilk = insertMilk;
			milkPrice = 0.25;
		}
		else if((insertMilk == milk.SOY_MILK)){
			System.out.println("Coffee class chekc milk");
			super.thisMilk = insertMilk;
			milkPrice = 0.50;
		}
		
		super.sugar = optionSugar;
		super.coffeeSpecificVar = specDrink;
	}
	
	public String getDescription() {
		return name +  " - " + coffeeSpecificVar + " - " + size + " - " + thisMilk + " - " + sugar ;
	}
	
	
	public double getCost() {
		System.out.println("calling ---> coffee getCost (set by size, before topping/milk) " + super.cost);
		
			return super.cost + milkPrice;
		
	}

}


class Tea extends Drink{
	double milkPrice;
	public Tea(SizesSML size, milk insertMilk, Sweetness insertSweet, TeaSpecific specDrink) {
		super.name = "Tea";
		super.size = size;
		//super.cost = 2.00;
		
		if(insertMilk == milk.NO_MILK) {
			super.thisMilk = milk.NO_MILK;
			milkPrice = 0;
		}
		else if((insertMilk == milk.HALF_MILK)){
			super.thisMilk = insertMilk;
			milkPrice = 0.25;
		}
		else if((insertMilk == milk.SOY_MILK)){
			System.out.println("---milk soy    teaaaaaaaaaa");
			super.thisMilk = insertMilk;
			milkPrice = 0.50;
		}
		
		super.sugar = insertSweet;
		super.teaSpecificVar = specDrink;
	}
	
	public String getDescription() {
		return name +  " - " + teaSpecificVar + " - " + size + " - " + thisMilk + " - " + sugar ;
	}
	
	public double getCost() {
		System.out.println("calling ---> tea getCost (cost set by size, before topping/milk): " + super.cost);
		return super.cost + milkPrice;
		
	}
}

class nonDrink extends Drink{
	public nonDrink() {
		this.name = "non drink";
		
	}
	public double getCost() {
		return 0;
	}

}

