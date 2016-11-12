import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Registration {

	public static void main(String args[]) {

		HttpURLConnection conn;
		OutputStream os;
		BufferedReader br;

		try {

			URL url = new URL("http://challenge.code2040.org/api/register");

			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"token\":\"0a94f3291a3ab0f62d6fdfaf2b47b1ef\",\"github\":\"https://github.com/osmelcontreras/osmelcontreras\"}";
			System.out.println(input);

			os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from server: ");
			while((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
