

import javax.mail.*;
import java.util.Properties;

public class GmailUtility {


    public void checkGmail(String host, String storeType, String user, String password){

        try {

            String host1 = "pop.gmail.com";
            String storeType1 = "pop3";



            Properties properties = new Properties();
            properties.setProperty("mail.store.protocol","imaps");
            Session emailSession = Session.getDefaultInstance(properties);
            Store emailStore = emailSession.getStore("imaps");
            emailStore.connect("imap.gmail.com",user,password);

            Folder emailFolder = emailStore.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            Message messages[] = emailFolder.getMessages();
            for(int i=messages.length-3;i<messages.length;i++){
                Message message = messages[i];
                System.out.println("Email number: "+i+1);
                System.out.println("Subject"+message.getSubject());
            }

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }







    }
}
