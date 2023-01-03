package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;

public class Runner {
	public static void getEventsLog() throws MalformedURLException {
        URL url = new URL("https://api.marketalertum.com/EventsLog/2f7894be-442b-41cc-aad0-a3b04a7a6891");
        HttpURLConnection con;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                System.out.println(content.append(inputLine));
            }
            in.close();
            con.disconnect();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void deleteAlerts() throws MalformedURLException {
        URL url = new URL("https://api.marketalertum.com/Alert?userId=2f7894be-442b-41cc-aad0-a3b04a7a6891");
        HttpURLConnection con;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");
            BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                System.out.println(content.append(inputLine));
            }
            in.close();
            con.disconnect();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void createAlert() throws MalformedURLException{
        URL url = new URL("https://api.marketalertum.com/Alert");
        HttpURLConnection con;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            String jsonInputString = "{\"alertType\": 4,\"heading\": \"Jumper Windows 11 Laptop\",\"description\": \"Jumper Windows 11 Laptop 1080P Display,12GB RAM 256GB SSD\",\"url\": \"https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth\",\"imageUrl\": \"https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg\",\"postedBy\": \"2f7894be-442b-41cc-aad0-a3b04a7a6891\",\"priceInCents\": 24999}";
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);			
            }
            
            try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
                  StringBuilder response = new StringBuilder();
                  String responseLine = null;
                  while ((responseLine = br.readLine()) != null) {
                      response.append(responseLine.trim());
                  }
                  System.out.println(response.toString());
            }
            
            con.disconnect();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void main (String args[]) throws MalformedURLException{
    	Scanner sc = new Scanner(System.in);
        int num = 0;
        do{
            System.out.println("--MENU--");
            System.out.println("1. Create Alert");
            System.out.println("2. Delete Alerts");
            System.out.println("3. Exit");
            System.out.println("Enter choice: ");
            num = sc.nextInt();
            
            if(num == 1){
                createAlert();
            }else if(num == 2){
                deleteAlerts();
            }else if(num == 3){
                break;
            }else{
                System.out.println("Wrong Input.");
            }
        }while(num != 3);
        getEventsLog();
    	
    }
    
    
}
