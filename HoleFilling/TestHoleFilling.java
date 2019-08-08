package HoleFilling;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class TestHoleFilling {


	public static void main(String[] args) {
		String path="tree.png";
		createPicture(path);
		createMask(path);
	}

	/**
	 * create image
	 * @param path to image
	 */
	private static void createPicture(String path) {
		// TODO Auto-gener9ated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
		Mat dest = new Mat(50,50,CvType.CV_8UC3);
		for (int i =  0; i < dest.size().height; i++) {
			for (int j = 0; j < dest.size().width; j++) {
				dest.put(i, j, new double[] {0,0,0});
			}
		}
		for (int i =  10; i < 30; i++) {
			for (int j = 10; j < 30; j++) {
				dest.put(i, j, new double[] {255,255,255});
			}
		}


		Imgcodecs.imwrite(path, dest); 


	}


	/**
	 * create mask to the image
	 * @param path to image
	 */
	private static void createMask(String path) {
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
		Mat source = Imgcodecs.imread(path); 
		Mat A =source.clone();

		for (int i = 0; i < A.size().height; i++) {
			for (int j = 0; j < A.size().width; j++) {
				A.put(i,j,new double[] {50,50,50});

			}
		}
		for (int i =  10; i < 30; i++) {
			for (int j = 10; j < 30; j++) {
				A.put(i, j, new double[] {0,0,0});
			}
		}
		String path_d=path.substring(0,path.indexOf("."))+"_MASK"+path.substring(path.indexOf("."));
		Imgcodecs.imwrite(path_d, A); 


	}

}
