package com.jit.emsystemapi.controller;

import com.jit.emsystemapi.service.TargetPointService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.targetpoint.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

@CrossOrigin //解决跨域
@RestController
@RequestMapping
public class TargetPointController {
    @Autowired
    private TargetPointService targetPointService;

    @PostMapping("addTargetPoint")
    public Result addTargetPoint(@RequestBody AddTPParam addTPParam) {
        return targetPointService.addTargetPoint(addTPParam);
    }

    @PostMapping("editTargetPoint")
    public Result editTargetPoint(@RequestBody EditTPParam editTPParam) {
        return targetPointService.editTargetPoint(editTPParam);
    }

    @PostMapping("deleteTargetPoint")
    public Result deleteTargetPoint(@RequestBody DeleteTPParam deleteTPParam) {
        return targetPointService.deleteTargetPoint(deleteTPParam);
    }

    @PostMapping("getAlltarget")
    public Result getAllTarget(@RequestBody GetAllTP getAllTP) {
        return targetPointService.getAllTarget(getAllTP);
    }

    @PostMapping("getCourseTargetPoint")
    public Result getCourseTargetPoint(@RequestBody GetCourseTpParam getCourseTpParam) {
        return targetPointService.getCourseTargetPoint(getCourseTpParam);
    }


    @GetMapping("getDemo")
    public ResponseEntity<FileSystemResource> getFile() throws FileNotFoundException {
        File file = new File("emsystem-api/target/classes/static/demo.xlsx");
        if (file.exists()) {
            return export(file);
        }
        System.out.println(file);
        return null;
    }

    public ResponseEntity<FileSystemResource> export(File file) {
        if (file == null) {
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=" + file.getName());
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Last-Modified", new Date().toString());
        headers.add("ETag", String.valueOf(System.currentTimeMillis()));
        return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/octet-stream")).body(new FileSystemResource(file));
    }

}
