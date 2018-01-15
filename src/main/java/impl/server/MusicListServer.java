package impl.server;

import interfaces.dao.MusicListDao;
import interfaces.server.MusicListServerInterface;
import model.HotMusic;
import model.paging.PagingTransmission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 音乐列表server
 * @author zhipeng
 * @Date: Created in  2018-01-15 
 * @name MusicListServer.java
 * @info TODO
 */
@Service("musicListServer")
public class MusicListServer
        implements MusicListServerInterface {
    @Resource(name = "musicListDao")
    private MusicListDao MusicList;

    public List<HotMusic> findHotMusicList() {
        return MusicList.findHotMusicList();
    }

    /**
     * 分页查询热歌榜
     * @param pagingTransmission
     * @return
     */
    public List<HotMusic> queryHotMusic(PagingTransmission pagingTransmission) {
        if (pagingTransmission!=null){
            return MusicList.queryHotMusic(pagingTransmission);
        }
        return null;
    }


}
