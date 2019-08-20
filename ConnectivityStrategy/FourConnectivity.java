package ConnectivityStrategy;

import java.util.HashSet;

import HoleFilling.Pixel;


public class FourConnectivity implements ConnectivityStrategy {

	private int[][] mask;


	public FourConnectivity(int[][] mask) {
		this.mask=mask;
	}

	@Override
	public void addToBoundary(Pixel p, HashSet<Pixel> boundary) {
		int r=p.getRow();
		int c=p.getCol();


		if(mask[r+1][c]!=-1) {
			Pixel p1=new Pixel(r+1, c);
			if(!boundary.contains(p1)) boundary.add(p1);
		}
		if(mask[r][c+1]!=-1) {
			Pixel p2=new Pixel(r, c+1);
			if(!boundary.contains(p2)) boundary.add(p2);
		}
		if(mask[r-1][c]!=-1) {
			Pixel p3=new Pixel(r-1, c);
			if(!boundary.contains(p3)) boundary.add(p3);
		}
		if(mask[r+1][c]!=-1) {
			Pixel p4=new Pixel(r+1, c);
			if(!boundary.contains(p4)) boundary.add(p4);
		}


	}
}
