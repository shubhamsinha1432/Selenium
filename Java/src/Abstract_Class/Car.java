package Abstract_Class;

abstract public class Car {
	abstract void tata();
	public void suzuki()
	{
		System.out.println("Suzuki");
	}
	
}
 class sachin extends Car
{
	public void tata()
	{
      System.out.println("tata");		
	}
	public static void main(String[] args) {
		
		sachin s=new sachin();
		s.tata();
		s.suzuki();
		
	}
}