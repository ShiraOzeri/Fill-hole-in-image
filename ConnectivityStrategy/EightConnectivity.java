package ConnectivityStrategy;

import java.util.Arrays;
import java.util.HashSet;

import HoleFilling.Pixel;

public class EightConnectivity implements ConnectivityStrategy {

	private int[][] mask;


	public EightConnectivity(int[][] mask) {
		this.mask=mask;
	}


	
	@Override
	
	public void addToBoundary(Pixel pixel, HashSet<Pixel> boundary) {

		for (int i : Arrays.asList(-1, 0, 1)) {
			for (int j : Arrays.asList(-1, 0, 1)) {
				if (i == 0 && j == 0) continue;
				Pixel p=new Pixel(pixel.getRow()+i,pixel.getCol()+j);
				if(mask[pixel.getRow()+i][pixel.getCol()+j]!=-1 && !boundary.contains(p) ) {
					boundary.add(p);
				}
			}
		}
	}




}






