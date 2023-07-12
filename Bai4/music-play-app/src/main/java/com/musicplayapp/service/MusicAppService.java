package com.musicplayapp.service;

import com.musicplayapp.model.Sing;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class MusicAppService {
    static List<Sing> sings=new ArrayList<>();
    static {
        sings.add(new Sing("Vì em chưa bao giờ khóc","Hà Nhi,Xuân Tài","Bolero","music.mp4"));
    }

    public List<Sing> getAll(){
        return sings;
    }

    public boolean checkFile(MultipartFile file){
        String fileName=file.getOriginalFilename();
        String fileExtension=fileName.substring(fileName.lastIndexOf(".")+1);
        return fileExtension.equalsIgnoreCase("mp3") ||
                fileExtension.equalsIgnoreCase("wav")||
                fileExtension.equalsIgnoreCase("ogg")||
                fileExtension.equalsIgnoreCase("mp4");
    }

    public void saveSing(Sing sing,MultipartFile fileSing){
        String fileName=fileSing.getOriginalFilename();
        try{
            fileSing.transferTo(new File("C:/Users/trung/Codegym/Md4/Bai4/music-play-app/src/main/webapp/WEB-INF/file/" +fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        sing.setFile(fileName);
        sings.add(sing);
    }
}
