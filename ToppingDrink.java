

public abstract class ToppingDrink  extends Drink {
protected Drink base;
	
	public ToppingDrink(Drink base) {
		this.base = base;
	}
	
	public abstract String getDescription() ;
	
	public double getCost() {
		return base.getCost() + 0.50;
	}


}



class whippedCream extends ToppingDrink {

	public whippedCream(Drink base) {
		super(base);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + "\n---Added: whipped cream";
	}
	
	public void setCost(double cost){
		super.base.setCost(cost);
	}

}


class boba extends ToppingDrink {

	public boba(Drink base) {
		super(base);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + "\n---Added: boba";
	}
	
	public void setCost(double cost){
		super.base.setCost(cost);
	}

}

class poppingBoba extends ToppingDrink {

	public poppingBoba(Drink base) {
		super(base);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + "\n---Added: popping boba";
	}
	
	public void setCost(double cost){
		super.base.setCost(cost);
	}

}

class grassJelly extends ToppingDrink {

	public grassJelly(Drink base) {
		super(base);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + "\n---Added: grassJelly";
	}
	
	public void setCost(double cost){
		super.base.setCost(cost);
	}

}

class lycheeJelly extends ToppingDrink {

	public lycheeJelly(Drink base) {
		super(base);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + "\n---Added: lycheeJelly";
	}
	
	public void setCost(double cost){
		super.base.setCost(cost);
	}

}

class passionFruitJelly extends ToppingDrink {

	public passionFruitJelly(Drink base) {
		super(base);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + "\n---Added: passionFruitJelly";
	}
	
	public void setCost(double cost){
		super.base.setCost(cost);
	}

}

class cocoJelly extends ToppingDrink {

	public cocoJelly(Drink base) {
		super(base);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + "\n---Added: cocoJelly";
	}
	
	public void setCost(double cost){
		super.base.setCost(cost);
	}

}

class strawberry extends ToppingDrink {

	public strawberry(Drink base) {
		super(base);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + "\n---Added: strawberry";
	}
	
	public void setCost(double cost){
		super.base.setCost(cost);
	}

}


