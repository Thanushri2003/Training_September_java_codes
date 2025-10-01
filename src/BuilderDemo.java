class Company
{
	private int id;
	private String name;
	private String location;
	private String city;
	private int pincode;
	
	public Company(String name,String location,int id)
	{
		
	}
	public Company(Builder builder)
	{
		this.id=builder.id;
		this.name=builder.name;
		this.location=builder.location;
		
	}
	
	public static class Builder
	{
		private int id;
		private String name;
		private String location;
		

		private String city;
		private int pincode;
		
		public void setCity(String city)
		{
			this.city=city;
			
		}
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}


public class BuilderDemo {
	
	public static void main(String args[])
	{
		Company o=new 
	}

}
