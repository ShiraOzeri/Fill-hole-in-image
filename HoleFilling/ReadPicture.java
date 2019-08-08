package HoleFilling;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ReadPicture {

	private String path1;
	private String path2;



	public ReadPicture(String path1, String path2) {
		this.path1=path1;
		this.path2=path2;


	}



	/**
	 * create 2-array from the mask that defines the hole
	 * @return 2-array that defined the hole
	 */
	public int[][] readMaskToMat() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
		Mat mask = Imgcodecs.imread(path2); 
		int height=(int) mask.size().height;
		int width=(int) mask.size().width;
		int [][] mat=new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				double[] data = mask.get(i, j);
				if(zeroPixel(data)) {
					mat[i][j]=-1;
				}

			}

		}

		return mat;



	}





	private boolean zeroPixel(double[] data) {
		// TODO Auto-generated method stub

		for (double d : data) {
			if(d!=0) return false;
		}
		return true;
	}





	/**
	 * Read the image and create a gray scale image
	 * @return gray scale image
	 */
	public Mat readImage() {
		// To load  OpenCV core library 
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 

		// To Read the image 
		Mat image = Imgcodecs.imread(this.path1); 

		// Creating the empty destination matrix 
		Mat gray = new Mat(); 

		// Converting the image to gray scale and  
		// saving it in the dst matrix 
		Imgproc.cvtColor(image, gray, Imgproc.COLOR_RGB2GRAY); 

		// Writing the image 
		String path=path1.substring(0,path1.indexOf("."))+"_Gray"+path1.substring(path1.indexOf("."));
		Imgcodecs.imwrite(path, gray); 


		return gray;


	} 


}

