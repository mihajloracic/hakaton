package mihajlo.rac.demo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import mihajlo.rac.demo.model.Monument;
import mihajlo.rac.demo.model.User;
import mihajlo.rac.demo.service.MonumentService;
import mihajlo.rac.demo.service.StorageService;
import mihajlo.rac.demo.service.UserService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


@Controller
public class UploadController {

    @Autowired
    StorageService storageService;


    @Autowired
    MonumentService monumentService;

    @Autowired
    UserService userService;

    List<String> files = new ArrayList<String>();

    @GetMapping("/pera")
    public String listUploadedFiles(Model model) {
        return "uploadForm";
    }

    @PostMapping("/uploadMonument")
    @ResponseBody
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("author") String author, @RequestParam("userId") Long userId) {
        Monument monument = new Monument();
        try {


            String fileName = storageService.store(file);

            files.add(fileName);
            monument.setImageUrl(fileName);
            monument.setName(name);
            User user = this.userService.getUserById(userId);
            System.out.println(user);
            monument.setUser(user);
            monument.setDescription(description);
            monument.setAuthor(author);
            monumentService.saveMonument(monument);
            //TODO dodati ostale stvari koje treba da se dodaju za monument
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(monument.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/gellallfiles")
    public String getListFiles(Model model) {
        model.addAttribute("files",
                files.stream()
                        .map(fileName -> MvcUriComponentsBuilder
                                .fromMethodName(UploadController.class, "getFile", fileName).build().toString())
                        .collect(Collectors.toList()));
        model.addAttribute("totalFiles", "TotalFiles: " + files.size());
        return "listFiles";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("/files")
    @ResponseBody
    public ResponseEntity<?> getAllFiles() {
        List<Monument> monuments = this.monumentService.getMonuments();
        return new ResponseEntity(monuments, HttpStatus.OK);
    }
}