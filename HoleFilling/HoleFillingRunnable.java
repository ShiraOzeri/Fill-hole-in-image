package HoleFilling;

import org.opencv.core.Mat;


public class HoleFillingRunnable {

	public static void main(String[] args) {
		holeFillingRunnable(args);

	}
	
	
	/**
	 * The main run function
	 * @param args from user
	 */
	public static void holeFillingRunnable(String []args) {
		String path1=args[0];
		String path2=args[1];
		double z=Double.parseDouble(args[2]);
		double e=Double.parseDouble(args[3]);
		int connect=Integer.parseInt(args[4]);


		ReadPicture read=new ReadPicture(path1, path2);
		Mat image=read.readImage();

		int[][]mask=read.readMaskToMat();

		validSize(image,mask);
		
		Picture picture=new Picture(image);
		HoleFilling h_f=new HoleFilling(picture, mask, connect,z,e);
		Picture fill_picture=h_f.holeFillingAlgo();
//		
//		ApproximatesHoleFilling app_hf=new ApproximatesHoleFilling(picture, mask, connect,z,e);
//		Picture fill_picture=app_hf.holeFillingAlgo();
		
		String path=path1.substring(0,path1.indexOf("."))+"FILL"+path1.substring(path1.indexOf("."));

		fill_picture.createPicture(path);
	}

	

	private static void validSize(Mat image, int[][] mask) {
		if(image.size().height!=mask.length || image.size().width!=mask[0].length) {
			System.err.println("The image and the mask need to be in the same size");

		}
		
	}

	
}
