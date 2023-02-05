package web.reggie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import web.reggie.common.R;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {
    @Value("${reggie.path}")
    private String path;

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String imgName = file.getOriginalFilename();
            File file1 = new File(path + imgName);
            if (file1.exists()) {
                file1.mkdir();
            }
            file.transferTo(file1);
            return R.success(imgName);
        } else {
            return R.error("上传失败");
        }

    }

    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(path + name));
        ServletOutputStream outputStream = response.getOutputStream();
        response.setContentType("image/jpeg");
        byte[] arr = new byte[1024];
        int length;
        while ((length = fileInputStream.read(arr)) != -1) {
            outputStream.write(arr, 0, length);
            outputStream.flush();
        }
    }
}
