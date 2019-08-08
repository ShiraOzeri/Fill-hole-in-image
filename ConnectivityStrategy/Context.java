package ConnectivityStrategy;
import java.util.HashSet;
import HoleFilling.Pixel;

public class Context {
	
	private ConnectivityStrategy strategy;
	private HashSet<Pixel> boundary;
	private HashSet<Pixel> hole;
	
	public Context(ConnectivityStrategy strategy) {
		this.strategy=strategy;
		this.boundary=new HashSet<>();
		this.hole=new HashSet<>();
	}
	
	/**
	 * return the connectivity pixel in the boundary
	 * @param mask
	 * @return the connectivity pixel in the boundary
	 */
	public HashSet<Pixel> getBoundary(int[][]mask) {
		for (int i = 0; i < mask.length; i++) {
			for (int j = 0; j < mask[0].length; j++) {
				if(mask[i][j]==-1) {
					hole.add(new Pixel(i,j));
					strategy.addToBoundary(i,j,boundary);
				}
			}
		}
		return boundary;
		
	}
	
	public HashSet<Pixel> getHole(){
		return this.hole;
	}
	
	public void getNeighbor(int i,int j,HashSet<Pixel> b){
		strategy.addToBoundary(i,j,b);
	}


}
