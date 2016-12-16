/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


public class Haversine {
    private final static int R = 3959;
    public static Double getDistance(String la1, String lo1, String la2, String lo2) {
        // TODO Auto-generated method stub
         // Radious of the earth
        Double lat1 = Double.parseDouble(la1);
        Double lon1 = Double.parseDouble(lo1);
        Double lat2 = Double.parseDouble(la2);
        Double lon2 = Double.parseDouble(lo2);
        Double latDistance = toRad(lat2-lat1);
        Double lonDistance = toRad(lon2-lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;

        return distance;

    }

    public static Double getDistance(double lat1, double lon1, double lat2, double lon2) {
        // TODO Auto-generated method stub
        Double latDistance = toRad(lat2-lat1);
        Double lonDistance = toRad(lon2-lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;

        return distance;

    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

    private static Double toRad(Float value) {
        return value * Math.PI / 180;
    }

}
