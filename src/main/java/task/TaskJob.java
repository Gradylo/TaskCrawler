package task;

import interfaces.dao.MusicListDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import model.HotMusic;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import crawler.Phantomjs;

@Component
public class TaskJob {

	@Resource(name = "musicList")
	private MusicListDao MusicList;

	@Scheduled(cron = "0/3 * * * * ?")
	public void aTask() {
		List<HotMusic> list= new Phantomjs().crawlerHtml("http://music.163.com/#/discover/toplist?id=3778678");
		List<HotMusic> updateHotMusicList=MusicList.findHotMusicList();
		for (int i=0;i<updateHotMusicList.size();i++) {
			int id=updateHotMusicList.get(i).getId();
			list.get(i).setId(id);
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date()));
		int num= MusicList.updateHotMusicList(list);
		System.out.println(num);
		System.out.println(sdf.format(new Date()));
		System.out.println("----------------end-------------------------");
		
	}


}
