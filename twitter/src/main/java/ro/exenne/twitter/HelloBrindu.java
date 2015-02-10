package ro.exenne.twitter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloBrindu {

    public static void main(String[] args) throws IOException, ProfileNotSetException, InvalidUserException {
        Twitter twitter = new Twitter();
        twitter.readCommand(new StandardInput(twitter));

    }

    private static class StandardInput implements InputHandler {

        Twitter twitter;

        StandardInput(Twitter twitter) {
            this.twitter = twitter;
        }

        @Override
        public void read() {
            String s = null;
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                try {
                    s = buff.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (s.contains("EXIT")) {
                    break;
                } else {
                    try {
                        this.twitter.tweet(s, new StandardOutput());
                    } catch (InvalidUserException ex) {
                        Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ProfileNotSetException ex) {
                        Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidEditProfileInputException ex) {
                        Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidPhoneNrFormatException ex) {
                        Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidMailFormatException ex) {
                        Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    private static class StandardOutput implements OutputHandler {

        @Override
        public void publish(String s) {
            System.out.println(s);
        }
    }
}
