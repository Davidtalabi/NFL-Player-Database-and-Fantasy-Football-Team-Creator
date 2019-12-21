import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class Test {

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        Connection connection;
        String isQuit = "n";

        System.out.println("Welcome to the NFL database, pick an option, any option!");
        System.out.println();

        try {
        	connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\davet\\Downloads\\SQLiteStudio-3.2.1\\SQLiteStudio\\2019NFLStats");
            Statement stat = connection.createStatement();
            PreparedStatement pStat = null;

            while (!isQuit.equals("Y") && !isQuit.equals("y")) {
                int runNumber = -1;
 
                System.out.println("What would you like to do?");
                System.out.println("1. Add a quarterback to the database.");
                System.out.println("2. Add a runningback to the database.");
                System.out.println("3. Add a wide receiver to the database.");
                System.out.println("4. Add a tight end to the database.");
                System.out.println("5. Add a linebacker to the database.");
                System.out.println("6. Add a defensive back to the database.");
                System.out.println("7. Add a user to the database");
                System.out.println("8. Add a fantasy team to the database");
                System.out.println("9. Delete a quarterback from the database.");
                System.out.println("10. Delete a runningback from the database.");
                System.out.println("11. Delete a wide receiver from the database.");
                System.out.println("12. Delete a tight end from the database.");
                System.out.println("13. Delete a linebacker from the database.");
                System.out.println("14. Delete a defensiveback from the database.");
                System.out.println("15. Delete a user from the database.");
                System.out.println("16. Delete a fantasy team from the database.");

                System.out.println("17. View Quarterback Stats");
                System.out.println("18. View Runningback Stats");
                System.out.println("19. View Wide Receiver Stats");
                System.out.println("20. View Tight End Stats");
                System.out.println("21. View Linebacker Stats");
                System.out.println("22. View Defensiveback Stats");


                runNumber = input.nextInt();
                input.nextLine();
                if (runNumber == 1) {
                    addqb(input, connection);
                }
                else if (runNumber == 2) { 
                    addrb(input, connection);
                }
                else if (runNumber == 3) { 
                    addwr(input, connection);
                }
                else if (runNumber == 4) { 
                    addte(input, connection);
                }
                else if (runNumber == 5) { 
                    addlb(input, connection);
                }
                else if (runNumber == 6) { 
                    adddb(input, connection);
                }
                else if (runNumber == 7) { 
                    adduser(input, connection);
                }
                else if (runNumber == 8) { 
                    createfantasyteam(input, connection);
                }
                else if (runNumber == 9) { 
                    deleteqb(input, connection);
                }
                else if (runNumber == 10) { 
                    deleterb(input, connection);
                }
                else if (runNumber == 11) { 
                    deletewr(input, connection);
                }
                else if (runNumber == 12) { 
                    deletete(input, connection);
                }
                else if (runNumber == 13) { 
                    deletelb(input, connection);
                }
                else if (runNumber == 14) { 
                    deletedb(input, connection);
                }
                else if (runNumber == 15) { 
                    deleteuser(input, connection);
                }
                else if (runNumber == 16) { 
                    deletefantasyteam(input, connection);
                }
                else if (runNumber == 17) {
                    ResultSet rs;
                    pStat = connection.prepareStatement("SELECT qb_team,qb_age,qb_passyds,qb_passtd,qb_intthrown FROM quarterback WHERE qb_name = ?");
                    System.out.print("Which qb stats do you want to see? Don't forget to capitalize first letter of their first and last name! ");
                    String qb_name = input.nextLine();
                    pStat.setString(1, qb_name);
                    rs = pStat.executeQuery();
                    while (rs.next()) {
                        System.out.println("Here are the stats for: " + qb_name);
                        System.out.println("qb_team = " + rs.getString("qb_team"));
                        System.out.println("qb_age = " + rs.getString("qb_age"));
                        System.out.println("qb_passyds = " + rs.getString("qb_passyds"));
                        System.out.println("qb_passtd = " + rs.getString("qb_passtd"));
                        System.out.println("qb_intthrown = " + rs.getString("qb_intthrown"));
                    }
                    stat.close();
                    rs.close();
                }
                else if (runNumber == 18) {
                    ResultSet rs;
                    pStat = connection.prepareStatement("SELECT rb_team,rb_age,rb_rushyds,rb_rushtd,rb_fumbles FROM runningback WHERE rb_name = ?");
                    System.out.print("Which rb stats do you want to see? Don't forget to capitalize first letter of their first and last name! ");
                    String rb_name = input.nextLine();
                    pStat.setString(1, rb_name);
                    rs = pStat.executeQuery();
                    while (rs.next()) {
                        System.out.println("Here are the stats for: " + rb_name);
                        System.out.println("rb_team = " + rs.getString("rb_team"));
                        System.out.println("rb_age = " + rs.getString("rb_age"));
                        System.out.println("rb_rushyds = " + rs.getString("rb_rushyds"));
                        System.out.println("rb_rushtd = " + rs.getString("rb_rushtd"));
                        System.out.println("rb_fumbles = " + rs.getString("rb_fumbles"));
                    }
                    stat.close();
                    rs.close();
                }
                else if (runNumber == 19) {
                    ResultSet rs;
                    pStat = connection.prepareStatement("SELECT wr_team,wr_age,wr_recyds,wr_rectd,wr_fumbles FROM widereceiver WHERE wr_name = ?");
                    System.out.print("Which wr stats do you want to see? Don't forget to capitalize first letter of their first and last name! ");
                    String wr_name = input.nextLine();
                    pStat.setString(1, wr_name);
                    rs = pStat.executeQuery();
                    while (rs.next()) {
                        System.out.println("Here are the stats for: " + wr_name);
                        System.out.println("wr_team = " + rs.getString("wr_team"));
                        System.out.println("wr_age = " + rs.getString("wr_age"));
                        System.out.println("wr_recyds = " + rs.getString("wr_recyds"));
                        System.out.println("wr_rectd = " + rs.getString("wr_rectd"));
                        System.out.println("wr_fumbles = " + rs.getString("wr_fumbles"));
                    }
                    stat.close();
                    rs.close();
                }
                else if (runNumber == 20) {
                    ResultSet rs;
                    pStat = connection.prepareStatement("SELECT te_team,te_age,te_recyds,te_rectd,te_fumbles FROM tightend WHERE te_name = ?");
                    System.out.print("Which te stats do you want to see? Don't forget to capitalize first letter of their first and last name! ");
                    String te_name = input.nextLine();
                    pStat.setString(1, te_name);
                    rs = pStat.executeQuery();
                    while (rs.next()) {
                        System.out.println("Here are the stats for: " + te_name);
                        System.out.println("te_team = " + rs.getString("te_team"));
                        System.out.println("te_age = " + rs.getString("te_age"));
                        System.out.println("te_recyds = " + rs.getString("te_recyds"));
                        System.out.println("te_rectd = " + rs.getString("te_rectd"));
                        System.out.println("te_fumbles = " + rs.getString("te_fumbles"));
                    }
                    stat.close();
                    rs.close();
                }
                else if (runNumber == 21) {
                    ResultSet rs;
                    pStat = connection.prepareStatement("SELECT lb_team,lb_age,lb_passdeflections,lb_sacks,lb_tackles FROM linebacker WHERE lb_name = ?");
                    System.out.print("Which lb stats do you want to see? Don't forget to capitalize first letter of their first and last name! ");
                    String lb_name = input.nextLine();
                    pStat.setString(1, lb_name);
                    rs = pStat.executeQuery();
                    while (rs.next()) {
                        System.out.println("Here are the stats for: " + lb_name);
                        System.out.println("lb_team = " + rs.getString("lb_team"));
                        System.out.println("lb_age = " + rs.getString("lb_age"));
                        System.out.println("lb_passdeflections = " + rs.getString("lb_passdeflections"));
                        System.out.println("lb_sacks = " + rs.getString("lb_sacks"));
                        System.out.println("lb_tackles = " + rs.getString("lb_tackles"));
                    }
                    stat.close();
                    rs.close();
                }
                else if (runNumber == 22) {
                    ResultSet rs;
                    pStat = connection.prepareStatement("SELECT db_team,db_age,db_passdeflections,db_sacks,db_tackles FROM defensiveback WHERE db_name = ?");
                    System.out.print("Which db stats do you want to see? Don't forget to capitalize first letter of their first and last name! ");
                    String db_name = input.nextLine();
                    pStat.setString(1, db_name);
                    rs = pStat.executeQuery();
                    while (rs.next()) {
                        System.out.println("Here are the stats for: " + db_name);
                        System.out.println("db_team = " + rs.getString("db_team"));
                        System.out.println("db_age = " + rs.getString("db_age"));
                        System.out.println("db_passdeflections = " + rs.getString("db_passdeflections"));
                        System.out.println("db_sacks = " + rs.getString("db_sacks"));
                        System.out.println("db_tackles = " + rs.getString("db_tackles"));
                    }
                    stat.close();
                    rs.close();
                }
                System.out.println("Would you like to exit? (Y/n)");
                isQuit = input.nextLine();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addqb(Scanner input, Connection connection) throws SQLException {
        String qb_name;
        String qb_team;
        String qb_age;
        String qb_position = "QB";
        String qb_gp;
        String qb_att;
        String qb_passyds;
        String qb_passtd;
        String qb_intthrown;
        PreparedStatement pStat;

        System.out.println("Enter qb name: ");
        qb_name = input.nextLine();
        
        System.out.println("Enter qb Real life team: ");
        qb_team = input.nextLine();
        
        System.out.println("Enter qb age: ");
        qb_age = input.nextLine();
        
        System.out.println("Enter qb number of games played: ");
        qb_gp = input.nextLine();
        
        System.out.println("Enter qb pass attemps: ");
        qb_att = input.nextLine();
        
        System.out.println("Enter qb pass yards: ");
        qb_passyds = input.nextLine();
        
        System.out.println("Enter qb pass touchdowns: ");
        qb_passtd = input.nextLine();
        
        System.out.println("Enter qb interceptions thrown: ");
        qb_intthrown = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("INSERT INTO quarterback VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pStat.setString(1, qb_name);
        pStat.setString(2, qb_team);
        pStat.setString(3, qb_age);
        pStat.setString(4, qb_position);
        pStat.setString(5, qb_gp);
        pStat.setString(6, qb_att);
        pStat.setString(7, qb_passyds);
        pStat.setString(8, qb_passtd);
        pStat.setString(9, qb_intthrown);
        pStat.executeUpdate();
        pStat.close();
    }
 
    private static void addrb(Scanner input, Connection connection) throws SQLException {
        String rb_name;
        String rb_team;
        String rb_age;
        String rb_position = "RB";
        String rb_gp;
        String rb_att;
        String rb_rushyds;
        String rb_rushtd;
        String rb_fumbles;
        PreparedStatement pStat;

        System.out.println("Enter rb name: ");
        rb_name = input.nextLine();
        
        System.out.println("Enter rb Real life team: ");
        rb_team = input.nextLine();
        
        System.out.println("Enter rb age: ");
        rb_age = input.nextLine();
        
        System.out.println("Enter rb number of games played: ");
        rb_gp = input.nextLine();
        
        System.out.println("Enter rb rush attempts: ");
        rb_att = input.nextLine();
        
        System.out.println("Enter rb rush yards: ");
        rb_rushyds = input.nextLine();
        
        System.out.println("Enter rb rush touchdowns: ");
        rb_rushtd = input.nextLine();
        
        System.out.println("Enter rb fumbles: ");
        rb_fumbles = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("INSERT INTO runningback VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pStat.setString(1, rb_name);
        pStat.setString(2, rb_team);
        pStat.setString(3, rb_age);
        pStat.setString(4, rb_position);
        pStat.setString(5, rb_gp);
        pStat.setString(6, rb_att);
        pStat.setString(7, rb_rushyds);
        pStat.setString(8, rb_rushtd);
        pStat.setString(9, rb_fumbles);
        pStat.executeUpdate();
        pStat.close();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static void adduser(Scanner input, Connection connection) throws SQLException {
        String user_name;
        String team_name;
        PreparedStatement pStat;

        System.out.println("Enter username: ");
        user_name = input.nextLine();
        
        System.out.println("Enter Fantasy team name: ");
        team_name = input.nextLine();
        
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("INSERT INTO users VALUES (?, ?)");
        pStat.setString(1, user_name);
        pStat.setString(2, team_name);
        pStat.executeUpdate();
        pStat.close();
    }
    
    
    
    private static void createfantasyteam(Scanner input, Connection connection) throws SQLException {
        String team_name;
        String qb_name;
        String rb_name;
        String te_name;
        String wr_name;
        String db_name;
        String lb_name;
        PreparedStatement pStat;

        System.out.println("Enter fantasy team name: ");
        team_name = input.nextLine();
        
        System.out.println("Enter fantasy team qb: ");
        qb_name = input.nextLine();
        
        System.out.println("Enter fantasy team rb: ");
        rb_name = input.nextLine();
        
        System.out.println("Enter fantasy team wr: ");
        wr_name = input.nextLine();
        
        System.out.println("Enter fantasy team te: ");
        te_name = input.nextLine();
        
        System.out.println("Enter fantasy team db: ");
        db_name = input.nextLine();
        
        System.out.println("Enter fantasy team lb: ");
        lb_name = input.nextLine();
        
        
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("INSERT INTO jointeam VALUES (?, ?, ?, ?, ?, ?, ?)");
        pStat.setString(1, team_name);
        pStat.setString(2, qb_name);
        pStat.setString(3, rb_name);
        pStat.setString(4, te_name);
        pStat.setString(5, wr_name);
        pStat.setString(6, db_name);
        pStat.setString(7, lb_name);
        pStat.executeUpdate();
        pStat.close();
    }
    private static void deleteqb(Scanner input, Connection connection) throws SQLException {

        String qb_name;

        PreparedStatement pStat;

        System.out.println("Enter qb name to delete: ");
        qb_name = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("DELETE FROM quarterback WHERE qb_name = ?");

        pStat.setString(1, qb_name);

        pStat.executeUpdate();
        pStat.close();
    }
    
    private static void deleterb(Scanner input, Connection connection) throws SQLException {

        String rb_name;

        PreparedStatement pStat;

        System.out.println("Enter rb name to delete: ");
        rb_name = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("DELETE FROM runningback WHERE rb_name = ?");

        pStat.setString(1, rb_name);

        pStat.executeUpdate();
        pStat.close();
    }
    private static void deletewr(Scanner input, Connection connection) throws SQLException {

        String wr_name;

        PreparedStatement pStat;

        System.out.println("Enter wr name to delete: ");
        wr_name = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("DELETE FROM widereceiver WHERE wr_name = ?");

        pStat.setString(1, wr_name);

        pStat.executeUpdate();
        pStat.close();
    }
    private static void deletete(Scanner input, Connection connection) throws SQLException {

        String te_name;

        PreparedStatement pStat;

        System.out.println("Enter te name to delete: ");
        te_name = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("DELETE FROM tightend WHERE te_name = ?");

        pStat.setString(1, te_name);

        pStat.executeUpdate();
        pStat.close();
    }
    private static void deletelb(Scanner input, Connection connection) throws SQLException {

        String lb_name;

        PreparedStatement pStat;

        System.out.println("Enter lb name to delete: ");
        lb_name = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("DELETE FROM linebacker WHERE lb_name = ?");

        pStat.setString(1, lb_name);

        pStat.executeUpdate();
        pStat.close();
    }
    private static void deletedb(Scanner input, Connection connection) throws SQLException {

        String db_name;

        PreparedStatement pStat;

        System.out.println("Enter db name to delete: ");
        db_name = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("DELETE FROM defensiveback WHERE db_name = ?");

        pStat.setString(1, db_name);

        pStat.executeUpdate();
        pStat.close();
    }
    private static void deleteuser(Scanner input, Connection connection) throws SQLException {

        String user_name;

        PreparedStatement pStat;

        System.out.println("Enter username name to delete: ");
        user_name = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("DELETE FROM users WHERE user_name = ?");

        pStat.setString(1, user_name);

        pStat.executeUpdate();
        pStat.close();
    }
    private static void deletefantasyteam(Scanner input, Connection connection) throws SQLException {

        String team_name;

        PreparedStatement pStat;

        System.out.println("Enter team name to delete: ");
        team_name = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("DELETE FROM jointeam WHERE team_name = ?");

        pStat.setString(1, team_name);

        pStat.executeUpdate();
        pStat.close();
    }
    private static void addwr(Scanner input, Connection connection) throws SQLException {
        String wr_name;
        String wr_team; 
        String wr_age;
        String wr_position = "WR";
        String wr_gp;
        String wr_catches;
        String wr_recyds;
        String wr_rectd;
        String wr_fumbles;
        PreparedStatement pStat;

        System.out.println("Enter wr name: ");
        wr_name = input.nextLine();
        
        System.out.println("Enter wr Real life team: ");
        wr_team = input.nextLine();
        
        System.out.println("Enter wr age: ");
        wr_age = input.nextLine();
        
        System.out.println("Enter wr number of games played: ");
        wr_gp = input.nextLine();
        
        System.out.println("Enter wr catches: ");
        wr_catches = input.nextLine();
        
        System.out.println("Enter wr receiving yards: ");
        wr_recyds = input.nextLine();
        
        System.out.println("Enter wr recieving touchdowns: ");
        wr_rectd = input.nextLine();
        
        System.out.println("Enter wr fumbles: ");
        wr_fumbles = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("INSERT INTO widereceiver VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pStat.setString(1, wr_name);
        pStat.setString(2, wr_team);
        pStat.setString(3, wr_age);
        pStat.setString(4, wr_position);
        pStat.setString(5, wr_gp);
        pStat.setString(6, wr_catches);
        pStat.setString(7, wr_recyds);
        pStat.setString(8, wr_rectd);
        pStat.setString(9, wr_fumbles);
        pStat.executeUpdate();
        pStat.close();
    }
    private static void addte(Scanner input, Connection connection) throws SQLException {
        String te_name;
        String te_team; 
        String te_age;
        String te_position = "TE";
        String te_gp;
        String te_catches;
        String te_recyds;
        String te_rectd;
        String te_fumbles;
        PreparedStatement pStat;

        System.out.println("Enter te name: ");
        te_name = input.nextLine();
        
        System.out.println("Enter te Real life team: ");
        te_team = input.nextLine();
        
        System.out.println("Enter te age: ");
        te_age = input.nextLine();
        
        System.out.println("Enter te number of games played: ");
        te_gp = input.nextLine();
        
        System.out.println("Enter te catches: ");
        te_catches = input.nextLine();
        
        System.out.println("Enter te receiving yards: ");
        te_recyds = input.nextLine();
        
        System.out.println("Enter te recieved touchdowns: ");
        te_rectd = input.nextLine();
        
        System.out.println("Enter te fumbles: ");
        te_fumbles = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("INSERT INTO tightend VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pStat.setString(1, te_name);
        pStat.setString(2, te_team);
        pStat.setString(3, te_age);
        pStat.setString(4, te_position);
        pStat.setString(5, te_gp);
        pStat.setString(6, te_catches);
        pStat.setString(7, te_recyds);
        pStat.setString(8, te_rectd);
        pStat.setString(9, te_fumbles);
        pStat.executeUpdate();
        pStat.close();
    }
    private static void addlb(Scanner input, Connection connection) throws SQLException {
        String lb_name;
        String lb_team; 
        String lb_age;
        String lb_position = "LB";
        String lb_gp;
        String lb_intcaught;
        String lb_passdeflections;
        String lb_sacks;
        String lb_tackles;
        PreparedStatement pStat;

        System.out.println("Enter lb name: ");
        lb_name = input.nextLine();
        
        System.out.println("Enter lb Real life team: ");
        lb_team = input.nextLine();
        
        System.out.println("Enter lb age: ");
        lb_age = input.nextLine();
        
        System.out.println("Enter lb number of games played: ");
        lb_gp = input.nextLine();
        
        System.out.println("Enter lb interceptions caught: ");
        lb_intcaught = input.nextLine();
        
        System.out.println("Enter lb passes deflected: ");
        lb_passdeflections = input.nextLine();
        
        System.out.println("Enter lb sacks: ");
        lb_sacks = input.nextLine();
        
        System.out.println("Enter lb tackles: ");
        lb_tackles = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("INSERT INTO linebacker VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pStat.setString(1, lb_name);
        pStat.setString(2, lb_team);
        pStat.setString(3, lb_age);
        pStat.setString(4, lb_position);
        pStat.setString(5, lb_gp);
        pStat.setString(6, lb_intcaught);
        pStat.setString(7, lb_passdeflections);
        pStat.setString(8, lb_sacks);
        pStat.setString(9, lb_tackles);
        pStat.executeUpdate();
        pStat.close();
    }
    private static void adddb(Scanner input, Connection connection) throws SQLException {
        String db_name;
        String db_team; 
        String db_age;
        String db_position = "DB";
        String db_gp;
        String db_intcaught;
        String db_passdeflections;
        String db_sacks;
        String db_tackles;
        PreparedStatement pStat;

        System.out.println("Enter db name: ");
        db_name = input.nextLine();
        
        System.out.println("Enter db Real life team: ");
        db_team = input.nextLine();
        
        System.out.println("Enter db age: ");
        db_age = input.nextLine();
        
        System.out.println("Enter db number of games played: ");
        db_gp = input.nextLine();
        
        System.out.println("Enter db interceptions caught: ");
        db_intcaught = input.nextLine();
        
        System.out.println("Enter db passes deflected: ");
        db_passdeflections = input.nextLine();
        
        System.out.println("Enter db sacks: ");
        db_sacks = input.nextLine();
        
        System.out.println("Enter db tackles: ");
        db_tackles = input.nextLine();
        
       
        System.out.println();

        // Update data
        pStat = connection.prepareStatement("INSERT INTO defensiveback VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pStat.setString(1, db_name);
        pStat.setString(2, db_team);
        pStat.setString(3, db_age);
        pStat.setString(4, db_position);
        pStat.setString(5, db_gp);
        pStat.setString(6, db_intcaught);
        pStat.setString(7, db_passdeflections);
        pStat.setString(8, db_sacks);
        pStat.setString(9, db_tackles);
        pStat.executeUpdate();
        pStat.close();
    }
}