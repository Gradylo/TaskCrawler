package controller;


import interfaces.server.MusicListServerInterface;
import model.HotMusic;
import model.paging.PagingTransmission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 热歌榜
 * @author zhipeng
 * @Date: Created in  2018-01-15
 * @name HotMusicController.java
 * @info TODO
 */
@Controller
@RequestMapping({"/hotMusicController"})
public class HotMusicController {
    @Resource(name = "musicListServer")
    private MusicListServerInterface MusicListServer;

    @RequestMapping(value = {"/findHotMusicList"}, method = RequestMethod.GET)
    @ResponseBody
    public List<HotMusic> findHotMusicList() {
        List<HotMusic> list = MusicListServer.findHotMusicList();
        return list;
    }

    /**
     * 分页查询热歌榜
     * @param pagingTransmission
     * @return
     */
    @RequestMapping(value = {"/queryHotMusic"}, method = RequestMethod.GET)
    @ResponseBody
    public List<HotMusic> queryHotMusic(PagingTransmission pagingTransmission) {
        List<HotMusic> list = MusicListServer.queryHotMusic(pagingTransmission);
        return list;
    }



}
