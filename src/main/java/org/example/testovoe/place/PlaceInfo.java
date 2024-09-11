package org.example.testovoe.place;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlaceInfo {
    private String name;
    private Double time;
    private Integer important;

    public Double importantOneHour(){
        return getImportant()/getTime();
    }
}
