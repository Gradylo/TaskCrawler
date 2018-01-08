package interfaces.dao;

import java.util.List;

import model.HotMusic;
import model.Music;

import org.springframework.stereotype.Repository;


@Repository("musicList")
public interface MusicListDao {
	
	/*查询列表*/
	List<Music>  findMusicList();
	
	/*查询热歌榜*/
	List<HotMusic> findHotMusicList();
	
	/*批量插入*/
	int saveHotMusicList(List<HotMusic> list); 
	
	/*批量更新*/
	int updateHotMusicList(List<HotMusic> list); 
	
	/*删除音乐*/
	int deleteHotMusic(int[] id);
	
	
	
	
}
