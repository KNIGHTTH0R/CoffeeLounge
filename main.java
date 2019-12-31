/*import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumSet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



class MainFrame extends JFrame{

	private DefaultListModel<Product> productsList = new DefaultListModel<>();
	private DefaultListModel<String> productString = new DefaultListModel<>();
	private DrinkFactory drinkFactory = new DrinkFactory();
	private PastryFactory pastryFactory = new PastryFactory();
	
	private String textAreaString = "---The Start of receipt/// textStringArea---";
	
	private JLabel testLabel = new JLabel(" after conbobox selection COFFEE");
	private JLabel testLabel2 = new JLabel(" after conbobox selection TEA");
	private JPanel CoffeeNamePanel;
	
	private JPanel mainPanel;
	
	//1. Drink panel components
		private JPanel drinkPanel;
		private JComboBox drinkTypesComboBox;
		//2. Toppings panel components
		private JComboBox specificDrinkTypes;
		private JComboBox sizeComboBox;
		private JComboBox milkComboBox;
		private JComboBox sweetComboBox;
		
		private JPanel toppingsDrinkPanel;
		private ArrayList<JCheckBox> toppingsDrinkOptionsCheckBoxes;
		private JButton addToCartButtonDrink;
		
		
		
		//1. Drink panel components
				private JPanel pastryPanel;
				private JComboBox pastryTypesComboBox;
				//2. Toppings panel components
				private JPanel toppingsPastryPanel;
				private ArrayList<JCheckBox> PastryIngredOptionsCheckBoxes;
				private JButton addToCartButtonPastry;
				
				
				private DefaultComboBoxModel<TeaSpecific> teaSpecificOptions = new DefaultComboBoxModel<>();
				private DefaultComboBoxModel<CoffeeSpecific> coffeeSpecificOptions = new DefaultComboBoxModel<>();
				private DefaultComboBoxModel<SizesSML> sizeOptions = new DefaultComboBoxModel<>();
				private DefaultComboBoxModel<milk> milkOptions = new DefaultComboBoxModel<>();
				private DefaultComboBoxModel<Sweetness> sweetOptions = new DefaultComboBoxModel<>();
				
				
	//3. Items panel components
	private JPanel itemsPanel;
	private JList cartList;
		//4. Items panel buttons components
		private JScrollPane listScroller;
		private JPanel itemsButtonsPanel;
		private JButton deleteButton;
		private JButton finalizeButton;
		
	//5. Options panel
	private JPanel optionsPanel;
	
	//6. Summary panel components
	private JPanel summaryPanel;
	private JTextArea receiptSummary;
	
		//7. Summary panel buttons
		private JPanel buttonsPanel;
		private JButton payButton;
		private JButton cancelButton;

	
	
	public MainFrame() {
		this.setTitle("CHA CHA TIME");
		this.setSize(1700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createPanels();
		this.add(mainPanel);
	}

	
	
	private void createDrinkPanel() {
		drinkPanel = new JPanel();
		//setting a box layout with vertical alignment
		drinkPanel.setLayout(new BoxLayout(drinkPanel, BoxLayout.Y_AXIS));
		//setting spacing between components in the panel
		drinkPanel.setBorder(new EmptyBorder(new Insets(50, 90, 50, 90)));
		createDrinkComponents();
		drinkPanel.add(drinkTypesComboBox);
		/*
		if(drinkTypesComboBox.getSelectedItem() == DrinkTypes.Coffee) {
			drinkPanel.add(testLabel);
		}
		if(drinkTypesComboBox.getSelectedItem() == DrinkTypes.Tea) {
			drinkPanel.add(testLabel2);
		}*/
		/// panel for scrollbox sepcific drinks 

		EnumSet.allOf(CoffeeSpecific.class).forEach(CoffeeSpecific -> coffeeSpecificOptions.addElement(CoffeeSpecific));
		EnumSet.allOf(TeaSpecific.class).forEach(TeaSpecific -> teaSpecificOptions.addElement(TeaSpecific));
		EnumSet.allOf(SizesSML.class).forEach(SizesSML -> sizeOptions.addElement(SizesSML));
		EnumSet.allOf(milk.class).forEach(milk -> milkOptions.addElement(milk));
		EnumSet.allOf(Sweetness.class).forEach(Sweetness -> sweetOptions.addElement(Sweetness));
		
	
		//specificDrinkTypes = new JComboBox(coffeeSpecificOptions);
		specificDrinkTypes = new JComboBox();
		System.out.println("enum set coffeee size--->" + coffeeSpecificOptions.getSize());
		
		sizeComboBox = new JComboBox(sizeOptions);
		milkComboBox = new JComboBox(milkOptions);
		sweetComboBox = new JComboBox(sweetOptions);
		
		
		
		drinkPanel.add(specificDrinkTypes);
		
		drinkPanel.add(sizeComboBox);
		drinkPanel.add(milkComboBox);
		drinkPanel.add(sweetComboBox);
		
		
		drinkPanel.add(toppingsDrinkPanel);
		drinkPanel.add(addToCartButtonDrink);
		
	}
	
	/*
	private void CoffeeNamePanel() {
		CoffeeNamePanel = new JPanel();
		//setting a box layout with vertical alignment
		drinkPanel.setLayout(new BoxLayout(drinkPanel, BoxLayout.Y_AXIS));
		//setting spacing between components in the panel
		drinkPanel.setBorder(new EmptyBorder(new Insets(50, 90, 50, 90)));
		createDrinkComponents();
		drinkPanel.add(drinkTypesComboBox);
		drinkPanel.add(toppingsDrinkPanel);
		drinkPanel.add(addToCartButtonDrink);
		
	}*/

	private void createDrinkComponents() {
		//creating the pizza drop-down menu
		DrinkTypes[] drinks = {DrinkTypes.Coffee, DrinkTypes.Tea};
		drinkTypesComboBox = new JComboBox(drinks);
		
		drinkTypesComboBox.addActionListener(new DrinkTypesComboBoxListener());

		//creating checkboxes
		toppingsDrinkOptionsCheckBoxes = new ArrayList<JCheckBox>();

		toppingsDrinkOptionsCheckBoxes.add(new JCheckBox(ToppingTypesDrink.whippedCream.toString()));
		toppingsDrinkOptionsCheckBoxes.add(new JCheckBox(ToppingTypesDrink.boba.toString()));
		toppingsDrinkOptionsCheckBoxes.add(new JCheckBox(ToppingTypesDrink.poppingBoba.toString()));
		toppingsDrinkOptionsCheckBoxes.add(new JCheckBox(ToppingTypesDrink.grassJelly.toString()));
		toppingsDrinkOptionsCheckBoxes.add(new JCheckBox(ToppingTypesDrink.lycheeJelly.toString()));
		toppingsDrinkOptionsCheckBoxes.add(new JCheckBox(ToppingTypesDrink.passionFruitJelly.toString()));
		toppingsDrinkOptionsCheckBoxes.add(new JCheckBox(ToppingTypesDrink.cocoJelly.toString()));
		toppingsDrinkOptionsCheckBoxes.add(new JCheckBox(ToppingTypesDrink.strawberry.toString()));

		for(JCheckBox checkbox : toppingsDrinkOptionsCheckBoxes) { //adding action listener to the checkboxes
			checkbox.addActionListener(new DrinkToppingListener());
		}

	//add checkboxes to panel with grid layout
	toppingsDrinkPanel = new JPanel();
		toppingsDrinkPanel.setLayout(new GridLayout(2,3));
		for(JCheckBox b : toppingsDrinkOptionsCheckBoxes) {
		toppingsDrinkPanel.add(b);
	}


		//creating add to cart button
		addToCartButtonDrink = new JButton("Add DRINK to Cart");
		addToCartButtonDrink.addActionListener(new DrinkButtonListener());
	}
	
	class DrinkTypesComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(drinkTypesComboBox.getSelectedItem() == DrinkTypes.Coffee) {
				System.out.println( " after Coffee combo selected");
				System.out.println("coffee size check-> " + coffeeSpecificOptions.getSize());
				System.out.println("tea size check-> " + teaSpecificOptions.getSize());
				specificDrinkTypes.removeAllItems();
				System.out.println("coffee size check-> " + coffeeSpecificOptions.getSize());
				System.out.println("tea size check-> " + teaSpecificOptions.getSize());
				for(int i = 0; i < coffeeSpecificOptions.getSize(); i++) {
					System.out.println("sshhhhhh");
					specificDrinkTypes.addItem(coffeeSpecificOptions.getElementAt(i));
				}	
				
			}
			
			else if(drinkTypesComboBox.getSelectedItem() == DrinkTypes.Tea) {
				System.out.println( " after Tea combo selected");
				specificDrinkTypes.removeAllItems();
				System.out.println("coffee size check-> " + coffeeSpecificOptions.getSize());
				System.out.println("tea size check-> " + teaSpecificOptions.getSize());
				for(int i = 0; i < teaSpecificOptions.getSize(); i++) {
					specificDrinkTypes.addItem(teaSpecificOptions.getElementAt(i));
				}
				System.out.println("coffee size check-> " + coffeeSpecificOptions.getSize());
				System.out.println("tea size check-> " + teaSpecificOptions.getSize());
				
		
			}
		
		}
	}
	
	class SizeComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	class MilkComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	class SweetComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	class DrinkToppingListener implements ActionListener {
		//when a checkbox is clicked, the toppings are added to the drink. (toggle action)
		@Override
		public void actionPerformed(ActionEvent e) {
			JCheckBox jCheckBox = (JCheckBox)e.getSource();
			if(jCheckBox.isSelected()) {
				jCheckBox.setSelected(true);
				System.out.println(jCheckBox.getText() + " is Selected");
			} else {
				jCheckBox.setSelected(false);
				System.out.println(jCheckBox.getText() + "is deSelected");
			}
		}
	}

	class DrinkButtonListener implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<ToppingTypesDrink> drinkToppings = new ArrayList<>();
			for(JCheckBox b : toppingsDrinkOptionsCheckBoxes) {
				if(b.isSelected()) {

					switch(b.getText()) {
						case "whippedCream":
							drinkToppings.add(ToppingTypesDrink.whippedCream);
							break;
						case "boba":
							drinkToppings.add(ToppingTypesDrink.boba);
							break;
						case "poppingBoba":
							drinkToppings.add(ToppingTypesDrink.poppingBoba);
							break;
						case "grassJelly":
							drinkToppings.add(ToppingTypesDrink.grassJelly);
							break;
						case "lycheeJelly":
							drinkToppings.add(ToppingTypesDrink.lycheeJelly);
							break;
						case "passionFruitJelly":
							drinkToppings.add(ToppingTypesDrink.passionFruitJelly);
							break;
						case "cocoJelly":
							drinkToppings.add(ToppingTypesDrink.cocoJelly);
							break;
						case "strawberry":
							drinkToppings.add(ToppingTypesDrink.strawberry);
							break;


					}


				}
			}             
															//select coffee  ->  hardcode(coffeeSpecific)
			//Product drink = drinkFactory.createProduct(drinkTypesComboBox.getSelectedItem(), SizesSML.L, milk.SOY_MILK, drinkToppings, Sweetness.three_quarters_sugar, CoffeeSpecific.PumpkinSpice);
			//both works                                  //select    tea   ->   hardecode(teaSpecific)
			//Product drink = drinkFactory.createProduct(drinkTypesComboBox.getSelectedItem(), SizesSML.L, milk.SOY_MILK, drinkToppings, Sweetness.three_quarters_sugar, TeaSpecific.SummerMint);
			// *** combobox selection works here and ** dont mix Coffee with a  hardcode param ->teaSpecific->ie GreenTea
			
			/*Product drink = new Drink();
			
			if (drinkTypesComboBox.getSelectedItem() == DrinkTypes.Coffee ) {
				 drink = drinkFactory.createProduct(drinkTypesComboBox.getSelectedItem(), sizeComboBox.getSelectedItem(), milkComboBox.getSelectedItem(), drinkToppings, sweetComboBox.getSelectedItem(), specificDrinkTypes.getSelectedItem());
			}
			if (drinkTypesComboBox.getSelectedItem() == DrinkTypes.Tea ) {
				 drink = drinkFactory.createProduct(drinkTypesComboBox.getSelectedItem(), sizeComboBox.getSelectedItem(), milkComboBox.getSelectedItem(), drinkToppings, sweetComboBox.getSelectedItem(), specificDrinkTypes.getSelectedItem());
			}*/
			Product drink = drinkFactory.createProduct(drinkTypesComboBox.getSelectedItem(), sizeComboBox.getSelectedItem(), milkComboBox.getSelectedItem(), drinkToppings, sweetComboBox.getSelectedItem(), specificDrinkTypes.getSelectedItem());
			
				productsList.addElement(drink);
			//Drink theDrink = (Drink) drink;
			productString.addElement(drink.getDescription());
			
		}
	}
	
	
	private void createPastryPanel() {
		pastryPanel = new JPanel();
		//setting a box layout with vertical alignment
		pastryPanel.setLayout(new BoxLayout(pastryPanel, BoxLayout.Y_AXIS));
		//setting spacing between components in the panel
		pastryPanel.setBorder(new EmptyBorder(new Insets(50, 90, 50, 90)));
		createPastryComponents();
		pastryPanel.add(pastryTypesComboBox);
		pastryPanel.add(toppingsPastryPanel);
		pastryPanel.add(addToCartButtonPastry);
		
	}

	private void createPastryComponents() {
		//creating the pizza drop-down menu
		String[] pastries = {PastryTypes.Crossaint.toString(), PastryTypes.Cookie.toString(), PastryTypes.Macaroon.toString()};
		pastryTypesComboBox = new JComboBox(pastries);
		
		//creating checkboxes
		PastryIngredOptionsCheckBoxes = new ArrayList<JCheckBox>();
		
		PastryIngredOptionsCheckBoxes.add(new JCheckBox(PastryTypeIngredient.Plain.toString()));
		PastryIngredOptionsCheckBoxes.add(new JCheckBox(PastryTypeIngredient.Oatmeal.toString()));
		PastryIngredOptionsCheckBoxes.add(new JCheckBox(PastryTypeIngredient.Variety.toString()));
		PastryIngredOptionsCheckBoxes.add(new JCheckBox(PastryTypeIngredient.ChocoNut.toString()));
		
		
		//add checkboxes to panel with grid layout
		toppingsPastryPanel = new JPanel();
		toppingsPastryPanel.setLayout(new GridLayout(2,3));
		for(JCheckBox b : PastryIngredOptionsCheckBoxes) {
			toppingsPastryPanel.add(b);
		}
		
		//creating add to cart button
		addToCartButtonPastry = new JButton("Add PASTRY to Cart");
		//addToCartButtonPastry.addActionListener(new AddPastryButtonListener());
	}
	
	
	//3. & 4.
	private void createItemsPanel() {
		itemsPanel = new JPanel();
		itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
		itemsPanel.setBorder(new EmptyBorder(new Insets(50, 90, 50, 90)));
		
		itemsPanel.add(new JLabel("Current Order"));
		//creating scroll list component
		cartList = new JList(productString); //////******************
		listScroller = new JScrollPane(cartList);
		listScroller.setPreferredSize(new Dimension(250, 80));
		itemsPanel.add(listScroller);
		
		//creating buttons panel
		itemsButtonsPanel = new JPanel();
		itemsButtonsPanel.setLayout(new FlowLayout());
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new DeleteButtonListener());
		finalizeButton = new JButton("Save All");
		finalizeButton.addActionListener(new SaveAllButtonListener());
		itemsButtonsPanel.add(deleteButton);
		itemsButtonsPanel.add(finalizeButton);
		
		itemsPanel.add(itemsButtonsPanel);
		
	}
	
	class DeleteButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int indexSelected = cartList.getSelectedIndex();
			System.out.println("seleted index--> " + indexSelected );
			//System.out.println(productString);
			System.out.println("index->toString [[[" + cartList.getSelectedValue());
			
			//cartList.remove(indexSelected);
			productsList.removeElementAt(indexSelected);
			productString.removeElementAt(indexSelected);

		}
	}
	
	class SaveAllButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		System.out.println(" pressed save all - check ");
		textAreaString = "";  // erases "---start of receipt----"
			for (int i = 0; i < productsList.getSize(); i++) {
				textAreaString +=  "\n " +  productsList.getElementAt(i).getDescription() + "-> " + productsList.getElementAt(i).getCost();
			}
			
			//System.out.println("-------------- updated string string with all prod descrip added-------- \n" + textAreaString + "\n----------------------------------");
			//updates the textArea// 
			receiptSummary.append(textAreaString);
			
		}
	}
	
	//5.
	private void createOptionsPanel() {
		optionsPanel = new JPanel();
		optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
		
		createDrinkPanel();
		createPastryPanel();
		
		createItemsPanel();
		
		
		optionsPanel.add(drinkPanel);
		optionsPanel.add(pastryPanel);
		
		optionsPanel.add(itemsPanel);
	}

	//6.
	private void createSummaryPanel() {
		System.out.println("CREATION OF SUM PANET");
		summaryPanel = new JPanel();
		summaryPanel.setLayout(new BoxLayout(summaryPanel, BoxLayout.Y_AXIS));
		
		//creating text area
		receiptSummary = new JTextArea(textAreaString);
		summaryPanel.add(receiptSummary);
		
		//creating final buttons
		createFinalButtons();
		
		summaryPanel.add(buttonsPanel);
		System.out.println("CREATION OF SUM PANET");
	}
	
	//7.
	private void createFinalButtons() {
		//creating buttons panel
		buttonsPanel = new JPanel();
		payButton = new JButton("Pay");
		cancelButton = new JButton("Cancel");
		buttonsPanel.add(payButton);
		buttonsPanel.add(cancelButton);
	}
	
	private void createPanels() {
		//8.
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(20,20)); //spacing between each component
		
		createOptionsPanel();  //1. - 5.
		
		createSummaryPanel();  //6. - 7.

		
		//Add the panels to the main panel
		
		mainPanel.add(optionsPanel, BorderLayout.WEST);
		
		mainPanel.add(summaryPanel, BorderLayout.CENTER);
	}
}

