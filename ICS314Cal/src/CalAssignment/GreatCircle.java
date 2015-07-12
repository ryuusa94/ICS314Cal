package CalAssignment;

/**
 * GreatCircle
 * Calculates distance between two locations given their positions in decimal degrees.
 * 
 * NOT INTEGRATED IN PROJECT YET
 * 
 * Referenced:
 * http://edndoc.esri.com/arcobjects/9.0/Samples/Geometry/Great_Circle_Distance.htm
 * http://introcs.cs.princeton.edu/java/12types/GreatCircle.java.html
 * @author TeamElara
 */
public class GreatCircle {

	//Length of a degree in various units of distance.
	private double milesPerDegree = 69.05;
	private double kmPerDegree = 111.12;
	
	public double circleDistance(double lat1, double lon1, 
			double lat2, double lon2) {
		
		//Converting decimal degrees to radians for calculation.
		double radLat1 = Math.toRadians(lat1);
		double radLon1 = Math.toRadians(lon1);
		double radLat2 = Math.toRadians(lat2);
		double radLon2 = Math.toRadians(lon2);
		
		//Calculating distance in radians.
		double distance = Math.acos( Math.sin(radLat1) * Math.sin(radLat2) + 
				Math.cos(radLat1) * Math.cos(radLat2) * Math.cos(radLon1 - radLon2) );
		
		//Converting back to decimal degrees.
		distance = Math.toDegrees(distance);
		
		//rounded to two decimal places
		return (Math.round(distance * 100.0) / 100.0 );
	}
	
	/**
	 * miles
	 * Converts distance between two locations using latitude and longitude
	 * @param lat1, location 1 latitude
	 * @param lon1, location 1 longitude
	 * @param lat2, location 2 latitude
	 * @param lon2, location 2 longitude
	 * @return, distance in miles
	 */
	public double miles(double lat1, double lon1,
			double lat2, double lon2) {
		
		return circleDistance(lat1, lon1, lat2, lon2) * milesPerDegree;
	}
	
	/**
	 * km
	 * Converts distance between two locations using latitude and longitude
	 * @param lat1, location 1 latitude
	 * @param lon1, location 1 longitude
	 * @param lat2, location 2 latitude
	 * @param lon2, location 2 longitude
	 * @return, distance in kilometers
	 */
	public double km(double lat1, double lon1,
			double lat2, double lon2) {
		
		return circleDistance(lat1, lon1, lat2, lon2) * kmPerDegree;
	}

}
