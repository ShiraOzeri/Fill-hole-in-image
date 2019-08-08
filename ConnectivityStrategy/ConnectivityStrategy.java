package ConnectivityStrategy;

import java.util.HashSet;

import HoleFilling.Pixel;

public interface ConnectivityStrategy {
	
	/**
	 * Check if Pixel(r,c) in the Boundary and add it if yes.
	 * @param r row
	 * @param c column
	 * @param boundary list of connectivity(4 or 8) pixel
	 */
	void addToBoundary(int r, int c, HashSet<Pixel> boundary);

}
