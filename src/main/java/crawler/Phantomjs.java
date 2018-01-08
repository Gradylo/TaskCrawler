package crawler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import model.HotMusic;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.Lists;

public class Phantomjs {

 public List<HotMusic> crawlerHtml(String url){
	 Long start= new Date().getTime();
	 		// 设置必要参数
			DesiredCapabilities dcaps = new DesiredCapabilities();
			// ssl证书支持
			dcaps.setCapability("acceptSslCerts", true);
			// 截屏支持
			dcaps.setCapability("takesScreenshot", true);
			// css搜索支持
			dcaps.setCapability("cssSelectorsEnabled", true);
			// js支持
			dcaps.setJavascriptEnabled(true);
			// 驱动支持（第二参数表明的是你的phantomjs引擎所在的路径）
			//linux:/home/lzp/java/phantomjs-2.1.1-linux-x86_64/bin/phantomjs
			dcaps.setCapability(
					PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					"D:/Java/phantomjs/phantomjs/bin/phantomjs.exe");
			// 创建无界面浏览器对象
			PhantomJSDriver driver = new PhantomJSDriver(dcaps);
			// 设置隐性等待（作用于全局）
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			// 打开页面
			driver.get(url);
			try {
				// 查找元素
				//输出html内容
//				WebElement webElement = driver.findElement(By.xpath("/html"));
//			    System.out.println(webElement.getAttribute("outerHTML"));
		        driver.switchTo().frame("g_iframe");
		        WebElement element=driver.findElementById("song-list-pre-cache").findElement(By.tagName("tbody"));
		        List<WebElement> element2=element.findElements(By.tagName("tr"));
		        List<HotMusic> list=Lists.newArrayList();
		        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        for (WebElement webElement : element2) {
		        	String num=webElement.findElement(By.tagName("span")).getText();
		        	String song=webElement.findElement(By.tagName("b")).getAttribute("title");
		        	//替换&nbsp;
		        	song= new String(song.getBytes(),"utf-8").replace(Jsoup.parse("&nbsp;").text(), " ");;
		        	String time=webElement.findElement(By.className("s-fc3")).getText();
		        	String singer=webElement.findElement(By.className("text")).getAttribute("title");
		        	HotMusic hotMusic=new HotMusic();
		        	hotMusic.setRankNum(Integer.parseInt(num));
		        	hotMusic.setSong(song);
		        	hotMusic.setSinger(singer);
		        	hotMusic.setSongTime(time);
		        	hotMusic.setUptime(sdf.format(new Date()));
		        	list.add(hotMusic);
		        	System.out.println(num+" "+song+" "+time+" "+singer);
				}
		        return list;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 关闭并退出浏览器
				driver.close();
				driver.quit();
			}
			 Long end= new Date().getTime();
			 System.out.println("耗时："+(end-start));
			 return null;
 }
}
