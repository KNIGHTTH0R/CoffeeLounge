
import java.util.ArrayList;

public abstract class ProductFactory {

	public abstract Product createProduct(Object type, Object optionA, Object optionB, Object optionC, Object optionD, Object optionE) ;
}


class DrinkFactory extends ProductFactory{
	
	@Override																						//null for coffee
	public Product createProduct(Object type, Object size, Object optionMilk, Object insertTopping, Object optionSugar, Object specDrink ) {
		System.out.println("drink factory-- createProduct ->" + type);                                                 //^^ new paramem enum coffee/tea specific
		Drink drink = null;
		switch ((DrinkTypes) type) //typecast from Object to DrinkTypes enum
		{
			case Coffee:													//sweetness not necc for coffee but added anyway
				drink = new Coffee((SizesSML) size, (milk) optionMilk, (Sweetness) optionSugar, (CoffeeSpecific) specDrink );
				/*
				switch ((SizesSML) size) {                                                   //^^ new paramem enum coffee/tea specific
					case S:
						drink.setCost(2.00);		
						break;
					case M:
						drink.setCost(2.00);
						break;
					case L:
						drink.setCost(2.50);
						break;
				}
				break;
				*/
				
				 switch ((CoffeeSpecific) specDrink) {                                                   //^^ new paramem enum coffee/tea specific
					case HousePremium:
						switch ((SizesSML) size) {                                                   //^^ new paramem enum coffee/tea specific
							case S:
								drink.setCost(2.25);		
								break;
							case M:
								drink.setCost(2.50);
								break;
							case L:
								drink.setCost(2.75);
								break;
						}
						break;
					case SeaCream:
						switch ((SizesSML) size) {                                                   //^^ new paramem enum coffee/tea specific
						case S:
							drink.setCost(2.25);		
							break;
						case M:
							drink.setCost(2.50);
							break;
						case L:
							drink.setCost(2.75);
							break;
					}
						break;
					case PumpkinSpice:
						switch ((SizesSML) size) {                                                   //^^ new paramem enum coffee/tea specific
						case S:
							drink.setCost(3.00);		
							break;
						case M:
							drink.setCost(3.50);
							break;
						case L:
							drink.setCost(4.00);
							break;
						}
						break;
					case ChaChaRegOrDecaf:
						switch ((SizesSML) size) {                                                   //^^ new paramem enum coffee/tea specific
						case S:
							drink.setCost(2.00);		
							break;
						case M:
							drink.setCost(2.50);
							break;
						case L:
							drink.setCost(3.00);
							break;
						}
						break;
					case HazelNutHappiness:
						switch ((SizesSML) size) {                                                   //^^ new paramem enum coffee/tea specific
						case S:
							drink.setCost(2.25);		
							break;
						case M:
							drink.setCost(2.75);
							break;
						case L:
							drink.setCost(3.25);
							break;
						}
						break;
					case CafeDeLaOla:
						switch ((SizesSML) size) {                                                   //^^ new paramem enum coffee/tea specific
						case S:
							drink.setCost(2.25);		
							break;
						case M:
							drink.setCost(2.75);
							break;
						case L:
							drink.setCost(3.25);
							break;
						}
						break;
						
				
			}
				break;
				
			case Tea:
				drink = new Tea((SizesSML) size, (milk) optionMilk, (Sweetness) optionSugar,(TeaSpecific) specDrink);
				 switch ((TeaSpecific) specDrink) {                                                   //^^ new paramem enum coffee/tea specific
					case GreenTea:
						switch ((SizesSML) size) {                                                   //^^ new paramem enum coffee/tea specific
							case S:
								drink.setCost(2.00);		
								break;
							case M:
								drink.setCost(2.50);
								break;
							case L:
								drink.setCost(3.00);
								break;
						}
						break;
					case RoseGreenTea:
						switch ((SizesSML) size) {                                                   //^^ new paramem enum coffee/tea specific
						case S:
							drink.setCost(2.25);		
							break;
						case M:
							drink.setCost(2.75);
							break;
						case L:
							drink.setCost(3.25);
							break;
					}
					case JasmineGreenTea:
						switch ((SizesSML) size) {                                                   //^^ new paramem enum coffee/tea specific
						case S:
							drink.setCost(2.25);		
							break;
						case M:
							drink.setCost(2.75);
							break;
						case L:
							drink.setCost(3.25);
							break;
					}
						break;
					case SummerMint:
						switch ((SizesSML) size) {                                                   //^^ new paramem enum coffee/tea specific
						case S:
							drink.setCost(3.00);		
							break;
						case M:
							drink.setCost(3.50);
							break;
						case L:
							drink.setCost(4.00);
							break;
						}
						break;
					case Taro:
						switch ((SizesSML) size) {                                                   //^^ new paramem enum coffee/tea specific
						case S:
							drink.setCost(2.25);		
							break;
						case M:
							drink.setCost(2.75);
							break;
						case L:
							drink.setCost(3.25);
							break;
					}
			 }
				 break;
						
				
			case nonDrink:
				drink = new nonDrink();
				break;
		}
		
		
	if (insertTopping != null)	{
		for(ToppingTypesDrink t: (ArrayList<ToppingTypesDrink>) insertTopping)  //type cast from Object to ArrayList
		{
			switch (t){
				case whippedCream:
					drink = new whippedCream(drink);
					break;
				case boba:
					drink = new boba(drink);
					break;
				case poppingBoba:
					drink = new poppingBoba(drink);
					break;
					
				case grassJelly:
					drink = new grassJelly(drink);
					break;
				case lycheeJelly:
					drink = new lycheeJelly(drink);
					break;
				case passionFruitJelly:
					drink = new passionFruitJelly(drink);
					break;
				case cocoJelly:
					drink = new cocoJelly(drink);
					break;
				case strawberry:
					drink = new strawberry(drink);
					break;
			}
		}
	}
		
		return drink;
	}

	
}

class PastryFactory extends ProductFactory{
	@Override																								// drinkDpec... unnec for pastry...
	public Product createProduct(Object type, Object size, Object quantity, Object heating, Object option3, Object pppp) {
		System.out.println("pastry factory-- createProduct ->" + type);
		Pastry p = null;
		
		
		
		switch ((PastryTypes) type) //typecast from Object to PizzaBases enum
		{
			case Crossaint:
				p = new Crossaint((PastryTypeIngredient) option3, quantity, heating);
				switch ((PastryTypeIngredient) option3) {
				case ChocoNut:
					p.setCost(3.00);
					break;
				}
				break;
			case Cookie:
				p = new Cookie((PastryTypeIngredient) option3, quantity);
				break;
			case Macaroon:
				p = new Macaroon((PastryTypeIngredient) option3, quantity);
				break;
			case nonPastry:
				p = new nonPastry();
				break;
		}
		
		
		return p;
	}

	

	
}
