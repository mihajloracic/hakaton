package mihajlo.rac.demo.service;

import mihajlo.rac.demo.model.Monument;
import mihajlo.rac.demo.repository.MonumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonumentService {

    @Autowired
    MonumentRepository monumentRepository;

    public Monument saveMonument(Monument monument){
        monumentRepository.save(monument);
        return monument;
    }

    public List<Monument> getMonuments(){
        return  monumentRepository.findAll();
    }
}
