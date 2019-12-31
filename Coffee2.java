/*
class Coffee2 extends Drink{

	public Coffee2(SizesSML size, milk insertMilk) {
		super.name = "Coffee";
		super.size = size;
		super.cost = 2.00;
		if(insertMilk == null) {
			super.thisMilk = milk.NO_MILK;
		}
		else if((insertMilk == milk.HALF_MILK)){
			super.thisMilk = insertMilk;
			super.cost += 0.50;
		}
		else if((insertMilk == milk.SOY_MILK)){
			super.thisMilk = insertMilk;
			super.cost += 0.75;
		}
	}
	
	
	public double getCost() {
		System.out.println("calling ---> coffee getCost (before size) " + super.cost);
		switch(this.size) {
			case S:
				return 0.10 + super.cost;
			case M:
				return 0.25 + super.cost;
			case L:
				return 0.50 + super.cost;
		}
		return 0;
	}

}
*/