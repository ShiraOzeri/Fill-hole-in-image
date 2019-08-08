package WeighteFactory;

import HoleFilling.Pixel;

public class WeightFunDefault extends WeightFun {

	public WeightFunDefault(double z, double e) {
		super(z, e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double weightFun(Pixel p1, Pixel p2) {
		double d=Math.sqrt(Math.pow(p1.getRow()-p2.getRow(), 2)+Math.pow(p1.getCol()-p2.getCol(), 2));
		d=((Math.pow(d, this.getZ()))+this.getE());
		return 1/d;
	
	}


	

}
