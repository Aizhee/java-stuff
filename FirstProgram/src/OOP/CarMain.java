package OOP;

//New topic (Encapsulation)
//No input and calculation necessary!
public class CarMain {
	public static void main(String[] args) {
		//Making a new object
		Car myCar = new Car(); 
		//Setting the Company name 
		myCar.setCompanyName("Tesla"); 
		//Setting the Model name 
		myCar.setModelName("Cyber Truck");
		//Setting the Year
		myCar.setYear(5);
		//Outputs using Getter Methods 
		System.out.print("Company Name: " + myCar.getCompanyName()+"\n"+"Model Name: " + myCar.getModelName()+"\n"+"Year: " + myCar.getYear()+"\n"+"Mileage: " + myCar.getMileage());
	}
}

class Car{
	//Making variables private (encapsulation)
	private String company_name;
	private String model_name;
	private int year;
	// must be a double, and di pwedeng baguhin, kahit wag mo na lagyan ng laman 'to (auto 0.0 ang default)
	//nakalagay sa given na wag na lagyan ng setter method so getter na lang gagawin :D
	private double mileage; 
	
	//Setter Methods (setting values for private variables)
	//NOTE: may naming scheme para sa set & get methods, "setVariableName" or "getVariableName" 
	
	//setter for variable company_name
	public void setCompanyName(String company_name) {
		this.company_name=company_name;
	}
	//setter for variable model_name
	public void setModelName(String model_name) {
		this.model_name=model_name;
	}
	//setter for variable year
	public void setYear(int year) {
		this.year=year;
	}
	
	//Getter Methods (just return the private variables to make it visible sa public)
	//getter for variable company_name
	public String getCompanyName() {
		return company_name;
	}
	//getter for variable model_name
	public String getModelName() {
		return model_name;
	}
	//getter for variable company_name
	public int getYear() {
		return year;
	}
	//getter for variable mileage
	public double getMileage() {
		return mileage;
	}
}