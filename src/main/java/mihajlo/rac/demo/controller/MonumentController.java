package mihajlo.rac.demo.controller;


import mihajlo.rac.demo.model.Monument;
import mihajlo.rac.demo.service.MonumentService;
import mihajlo.rac.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/monument")
public class MonumentController {

    @Autowired
    MonumentService monumentService;

    @GetMapping
    @ResponseBody
    public List<Monument> getMonuments(){
        return monumentService.getMonuments();
    }


}
