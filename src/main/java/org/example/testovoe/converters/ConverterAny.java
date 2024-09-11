package org.example.testovoe.converters;

import com.groupdocs.parser.exceptions.System.IO.FileNotFoundException;
import java.util.List;

public interface ConverterAny<T> {
    List<T> convert(String fileName) throws FileNotFoundException;
}
