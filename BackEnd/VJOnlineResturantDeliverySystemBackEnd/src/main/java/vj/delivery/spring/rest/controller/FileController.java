package vj.delivery.spring.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/uploadFile")
public class FileController {

    @PostMapping
    public List<String> saveFile(@RequestParam("file") List<MultipartFile> multipartFiles) {
        File file1 = new File("I:/3 Semster-final/VJ-Online-Restaurant-Delivery-System/src/assets/ItemImageUpload/" + multipartFiles.get(0).getOriginalFilename());
        File file2 = new File("I:/3 Semster-final/Admin/Vj-DeliverySystem-Admin/src/assets/ItemImageUpload/" + multipartFiles.get(1).getOriginalFilename());
        List<String> urls = new ArrayList<>();
        try {
            multipartFiles.get(0).transferTo(file1);
            multipartFiles.get(1).transferTo(file2);
            file1.createNewFile();
            file2.createNewFile();
            urls.add("assets/ItemImageUpload/" + multipartFiles.get(0).getOriginalFilename());
            return urls;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{gmail}")
//    private List<String> findByEmailAddress(@PathVariable String gmail){
//        return service.findByEmailAddress(gmail);
//    }
//
//
//

}
