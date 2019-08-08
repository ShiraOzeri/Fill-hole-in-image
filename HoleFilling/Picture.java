package HoleFilling;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Picture {

	private float [][] image;
	private int height;
	private int width;


	/**
	 * Constructor for Picture, get a Mat image and represent it as a float[][] of gray scale[0-1].
	 * @param mat_image Mat
	 */
	public Picture(Mat mat_image) {
		this.height=(int)mat_image.size().height;
		this.width=(int)mat_image.size().width;
		this.image=new float[this.height][this.width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				image[i][j]=(float) ((mat_image.get(i,j)[0])/255);
			}
		}

	}




	/**
	 * Copy Constructor
	 * @param picture
	 */
	public Picture(Picture picture) {
		this.height=picture.height;
		this.width=picture.width;
		this.image=new float[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				image[i][j]=picture.image[i][j];
			}
		}


	}


	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	/**
	 * get the value of the pixel
	 * @param Pixel p 
	 * @return value of pixel p
	 */
	public float getPixel(Pixel p) {
		return image[p.getRow()][ p.getCol()];
	}

	/**
	 * set value of pixel
	 * @param row
	 * @param col
	 * @param val
	 */
	public void setPixel(int row, int col, float val) {
		this.image[row][col]=val;

	}


	/**
	 * create picture from the image float[][]
	 * @param path to the new picture
	 */
	public void createPicture(String path) {
		Mat A=new Mat(this.height,this.width,CvType.CV_8UC1);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				A.put(i,j,this.image[i][j]*255);

			}
		}
		Imgcodecs.imwrite(path, A); 

	}





}
