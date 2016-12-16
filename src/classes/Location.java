package classes;

import com.maxmind.geoip.LookupService;
import com.sun.corba.se.spi.activation.LocatorPackage.ServerLocation;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 
 * @author Atif Hassan
 */
public class Location {
    public static String latitude;
    public static String longitude;

    public static String getLatitude(){
        getLocation();
    return latitude;
    }
    public static String getLongitude(){
        getLocation();
        return longitude;
    }
    public static String getIP(){
        String ipAddress = "";
        try
        {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
            String ipAdd = in.readLine(); //you get the IP as a String
            ipAddress = ipAdd;
           // System.out.println(ipAdd);
            /**SearchController obj2 = new SearchController();
            ServerLocation location2 = obj2.getLocation(ipAddress);
            serverLocation = location2;
            System.out.println(location2);*/
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return ipAddress;
    }
    private static void getLocation() {
        String ipAddress = getIP();
        File file = new File(new File("").getAbsolutePath() + "\\GeoLiteCity.dat");
        getLocation(ipAddress, file);

    }

    private static void getLocation(String ipAddress, File file) {

        ServerLocation serverLocation = null;

        try {

            serverLocation = new ServerLocation();

            LookupService lookup = new LookupService(file,LookupService.GEOIP_MEMORY_CACHE);
            com.maxmind.geoip.Location locationServices = lookup.getLocation(ipAddress);

           /** serverLocation.setCountryCode(locationServices.countryCode);
            serverLocation.setCountryName(locationServices.countryName);
            serverLocation.setRegion(locationServices.region);
            serverLocation.setRegionName(regionName.regionNameByCode(
                    locationServices.countryCode, locationServices.region));
            serverLocation.setCity(locationServices.city);
            serverLocation.setPostalCode(locationServices.postalCode);
            serverLocation.setLatitude(String.valueOf(locationServices.latitude));
            serverLocation.setLongitude(String.valueOf(locationServices.longitude));*/
            latitude = String.valueOf(locationServices.latitude);
            longitude = String.valueOf(locationServices.longitude);
            //System.out.println(latitude + " " + longitude);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }
}
