package HoleFilling;

import java.util.HashSet;
import ConnectivityStrategy.Context;
import ConnectivityStrategy.EightConnectivity;
import ConnectivityStrategy.FourConnectivity;
import WeighteFactory.WeightFun;
import WeighteFactory.WeightFunFactory;

public class HoleFilling {


	private Picture picture;
	private int[][] mask;
	private Context strategy;
	private WeightFun weight_fun;
	



	/**
	 * Constructor to HoleFilling
	 * @param picture Image with the hole
	 * @param mask Sign the pixels with the hole
	 * @param connectivity 4 or 8 connectivity
	 * @param z for the weightFun
	 * @param e for the weightFun
	 */
	public HoleFilling(Picture picture,int[][]mask,int connectivity ,double z,double e) {
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
	 * The main Algo
	 * @return Picture after filling the hole
	 */
	public Picture holeFillingAlgo() {
		Picture fill_image =new Picture(picture);
		double sum_n=0;
		double sum_m=0;
		double weight=0;

		HashSet<Pixel> connect =strategy.getBoundary(mask);
		HashSet<Pixel> hole=strategy.getHole();
		for (Pixel p : hole) {
			sum_n=0;
			sum_m=0;
			for (Pixel p_c : connect) {
				weight=weight_fun.weightFun(p,p_c);
				sum_n+=weight*picture.getPixel(p_c);
				sum_m+=weight;

			}
			float val=(float) (sum_n/sum_m);
			fill_image.setPixel(p.getRow(),p.getCol(),val);

		}

		return fill_image;



	}


}









