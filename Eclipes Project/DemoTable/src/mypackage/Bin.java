package mypackage;

import java.util.ArrayList;
import java.util.List;

public class Bin {
	public static List<Users> ExportUsers(){
		List<Users> list = new ArrayList<Users>();
		list.add(new Users("Thinh", "Cong tac vien"));
		list.add(new Users("New demo table", "Value"));
		return list;
	}
}
