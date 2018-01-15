package crawler;

import com.google.common.collect.Lists;
import model.HotMusic;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import toolUtils.dateUtils.DateUtils;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 爬虫类
 * @author zhipeng
 * @Date: Created in 14:27 2018-01-15
 * @name Phantomjs.java
 * @info TODO
 */
public class Phantomjs {
    private PhantomJSDriver driver;

    public Phantomjs() {
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
        dcaps.setCapability("phantomjs.binary.path", "D:/Java/phantomjs/phantomjs/bin/phantomjs.exe");
        this.driver = new PhantomJSDriver(dcaps);
        // 设置隐性等待（作用于全局）
        this.driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
    }


    public List<HotMusic> crawlerHtml(String url) {
        // 打开页面
        this.driver.get(url);
        try {
            // 查找元素
            //输出html内容
            //WebElement webElement = driver.findElement(By.xpath("/html"));
            //System.out.println(webElement.getAttribute("outerHTML"));
            this.driver.switchTo().frame("g_iframe");
            WebElement element = this.driver.findElementById("song-list-pre-cache").findElement(By.tagName("tbody"));
            List<WebElement> element2 = element.findElements(By.tagName("tr"));
            List<HotMusic> list = Lists.newArrayList();
            for (Object localObject1 = element2.iterator(); ((Iterator) localObject1).hasNext(); ) {
                WebElement webElement = (WebElement) ((Iterator) localObject1).next();
                String id = (webElement.findElements(By.tagName("td")).get(1)).findElement(By.className("tt")).findElement(By.tagName("span")).getAttribute("data-res-id");
                String num = webElement.findElement(By.tagName("span")).getText();
                String song = webElement.findElement(By.tagName("b")).getAttribute("title");
                //替换&nbsp;
                song = song.replace(Jsoup.parse("&nbsp;").text(), " ");
                String time = webElement.findElement(By.className("s-fc3")).getText();
                String singer = webElement.findElement(By.className("text")).getAttribute("title");
                HotMusic hotMusic = new HotMusic();
                hotMusic.setRankNum(Integer.parseInt(num));
                hotMusic.setSong(song);
                hotMusic.setSinger(singer);
                hotMusic.setSongTime(time);
                hotMusic.setAddtime(DateUtils.format(new Date()));
                hotMusic.setUptime(DateUtils.format(new Date()));
                hotMusic.setUrl("http://music.163.com/song/media/outer/url?id=" + id + ".mp3");
                hotMusic.setSongId(id);
                list.add(hotMusic);
                System.out.println(num + " " + song + " " + time + " " + singer);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭并退出浏览器
            this.driver.close();
            this.driver.quit();
        }
        return null;
    }
}

