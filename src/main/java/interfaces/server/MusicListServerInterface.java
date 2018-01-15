package interfaces.server;

import model.HotMusic;
import model.paging.PagingTransmission;

import java.util.List;

public abstract interface MusicListServerInterface
{
        List<HotMusic> findHotMusicList();

        /**
         * 分页查询热歌榜
         * @param pagingTransmission
         * @return
         */
        List<HotMusic> queryHotMusic(PagingTransmission pagingTransmission);

}
