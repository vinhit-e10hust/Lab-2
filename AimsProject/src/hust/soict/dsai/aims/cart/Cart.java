package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public int qtyOrdered = 0;
	public String addDigitalVideoDisc(DigitalVideoDisc disc) throws ArithmeticException {
		if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			throw new ArithmeticException("The cart is almost full!");
		}else{
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			return (disc.getTitle() + " has been added!");
		}
		
	}
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (DigitalVideoDisc dvd : dvdList) {
			if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is full.");
				break;			
			}
			itemOrdered[qtyOrdered++] = dvd;
			System.out.println("The disc has been added");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
			if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is full. Cannot add: " + dvd1.getTitle() + " and " + dvd2.getTitle());
				return;
			}
			itemOrdered[qtyOrdered++] = dvd1;
			System.out.println("The disc has been added");
			if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is full. Cannot add");
				return;
			}
			itemOrdered[qtyOrdered++] = dvd2;
			System.out.println("The disc has been added");
	}
		
		
	public String removeDigitalVideoDisc(DigitalVideoDisc disc) {
	        boolean found = false;
	        for (int i = 0; i < qtyOrdered; i++) {
	            if (itemOrdered[i].getTitle().equalsIgnoreCase(disc.getTitle())) {
	                found = true;
	                for (int j = i; j < qtyOrdered - 1; j++) {
	                    itemOrdered[j] = itemOrdered[j + 1];
	                }
	                itemOrdered[qtyOrdered - 1] = null;
	                qtyOrdered--;
	                return (disc.getTitle() + " has been removed.");
	                
	            }
	        }
	        if (!found) {
	            return (disc.getTitle() + " not found.");
	        }
			return null;
	    }
	
   
    
    public void searchByCategory(String category) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].getCategory().equalsIgnoreCase(category)) {
                System.out.println("Found" + itemOrdered[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, no DVDs matching the \"" + category + "\" category were found!");
        }
    }
    
    public void searchByPrice(float maxCost) {
        boolean matchFound = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].getCost() <= maxCost) {
                System.out.println("Found" + itemOrdered[i]);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Sorry, no DVDs were found that match the maximum cost provided!");
        }
    }
    
    public void searchByTitle(String keyword) {
        boolean matchFound = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].isMatch(keyword)) {
                System.out.println("Found" + itemOrdered[i]);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Sorry, no DVDs were found with \"" + keyword +"\" in the title!");
        }
    }
    
    public void searchByPrice(float minCost, float maxCost) {
        boolean matchFound = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].getCost() >= minCost && itemOrdered[i].getCost() <= maxCost) {
                System.out.println("Found" + itemOrdered[i]);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Sorry, no DVDs were found that match the cost range between your specified minimum and maximum!");
        }
    }
    public void searchByID(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].getId() == id) {
                System.out.println("Found" + itemOrdered[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, no DVDs were found that match the ID provided!");
        }
    }

    
	 public float totalCost() {
		 float res = 0;
		 for (int i = 0; i < qtyOrdered; i++) {
			 res += itemOrdered[i].getCost();
		 }
		 return res;
	 }
	    public void print() {
	        System.out.println("***********************CART***********************");
	        System.out.println("Ordered Items:");
	        for (int i = 0; i < qtyOrdered; i++) {
	            System.out.println(i+1 + ". " + itemOrdered[i]);
	        }
	        System.out.println("Total cost: " + totalCost());
	        System.out.println("***************************************************");
	    }
}


