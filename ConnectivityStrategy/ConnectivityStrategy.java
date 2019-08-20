package ConnectivityStrategy;

import java.util.HashSet;

import HoleFilling.Pixel;

public interface ConnectivityStrategy {
	

	/**
	 * Adds the Pixel P neighbors that are not holes to the boundaries.
	 * @param p hole pixel
	 * @param boundary list of connectivity(4 or 8) pixel
	 */
	void addToBoundary(Pixel p, HashSet<Pixel> boundary);

}
