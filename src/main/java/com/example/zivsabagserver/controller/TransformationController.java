package com.example.zivsabagserver.controller;

import com.example.zivsabagserver.dto.RowDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TransformationController {

    @GetMapping("/")
    public String handleEmptyGetRequest() {
        return "Hello there";
    }

    @PostMapping("/api/transform")
    public List<RowDto> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {

        ArrayList<RowDto> response = new ArrayList();

        try {
            InputStream inputStream = file.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line = reader.readLine();

            while (line != null) {
                if (line.length() > 0) {
                    response.add(
                            RowDto.builder()
                                    .docType(line.substring(0, 1))
                                    .companyId(Integer.parseInt(line.substring(1, 10)))
                                    .date(new SimpleDateFormat("yyyyMMdd").parse(line.substring(10, 18)))
                                    .docId(Integer.parseInt(line.substring(18, 27)))
                                    .sign(line.substring(27, 28))
                                    .amount(Integer.parseInt(line.substring(29)))
                                    .build()
                    );
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return response;
    }
}
