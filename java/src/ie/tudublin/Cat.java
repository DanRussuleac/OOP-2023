package ie.tudublin;

public class Cat {
    
	private int numLives = 9;
	private String name;

	public Cat(String name)
	{
        this.name = name;
	}
	
	public int getNumLives()
	{
        return numLives;
	}
	
	public void setNumLives(int numLives)
	{
        this.numLives = numLives;
	}
	
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

	public void kill()
	{
        if (numLives > 0) {
            numLives--;
            System.out.println("Ouch");
        }
        else{
            System.out.println("Dead");
        }
	}
}
