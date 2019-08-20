package HoleFilling;


public class Pixel {

	private int row;
	private int col;

	/**
	 * Describe the coordinate of the pixel in a picture
	 * @param row
	 * @param col
	 */
	public Pixel(int row, int col) {
		this.row=row;
		this.col=col;

	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Pixel)) {
            return false;
        }

        Pixel pixel = (Pixel) o;

        return pixel.row==this.row && pixel.col==this.col;
    }

    @Override
    public int hashCode() {
    	String str=this.row+","+this.col;
        return str.hashCode(); //65536*this.row + this.col;
    }

	

}
	
