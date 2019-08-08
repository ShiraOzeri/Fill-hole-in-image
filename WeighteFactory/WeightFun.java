package WeighteFactory;

import HoleFilling.Pixel;

public abstract class WeightFun {
	
	private double z;
	private double e;
	


	public WeightFun(double z,double e) {
		this.z=z;
		this.e=e;
	}

	public double getZ() {
		return z;
	}

	public double getE() {
		return e;
	}
	
	/**
	 * abstract function to support any arbitrary weighting function.
	 * @param p1 pixel
	 * @param p2 pixel
	 * @return weighting function which assigns a non-negative float weight to a pair of two
pixel coordinates in the image
	 */
	public abstract double weightFun(Pixel p1, Pixel p2);
	
}
