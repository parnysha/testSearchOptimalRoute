package org.example.testovoe.controller;

import lombok.RequiredArgsConstructor;
import org.example.testovoe.place.OptimalRoute;
import org.example.testovoe.service.FindOptimalRoute;
import org.springframework.web.bind.annotation.*;

import com.groupdocs.parser.exceptions.System.IO.FileNotFoundException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FileParseController {
    private final FindOptimalRoute findOptimalRoute;

    @GetMapping("/parse/{fileName}")
    public OptimalRoute findRoute(@PathVariable String fileName) throws FileNotFoundException{
        return findOptimalRoute.find(fileName);
    }
}
