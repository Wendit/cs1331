
public class ImageProcessorDriver {
	public ImageProcessorDriver()
	{
	}
	
	public static void main(String args[])
	{
		Pic myPic = new Pic("examplePic1.jpg");
		myPic.show();
		ImageProcessor ip = new ImageProcessor(myPic);
		ip.greyscale().show();
		ip.invert().show();
		ip.noRed().show();
		ip.blackAndWhite().show();
		ip.maximize().show();
		ip.overlay(new Pic("black-and-white-tips.jpg")).show();
		
	}
}
