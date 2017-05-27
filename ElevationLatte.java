package Noah.ElevationLatte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Hello world!
 *
 */
public class ElevationLatte {
	private String elevation;
	
	
	public String elevation(){
		return elevation;
	}
	
	public static ElevationLatte fetch(double latitude, double longitude){

		String uri = "https://maps.googleapis.com/maps/api/elevation/json?locations=" + latitude + "," + longitude + "&key=AIzaSyCO2g9ogjAmJ9G-ObH63Zd6DHt-eH0cxL4";

		try 
		{
			URLConnection mp = new URL (uri).openConnection();
			BufferedReader in = new BufferedReader ( new InputStreamReader ( mp.getInputStream() ));

			ElevationLatte l = new ElevationLatte();
//			l.number = num;
			l.elevation = in.readLine();

			in.close();

			return l;
		} catch(MalformedURLException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}	

}

