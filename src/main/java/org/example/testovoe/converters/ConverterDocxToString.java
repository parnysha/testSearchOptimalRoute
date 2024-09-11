package org.example.testovoe.converters;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.TextReader;
import com.groupdocs.parser.exceptions.System.IO.FileNotFoundException;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterDocxToString implements ConverterAny {

    @Override
    public List<String> convert(String fileName) throws FileNotFoundException {
        Parser parser = new Parser(fileName + ".docx");
        try (TextReader reader = parser.getText()) {
            String[] line = reader.readToEnd().split("\u0007");
            List<String> words = new ArrayList<>();
            for (int i = 4; i < line.length; i++) {
                if ("".equals(line[i])) {
                    continue;
                }
                if (line[i].charAt(0) == '\f') {
                    break;
                }
                words.add(line[i]);
            }
            return words;
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }
}