/*
class AddDrinkButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println("add drink clicked---");
		
	}
}

class AddPastryButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println("add pastry clicked---");
	}
}*/


public class main {
	public static void main(String[] args) {
		
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		System.out.println("this is main:");
		
		/*
		ArrayList<ToppingTypesDrink> whippedCreamOnlyArray = new ArrayList<ToppingTypesDrink>();
		whippedCreamOnlyArray.add(ToppingTypesDrink.whippedCream);
		//vegtop.add(ToppingTypesDrink.boba);
		
		DrinkFactory drinkMaker = new DrinkFactory();
		PastryFactory pastryMaker = new PastryFactory();
		
		System.out.println("\n\n---------------drink 1---------------");
		Product coffee111 = drinkMaker.createProduct(DrinkTypes.Coffee, SizesSML.M, null, whippedCreamOnlyArray, null);
		System.out.println(coffee111.getDescription());
		System.out.println(String.format("Cost: $%.2f" , coffee111.getCost()));
		
		System.out.println("\n\n---------------drink 2---------------");
		Product coffee2 = drinkMaker.createProduct(DrinkTypes.Coffee, SizesSML.L, null, null, null);
		System.out.println(coffee2.getDescription());
		System.out.println(String.format("Cost: $%.2f" , coffee2.getCost()));
		
		System.out.println("\n\n---------------drink 3---------------");
		Product coffee3 = drinkMaker.createProduct(DrinkTypes.Coffee, SizesSML.S, milk.SOY_MILK, whippedCreamOnlyArray, null);
		System.out.println(coffee3.getDescription());
		System.out.println(String.format("Cost: $%.2f" , coffee3.getCost()));
		
		System.out.println("\n\n---------------drink 4---------------");
		Product coffee4 = drinkMaker.createProduct(DrinkTypes.Coffee, SizesSML.S, milk.HALF_MILK, whippedCreamOnlyArray, null);
		System.out.println(coffee4.getDescription());
		System.out.println(String.format("Cost: $%.2f" , coffee4.getCost()));
	
		ArrayList<ToppingTypesDrink> boboCoco = new ArrayList<ToppingTypesDrink>();
		boboCoco.add(ToppingTypesDrink.boba);
		boboCoco.add(ToppingTypesDrink.cocoJelly);
		
		
		System.out.println("\n\n---------------tea 5---------------");
		Product tea111 = drinkMaker.createProduct(DrinkTypes.Tea, SizesSML.L, milk.SOY_MILK, boboCoco, Sweetness.quarter_sugar);
		System.out.println(tea111.getDescription());
		System.out.println(String.format("Cost: $%.2f" , tea111.getCost()));
		
		ArrayList<ToppingTypesDrink> arr2 = new ArrayList<ToppingTypesDrink>();
		arr2.add(ToppingTypesDrink.passionFruitJelly);
		arr2.add(ToppingTypesDrink.strawberry);
		arr2.add(ToppingTypesDrink.cocoJelly);
		
		System.out.println("\n\n---------------tea 6---------------");
		Product tea6 = drinkMaker.createProduct(DrinkTypes.Tea, SizesSML.L, null, arr2, Sweetness.half_sugar);
		System.out.println(tea6.getDescription());
		System.out.println(String.format("Cost: $%.2f" , tea6.getCost()));
		
		ArrayList<ToppingTypesDrink> bobaArr = new ArrayList<ToppingTypesDrink>();
		bobaArr.add(ToppingTypesDrink.boba);
		
		System.out.println("\n\n---------------tea 7---------------");
		Product tea7 = drinkMaker.createProduct(DrinkTypes.Tea, SizesSML.M, milk.HALF_MILK, bobaArr, Sweetness.three_quarters_sugar);
		System.out.println(tea7.getDescription());
		System.out.println(String.format("Cost: $%.2f" , tea7.getCost()));
		
		
		ArrayList<ToppingTypesDrink> bobaLycheeArr = new ArrayList<ToppingTypesDrink>();
		bobaLycheeArr.add(ToppingTypesDrink.boba);
		bobaLycheeArr.add(ToppingTypesDrink.lycheeJelly);
		
		
		System.out.println("\n\n---------------tea 8---------------");
		Product tea8 = drinkMaker.createProduct(DrinkTypes.Tea, SizesSML.M, milk.SOY_MILK, bobaLycheeArr, Sweetness.no_sugar);
		System.out.println(tea8.getDescription());
		System.out.println(String.format("Cost: $%.2f" , tea8.getCost()));
	
		
		System.out.println("\n\n---------------Pastry 1---------------");										
		Product crossaint1 = pastryMaker.createProduct(PastryTypes.Crossaint, null, 1, "noHeat", PastryTypeIngredient.ChocoNut);
		System.out.println(crossaint1.getDescription());
		System.out.println(String.format("Cost: $%.2f" , crossaint1.getCost()));
		
		System.out.println("\n\n---------------Pastry 2---------------");										
		Product crossaint2 = pastryMaker.createProduct(PastryTypes.Crossaint, null, 1, "yesHeat", PastryTypeIngredient.Plain);
		System.out.println(crossaint2.getDescription());
		System.out.println(String.format("Cost: $%.2f" , crossaint2.getCost()));
		
		System.out.println("\n\n---------------Pastry 3---------------");										
		Product cookie = pastryMaker.createProduct(PastryTypes.Cookie, null, 7, null, PastryTypeIngredient.Oatmeal);
		System.out.println(cookie.getDescription());
		System.out.println(String.format("Cost: $%.2f" , cookie.getCost()));
		
		System.out.println("\n\n---------------Pastry 3---------------");										
		Product maca = pastryMaker.createProduct(PastryTypes.Macaroon, null, 7, null, PastryTypeIngredient.Variety);
		System.out.println(maca.getDescription());
		System.out.println(String.format("Cost: $%.2f" , maca.getCost()));
		
		//Product drink = drinkMaker.createProduct(DrinkTypes.nonDrink, null, null, null, null);
		//System.out.println(String.format("Cost: $%.2f" , drink.getCost()));
		//Product pastryNon = pastryMaker.createProduct(PastryTypes.nonPastry, null, null, null, null);
		//System.out.println(String.format("Cost: $%.2f" , pastryNon.getNewCost()));
		System.out.println("\n\n----------receipt----------------");
		ArrayList<Product> productArr = new ArrayList<Product>();
		productArr.add(coffee111);
		productArr.add(coffee2);
		productArr.add(coffee3);
		productArr.add(coffee4);
		productArr.add(tea111);
		productArr.add(tea6);
		productArr.add(tea7);
		productArr.add(tea8);
		productArr.add(crossaint1);
		productArr.add(crossaint2);
		productArr.add(cookie);
		productArr.add(maca);
		
		
		int counter0 = 0;
		double totalNoDiscount = 0;
		while(counter0 < productArr.size()) {
			totalNoDiscount += productArr.get(counter0).getCost();
			counter0++;
		}
		System.out.println("---total no discount---" + String.format("Cost: $%.2f " , totalNoDiscount));
		
		
		int counter1 = 0;
		double totalWithDrinkDiscount = 0;
		double maxPriceDrink= 0;
		double temp=0;
		while(counter1 < productArr.size()) {
			if (productArr.get(counter1) instanceof Drink) {
				// discout rate...
				//double discountedPrice =  productArr.get(counter1).getCost() * 0.9;
				//totalWithDrinkDiscount += discountedPrice;
				temp = productArr.get(counter1).getCost();
				
				totalWithDrinkDiscount += temp;
				
				if (temp > maxPriceDrink) {
					maxPriceDrink = temp;
				}
				
			}
			else {
				totalWithDrinkDiscount += productArr.get(counter1).getCost();
			}
			counter1++;
		}
		System.out.println("--- drinks discount before---" + String.format("Cost: $%.2f " , totalWithDrinkDiscount) + "---highest price drink-> " + maxPriceDrink);
		System.out.println("--- drinks discount after (50% off highest)---" + String.format("Cost: $%.2f " , totalWithDrinkDiscount - maxPriceDrink*0.5));
		
		int counter2 = 0;
		double totalWithPastryDiscount = 0;
		int cookieCount = 0;
		while(counter2 < productArr.size()) {
			if (productArr.get(counter2) instanceof Pastry) {
				// discout rate...
				//double discountedPrice =  productArr.get(counter2).getCost() * 0.8;
				//totalWithPastryDiscount += discountedPrice;
				totalWithPastryDiscount += productArr.get(counter2).getCost();
				if (productArr.get(counter2) instanceof Cookie) {
					cookieCount++;
				}
			}
			else {
				totalWithPastryDiscount += productArr.get(counter2).getCost();
			}
			counter2++;
		}
		System.out.println("---pastry discount before---" + String.format("Cost: $%.2f " , totalWithPastryDiscount) + "--- cookieCount-> " + cookieCount);
		System.out.println("---pastry discount after (-$1 for each cookie) ---" + String.format("Cost: $%.2f " , totalWithPastryDiscount - cookieCount*1));
		int counter3 = 0;
		double totalWithGeneralDiscount = 0;
		while(counter3 < productArr.size()) {
			if (productArr.get(counter3) instanceof Product) {
				//double discountedPrice = productArr.get(counter3).getCost() * 0.5;
				//totalWithGeneralDiscount += discountedPrice;
				
				totalWithGeneralDiscount += productArr.get(counter3).getCost();
			}
			counter3++;
		}
		System.out.println("---general discount off---" + String.format("Cost: $%.2f " , totalWithGeneralDiscount));
		if (totalWithGeneralDiscount >= 10)	{
			System.out.println("---general discount ($2 off if at least $10)---" + String.format("Cost: $%.2f " , totalWithGeneralDiscount -2));
		}*/
		}
	}
	
	


