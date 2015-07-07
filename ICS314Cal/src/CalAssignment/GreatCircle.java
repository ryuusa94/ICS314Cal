package CalAssignment;

/*
 * GreatCircle
 * Calculates distance between two locations given their positions in decimal degrees.
 * 
 * NOT INTEGRATED IN PROJECT YET
 * 
 * Referenced:
 * http://edndoc.esri.com/arcobjects/9.0/Samples/Geometry/Great_Circle_Distance.htm
 * http://introcs.cs.princeton.edu/java/12types/GreatCircle.java.html
 */
public class GreatCircle {

	//Length of a degree in various units of distance.
	private static double milesPerDegree = 69.05;
	private static double kmPerDegree = 111.12;
	
	//testing only
	public static void main(String[] args) {
		
		System.out.println("Straight line distance from campus to Kapiolani park (in miles): " + 
				circleDistance(21.298307, -157.816023, 21.267356, -157.819414));
		
	}

	
	public static double circleDistance(double lat1, double lon1, 
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
		
		
        return ( distance * milesPerDegree ); //change to kmPerDegree for distance in km
		
	}

}
