package ro.exenne.twitter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by julianghionoiu on 09/12/2014.
 */
public class HelloBrindu {

    public static void main(String[] args) throws IOException {
        Twitter ex3 = new Twitter();

        String s;
//        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));        
//        while (true) {
//            s = buff.readLine();
//            if (s.contains("EXIT")) {
//                break;
//            } else {
//                try {
//                    ex3.tweet(s);
//                } catch (InvalidUserException | ProfileNotSetException |
//                        InvalidEditProfileInputException |
//                        InvalidPhoneNrFormatException |
//                        InvalidMailFormatException ex) {
//                    System.exit(1);
//                   }
//            }
//
//        }
        String filename;

        for (int i = 1; i <= 5; i++) {
            ex3 = new Twitter();
            filename = "Scenario" + i + ".in";
            try {
                ex3.readFile(filename);
                String compareFile = "Scenario" + i + ".ok";
                System.out.println("Pentru testul " + i + ", rezultatul este: ");
                System.out.println(ex3.compareFiles(compareFile, "Scenario.out"));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidUserException ex) {
                Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
