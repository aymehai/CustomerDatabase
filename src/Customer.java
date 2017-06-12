import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	private ResultSet companyRs;

	public Customer() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers?useSSL=false", "root", "password");
			st = con.createStatement();

		}

		catch (Exception ex) {
			System.out.println("Error: " + ex);
		}

	}

	public void getData(String lastName) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers?useSSL=false", "root", "password");
			st = con.createStatement();

			String query = "select * from customers where LastName = '" + lastName + "' ;";
			rs = st.executeQuery(query);

			/*
			int companyID = 667;
			String query2 = "select * from Company where companyID = " + companyID;
			companyRs = st.executeQuery(query2);
			*/

			System.out.println("Records from Database");
			while (rs.next()) {
				String fullName = rs.getString("FullName");
				String title = rs.getString("Title");
				String streetAddress = rs.getString("StreetAddress");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String zipCode = rs.getString("ZipCode");
				String email = rs.getString("EmailAddress");
				String position = rs.getString("Position");

				int companyID = rs.getInt("companyID");
				//String companyName = companyRs.getString("Company");

				System.out.println(title + fullName);
				System.out.println(streetAddress);
				System.out.println(city + ", " + state + zipCode);
				System.out.println(email);
				System.out.println(position + "at " + companyID);

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
