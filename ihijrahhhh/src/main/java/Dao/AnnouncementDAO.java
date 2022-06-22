package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Announcement;
import db.ConnectionManager;



public class AnnouncementDAO {

	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	int Id;
	String Detail;
	String Date;


	
	//add Customer
		public void addCust(Announcement c) {
			Id = c.getAnnouncement_ID();
			Detail = c.getAnnouncement_Detail();
			Date  = c.getAnnouncement_Date();

			
			try {			
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				ps = con.prepareStatement("INSERT INTO announcement(announcement_id,announcement_detail,announcement_date)VALUES(?,?,?)");
				
				ps.setInt(1, Id);
				ps.setString(2, Detail);
				ps.setString(3, Date);

				
				//4. execute query
				ps.executeUpdate();
				System.out.println("Successfully inserted");
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}	
		

		
		//get all Customer
		public static List<Announcement> getAllCust(){
			List<Announcement> announce = new ArrayList<Announcement>();
			
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement 
				stmt = con.createStatement();
				String sql = "SELECT * FROM announcement ORDER BY announcement_id";
				
				//4. execute query
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {		//process result
					Announcement announcement = new Announcement();
					announcement.setAnnouncement_ID(rs.getInt("Id"));
					announcement.setAnnouncement_Detail(rs.getString("Detail"));
					announcement.setAnnouncement_Date(rs.getString("Date"));
					announce.add(announcement);
				}
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			
				
			}
			
			return announce;
		}
		

			
		//get customer by id
		public static Announcement getCustomerById(int id) {
			Announcement announce = new Announcement();
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement 
				ps = con.prepareStatement("SELECT * FROM announcement WHERE announcement_id=?");
				ps.setInt(1, id);
				
				//4. execute query
				rs = ps.executeQuery();
				if(rs.next()) {
					announce.setAnnouncement_ID(rs.getInt("Id"));
					announce.setAnnouncement_Detail(rs.getString("Name"));
					announce.setAnnouncement_Date(rs.getString("Email"));

				}
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();	
			}			
			return announce;
		}
		
	
	
		//delete customer	
		public void deleteCust(int id) {
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement 			
				ps = con.prepareStatement("DELETE FROM announcement WHERE announcement_id=?");
				ps.setInt(1, id);
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();	
			}			
		}
		
		//delete service	
		public void deleteServ(int id) {
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();

				//3. create statement 			
				ps = con.prepareStatement("DELETE FROM announcement WHERE announcement_id=?");
				ps.setInt(1, id);

				//4. execute query
				ps.executeUpdate();

				//5. close connection
				con.close();

			}catch(Exception e) {
				e.printStackTrace();	
			}			
		}
		
		//update customer
		public void updateCust(Announcement bean) {

			Id = bean.getAnnouncement_ID();
			Detail = bean.getAnnouncement_Detail();
			Date  = bean.getAnnouncement_Date();


			try {			
				//call getConnection() method
				con = ConnectionManager.getConnection();

				//3. create statement
				ps = con.prepareStatement("UPDATE `announcement` SET `announcement_detail`=?,`announcement_date`=? WHERE `announcement_id`=?");

				ps.setString(1, Detail);
				ps.setString(2, Date);
				ps.setInt(3, Id);

				//4. execute query
				ps.executeUpdate();

				System.out.println("Successfully updated");

				//5. close connection
				con.close();

			}catch(Exception e) {
				e.printStackTrace();

			}
		} 
		
	
		}


