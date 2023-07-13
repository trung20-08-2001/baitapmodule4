package com.appplaymusicsimp.service;

import com.appplaymusicsimp.dao.SongDAO;
import com.appplaymusicsimp.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MusicAppService {
    @Autowired
    SongDAO songDAO;
    public boolean checkFile(MultipartFile file){
        String fileName=file.getOriginalFilename();
        String fileExtension=fileName.substring(fileName.lastIndexOf(".")+1);
        return fileExtension.equalsIgnoreCase("mp3") ||
                fileExtension.equalsIgnoreCase("wav")||
                fileExtension.equalsIgnoreCase("ogg")||
                fileExtension.equalsIgnoreCase("mp4");
    }

    public void save(Song song, MultipartFile music){
        String name=music.getOriginalFilename();
        try {
            music.transferTo(new File("C:\\Users\\trung\\Codegym\\Md4\\Bai5\\app-play-music-simp\\src\\main\\webapp\\WEB-INF\\music\\"+name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        song.setNameFile(name);
        songDAO.save(song);
    }

    public void edit(Song song){
        songDAO.edit(song);
    }


    public void delete(int id){
        songDAO.delete(id);
    }

    public Song findById(int id){
        return songDAO.findById(id);
    }

    public List<Song> getAll(){
        return songDAO.getAll();
    }
}
