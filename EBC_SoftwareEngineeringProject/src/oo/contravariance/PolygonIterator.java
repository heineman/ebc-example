package oo.contravariance;

import java.util.Iterator;

class PolygonIterator implements Iterator<Point> {

	int idx;  // stage of the iteration.
	
	Polygon polygon;  // the aggregate which stores the data
	
	public PolygonIterator(Polygon polygon) {
		idx = 0;
		this.polygon = polygon;
	}

	public boolean hasNext() {
		return idx < polygon.numPoints;
	}

	public Point next() {
		return polygon.getPoint(idx++);
	}

	public void remove() {
		throw new UnsupportedOperationException("Can't help you");
	}

}
