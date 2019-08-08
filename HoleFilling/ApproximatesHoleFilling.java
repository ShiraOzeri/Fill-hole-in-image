package HoleFilling;

import java.util.HashSet;
import ConnectivityStrategy.Context;
import ConnectivityStrategy.EightConnectivity;
import ConnectivityStrategy.FourConnectivity;
import WeighteFactory.WeightFun;
import WeighteFactory.WeightFunFactory;

public class ApproximatesHoleFilling {


	private Picture picture;
	private int[][] mask;
	private WeightFun weight_fun;
	private Context strategy;



	/**
	 * Constructor to ApproximatesHoleFilling
	 * @param picture Image with the hole
	 * @param mask Sign the pixels with the hole
	 * @param connectivity 4 or 8 connectivity
	 * @param z for the weightFun
	 * @param e for the weightFun
	 */
	public ApproximatesHoleFilling(Picture picture,int[][]mask,int connectivity ,double z,double e) {
		this.picture=picture;
		this.mask=mask;
		weight_fun=WeightFunFactory.getWeight(1, z, e);
		switch (connectivity) {
		case 4:
			strategy=new Context(new FourConnectivity(mask));
			break;
		case 8:
			strategy=new Context(new EightConnectivity(mask));
			break;
		default:
			System.err.println("Choose 4-connected or 8-connected");
		}


	}

	/**
	 * The main Algo- approximates
	 * @return Picture after filling the hole
	 */
	public Picture holeFillingAlgo() {
		Picture fill_image =new Picture(picture);

		Pixel p=getBoundary();
		fillImage(fill_image,p.getRow(),p.getCol());


		return fill_image;



	}

	
	/**
	 * Recursively fills the image from top left to bottom right
	 * @param fill_image
	 * @param r row of the pixel
	 * @param c column of that pixel
	 */
	private void fillImage(Picture fill_image,int r,int c) {
		if(mask[r][c]!=-1) 
			return;
		fill(fill_image,r,c);
		fillImage(fill_image,r,c+1);
		fillImage(fill_image,  r+1, c);
		fillImage(fill_image, r+1, c+1);


	}





	/**
	 * Fills in the missing pixel based on existing neighbors
	 * @param fill_image
	 * @param r
	 * @param c
	 */
	private void fill(Picture fill_image, int r, int c) {
		HashSet<Pixel> connect=new HashSet<>();
		strategy.getNeighbor(r, c, connect);
		Pixel p=new Pixel(r, c);
		double sum_m=0;
		double sum_n=0;
		double weight=0;

		for (Pixel p_c : connect) {
			weight=weight_fun.weightFun(p,p_c);
			sum_n+=weight*picture.getPixel(p_c);
			sum_m+=weight;

		}
		float val=(float) (sum_n/sum_m);
		fill_image.setPixel(p.getRow(),p.getCol(),val);
		this.mask[r][c]=0;

	}







	/**
	 * Returns the empty upper left pixel
	 * @return
	 */
	public Pixel getBoundary() {

		for (int i = 0; i < mask.length ; i++) {
			for (int j = 0; j < mask[0].length; j++) {
				if(mask[i][j]==-1) {
					return new Pixel(i,j);

				}
			}
		}
		return null;



	}










}
