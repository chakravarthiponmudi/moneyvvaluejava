import java.util.List;

import com.moneyvalue.datamapper.FamilyMapper;
import com.moneyvalue.domain.Family;
import com.moneyvalue.domain.Person;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Family family = FamilyMapper.getFamily();
		List<Person> person = family.getMembers();
		System.out.print(family);
	}

}
