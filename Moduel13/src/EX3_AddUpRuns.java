import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class EX3_AddUpRuns {

	public static void main(String[] args) {
		int sum=0;
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to("http://www.espncricinfo.com/england-v-new-zealand-2015/engine/match/743953.html");
			List<WebElement> list=driver.findElements(By.xpath("//div[@class='wrap batsmen']"));
				for(int i=0;i<list.size();i++){
				List<WebElement> runs= 	list.get(i).findElements(By.cssSelector("div[class='cell runs']"));
					//System.out.println(list.get(i).getText());
				//System.out.println(runs.size());
			//	System.out.println(runs.get (0).getText());
					/*for(int j=0;j<runs.size();j++){
					//System.out.println(runs.get(j).getText());
						String runsAllPlayers=runs.get(j).getText();
						System.out.println(runsAllPlayers);
						
						*/
				String str=runs.get(0).getText();
				
							int r=0;
							try{
								if(str==""){
									break;
								}else{
							r = Integer.parseInt(str);
							sum=sum+r;}
							}catch(Exception e){
							System.out.println(e.getMessage());
							}
						//}*/
						
	}
				
				String total;
				total=driver.findElement(By.cssSelector("#gp-inning-01 div.scorecard-section.batsmen div.wrap.total div:nth-child(2)")).getText();
				String extras=driver.findElement(By.cssSelector("#gp-inning-01 div.scorecard-section.batsmen div.wrap.extras div:nth-child(2)")).getText();
			String str1=extras.substring(0, 2);
			str1=str1.replace(" ","");
				System.out.println("Sum of all players runs: "+sum);
				int extraRuns=Integer.parseInt(str1);
					total=total.substring(0, 3);
					int totalRuns=Integer.parseInt(total);
					if(sum+extraRuns==totalRuns){
						System.out.println("Sum of players runs : "+sum + " and extras : "+extraRuns+" matches the total : "+totalRuns);
					}
					//System.out.println(total);
					driver.quit();
}
}