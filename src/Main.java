import generated.AccountType;
import generated.MonthlyRentItemsType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(MonthlyRentItemsType.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            MonthlyRentItemsType accounts = (MonthlyRentItemsType) unmarshaller.unmarshal(new FileInputStream("xmlFiles/fileOne.xml"));

            List<AccountType> account = accounts.getAccounts().getAccount();

            for(AccountType acc: account) {
                System.out.println(acc.getFirstName());
            }
        } catch(JAXBException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("Hello World");
    }
}
