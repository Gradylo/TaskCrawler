package interfaces.dao;

import model.HotMusic;
import model.Music;
import model.paging.PagingTransmission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 音乐列表
 * @author zhipeng
 * @Date: Created in  2018-01-15 
 * @name MusicListDao.java
 * @info TODO
 */
@Repository("musicListDao")
public abstract interface MusicListDao {
    List<Music> findMusicList();

    List<HotMusic> findHotMusicList();

    int saveHotMusicList(List<HotMusic> paramList);

    int updateHotMusicList(List<HotMusic> paramList);

    int deleteHotMusicList(List<Integer> paramList);

    int deleteHotMusic();

    /**
     * 分页查询热歌榜
     * @param pagingTransmission
     * @return
     */
    List<HotMusic> queryHotMusic(@Param("pagingTransmission") PagingTransmission pagingTransmission);

}

