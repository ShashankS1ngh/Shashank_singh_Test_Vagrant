public class Main {
	 public static void main(String[] args) {
		 Product[] list = new Product[4];
		 list[0] = new Product("Leather wallet", 1100, 18, 1);
		 list[1] = new Product("Umbrella", 900, 12, 4);
		 list[2] = new Product("Cigarette", 200, 28, 3);
		 list[3] = new Product("Honey", 100, 0, 2);
		 
		 Main obj = new Main();
		 String prodWithMaxGST = obj.getProdWithMaxGST(list);
		 System.out.println("Product for which we paid maximum GST is = "+prodWithMaxGST);
		 double totalAmt = obj.calculateTotalAmount(list);
		 System.out.println("Total amount to be paid to shopkeeper is = "+totalAmt);
	 }
	 public String getProdWithMaxGST(Product[] list){
		 double max = Double.MIN_VALUE;
		 String item = "";
		 for(Product p:list){
		 double gst = (p.gstPer * p.price * p.quantity) / 100.0;
		 if(max<gst){
		 max = gst;
		 item = p.name;
		 }
		 }
		 return item;
	 }
	 public double calculateTotalAmount(Product[] list){
		 double sum = 0;
		 for(Product p:list){
		 double gst = (p.price * p.gstPer)/100.0;
		 sum += (p.price + gst)*p.quantity;
		 }
		 return sum;
	 }
}
class Product{
	 String name;
	 double price;
	 double gstPer;
	 int quantity;
	 Product(String name, double price, double gstPer, int quantity){
		 this.price = price;
		 this.name = name;
		 this.gstPer = gstPer;
		 this.quantity = quantity;
	 }
}