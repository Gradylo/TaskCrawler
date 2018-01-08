package model;

import java.io.Serializable;

/**
 * 热歌榜
 * @author zhipeng
 * @time 2018-1-6
 * @name HotMusic
 * @info TODO
 */
@SuppressWarnings("serial")
public class HotMusic implements Serializable{
		
	private int 				id;
	
	private int 				RankNum;
	
	private String 				Song;
	
	private String 				url;
	
	private String				SongTime;
	
	private String				Singer;
	
	private String				addtime;
	
	private String 				uptime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRankNum() {
		return RankNum;
	}

	public void setRankNum(int rankNum) {
		RankNum = rankNum;
	}

	public String getSong() {
		return Song;
	}

	public void setSong(String song) {
		Song = song;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSongTime() {
		return SongTime;
	}

	public void setSongTime(String songTime) {
		SongTime = songTime;
	}

	public String getSinger() {
		return Singer;
	}

	public void setSinger(String singer) {
		Singer = singer;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	
}
