
package dao;

import bean.Student;
import static dao.GetConnectDB.getConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDB {

	public static int newStudent(Student newst) {
		try (Connection con = getConnect()) {
			PreparedStatement stmt = con.prepareStatement(
					"Insert into Student(StudentName, StudentGender, StudentDoB) output inserted.StudentID values(?,?,?)");
			stmt.setString(1, newst.getName());
			stmt.setInt(2, newst.getGender());
			stmt.setDate(3, newst.getDob());
			stmt.execute();
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return 0;
	}

	public static int updateStudent(Student upst) {
		try (Connection con = getConnect()) {
			con.setAutoCommit(false);
            PreparedStatement stmt= con.prepareStatement("Update Student set StudentName=?,StudentGender=?,StudentDoB=? where StudentID=?"); // Should use
            stmt.setString(1, upst.getName());
            stmt.setInt(2, upst.getGender());
            stmt.setDate(3, upst.getDob());
            stmt.setInt(4, upst.getId());
            stmt.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return 0;
	}

	public static ArrayList<Student> listAll() {
		ArrayList<Student> result = new ArrayList<Student>();
		try (Connection con = GetConnectDB.getConnect()) {
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			ResultSet re = stmt.executeQuery("Select StudentID, StudentName, StudentGender, StudentDoB from Student");
			while (re.next()) {
				int id = re.getInt(1);
				String name = re.getString(2);
				int gender = re.getInt(3);
				String dob = re.getDate(4).toString();
				result.add(new Student(id, name, gender, dob));
			}
			con.commit();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static void deleteStudent(int id) {
		try (Connection con = getConnect()) {
			String sql = "delete from Student where StudentID=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static Student getStudent(int id) {
		Student stu = null;
		try (Connection con = getConnect()) {
			Statement stmt= con.createStatement(); 
            ResultSet rs=stmt.executeQuery("Select StudentID,StudentName,StudentGender,StudentDoB from Student where StudentID='"+id+"'"); 
            if(rs.next()){
                String name=rs.getString(2);  
                int gender=rs.getInt(3); 
                String dob=rs.getString(4).toString(); 
                stu = new Student(id,name,gender,dob);
            }
            con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return stu;
	}
}
