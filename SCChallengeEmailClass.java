import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.NullPointerException;

public class SCChallengeEmailClass {
	public static void main(String[] args)throws MalformedURLException, IOException {
		try {
			String link = "https://www.ecs.soton.ac.uk/people/" + textInput("Enter the username: ");
			URL url = new URL(link);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String line;
			String intent = "property=\"name\">";
			
			while (!(line = br.readLine()).contains(intent));
			
			int pos = line.indexOf(intent) + 16;
			while (!line.substring(pos, pos+1).contains("<")) {
				System.out.print(line.substring(pos, pos+1));
				pos++;
			}
			System.out.println();
			br.close();
			
		}
		catch (NullPointerException e){
			System.out.println("The username you entered does not have a page.");
		}
	}
	
	public static String textInput(String request) throws IOException{
		System.out.println(request);
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader ir = new BufferedReader(in);
		String temp = ir.readLine();
		return temp;
	}
}