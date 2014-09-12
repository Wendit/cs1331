
public class ImageProcessor {
	
	private Pic myPic;
	final int MAX = 255;
	final int MIDDLE = 127;
	final int MIN = 0;
	
	public ImageProcessor(Pic source)
	{
		myPic = source;
	}
	
	public Pic greyscale()
	{
		Pic fakePic = myPic.deepCopy();
		int average;
		for(int rows = 0 ; rows < fakePic.getHeight(); rows++)
		{
			for(int cols = 0; cols < fakePic.getWidth() ;cols++ )
			{
				average = (fakePic.getPixels()[rows][cols].getBlue()+
						fakePic.getPixels()[rows][cols].getGreen()+
						fakePic.getPixels()[rows][cols].getRed())/3;
				
				fakePic.getPixels()[rows][cols].setBlue(average);
				fakePic.getPixels()[rows][cols].setGreen(average);
				fakePic.getPixels()[rows][cols].setRed(average);
			}
		}
		
		return fakePic;
	}
	
	public Pic invert()
	{
		Pic fakePic = myPic.deepCopy();
		for(int rows = 0 ; rows < fakePic.getHeight(); rows++)
		{
			for(int cols = 0; cols < fakePic.getWidth() ;cols++ )
			{
				fakePic.getPixels()[rows][cols].setBlue(MAX- fakePic.getPixels()[rows][cols].getBlue());
				fakePic.getPixels()[rows][cols].setGreen(MAX- fakePic.getPixels()[rows][cols].getGreen());
				fakePic.getPixels()[rows][cols].setRed(MAX- fakePic.getPixels()[rows][cols].getRed());
			}
		}
		
		return fakePic;
	}
	
	public Pic noRed()
	{
		Pic fakePic = myPic.deepCopy();
		
		for(int rows = 0 ; rows < fakePic.getHeight(); rows++)
		{
			for(int cols = 0; cols < fakePic.getWidth() ;cols++ )
			{
				fakePic.getPixels()[rows][cols].setRed(MIN);
			}
		}
		
		return fakePic;
	}
	
	public Pic blackAndWhite()
	{
		Pic fakePic = myPic.deepCopy();
		int average;
		
		for(int rows = 0 ; rows < fakePic.getHeight(); rows++)
		{
			for(int cols = 0; cols < fakePic.getWidth() ;cols++ )
			{
				average = (fakePic.getPixels()[rows][cols].getBlue()+
						fakePic.getPixels()[rows][cols].getRed()+
						fakePic.getPixels()[rows][cols].getGreen())/3;
				if(average > 127)
				{
					fakePic.getPixels()[rows][cols].setBlue(MAX);
					fakePic.getPixels()[rows][cols].setGreen(MAX);
					fakePic.getPixels()[rows][cols].setRed(MAX);
				}else
				{
					fakePic.getPixels()[rows][cols].setBlue(MIN);
					fakePic.getPixels()[rows][cols].setGreen(MIN);
					fakePic.getPixels()[rows][cols].setRed(MIN);
				}
			}
		}
		
		return fakePic;
	}
	
	public Pic maximize()
	{
		Pic fakePic = myPic.deepCopy();
		int largest;
		for(int rows = 0 ; rows < fakePic.getHeight(); rows++)
		{
			for(int cols = 0; cols < fakePic.getWidth() ;cols++ )
			{
				largest = (fakePic.getPixels()[rows][cols].getBlue() > 
				fakePic.getPixels()[rows][cols].getRed())?fakePic.getPixels()[rows][cols].getBlue():
					fakePic.getPixels()[rows][cols].getRed();
				largest = (largest > 
				fakePic.getPixels()[rows][cols].getGreen())?largest:
					fakePic.getPixels()[rows][cols].getGreen();
				
				if(fakePic.getPixels()[rows][cols].getRed() < largest)
					fakePic.getPixels()[rows][cols].setRed(MIN);
				if(fakePic.getPixels()[rows][cols].getBlue() < largest)
					fakePic.getPixels()[rows][cols].setBlue(MIN);
				if(fakePic.getPixels()[rows][cols].getGreen() < largest)
					fakePic.getPixels()[rows][cols].setGreen(MIN);
			}
		}
		return fakePic;
	}
	
	public Pic overlay(Pic other)
	{
		Pic fakePic = myPic.deepCopy();
		int width = (other.getWidth() < fakePic.getWidth())?other.getWidth():fakePic.getWidth();
		int height = (other.getWidth() < fakePic.getHeight())?other.getHeight():fakePic.getHeight();
		
		for(int rows = 0 ; rows < height; rows++)
		{
			for(int cols = 0; cols < width ;cols++ )
			{
				fakePic.getPixels()[rows][cols].setRed((fakePic.getPixels()[rows][cols].getRed()+
						other.getPixels()[rows][cols].getRed())/2);
				fakePic.getPixels()[rows][cols].setBlue((fakePic.getPixels()[rows][cols].getBlue()+
						other.getPixels()[rows][cols].getBlue())/2);
				fakePic.getPixels()[rows][cols].setGreen((fakePic.getPixels()[rows][cols].getGreen()+
						other.getPixels()[rows][cols].getGreen())/2);
			}	
		}
		return fakePic;
	}
}
