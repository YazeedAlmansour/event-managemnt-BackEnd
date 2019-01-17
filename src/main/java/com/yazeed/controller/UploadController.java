//package com.yazeed.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.*;
//
//@RestController
//@RequestMapping("/api")
//public class UploadController {
//
//    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes ="multipart/form-data")
//    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//        File convertFile = new File("uploads");
//        convertFile.createNewFile();
//        FileOutputStream fout = new FileOutputStream(convertFile);
//        fout.write(file.getBytes());
//        fout.close();
//        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
//    }
//
////    private static String UPLOAD_DIR ;
////
////    @RequestMapping(value = "/upload",method = RequestMethod.POST)
////    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
////        try {
////            String fileName = file.getOriginalFilename();
////            String path = request.getServletContext().getRealPath("")+UPLOAD_DIR+File.separator + fileName;
////            saveFile(file.getInputStream(),path);
////            return fileName;
////        }catch (Exception e){
////            return e.getMessage();
////        }
////    }
////
////    private void saveFile(InputStream inputStream,String path){
////        try {
////            OutputStream outputStream = new FileOutputStream((new File(path)));
////            int read = 0;
////            byte[] bytes = new byte[1024];
////            while ((read=inputStream.read(bytes)) != -1){
////                outputStream.write(bytes,0,read);
////            }
////            outputStream.flush();
////            outputStream.close();
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////    }
//}
