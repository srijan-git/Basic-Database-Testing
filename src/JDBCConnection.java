import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String host = "localhost";
		String port = "3306";
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/QA_DB_TEST", "root",
				"Ss12345#");

		Statement statement = conn.createStatement();

		ResultSet sResultSet = statement.executeQuery("SELECT * FROM CREDENTAILS WHERE SCNERAIO='rewardscard'");

		while (sResultSet.next()) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/chromedriver");

			WebDriver driver = new ChromeDriver();

			driver.get("https://login.salesforce.com/");

			driver.findElement(By.xpath("//*[@id='username']")).sendKeys(sResultSet.getString("username"));

			driver.findElement(By.xpath("//*[@id='password']")).sendKeys(sResultSet.getString("password"));
		}

	}

}
