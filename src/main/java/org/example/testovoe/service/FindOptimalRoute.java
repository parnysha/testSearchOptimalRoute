package org.example.testovoe.service;

import org.example.testovoe.place.OptimalRoute;

import com.groupdocs.parser.exceptions.System.IO.FileNotFoundException;

public interface FindOptimalRoute {
    OptimalRoute find(String fileName) throws FileNotFoundException;
}
