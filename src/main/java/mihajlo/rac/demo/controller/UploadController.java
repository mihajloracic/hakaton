package mihajlo.rac.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mihajlo.rac.demo.model.Monument;
import mihajlo.rac.demo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    List<String> files = new ArrayList<String>();

    @GetMapping("/")
    public String listUploadedFiles(Model model) {
        return "uploadForm";
    }

    @PostMapping("/uploadMonument")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("name")String name,@RequestParam("description")String description) {
        try {
            storageService.store(file);
            files.add(file.getOriginalFilename());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "uploadForm";
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
}