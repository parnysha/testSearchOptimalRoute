package org.example.testovoe.place;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Deque;
import java.util.List;

@AllArgsConstructor
@Getter
public class OptimalRoute {
    private List<Deque<PlaceInfo>> placeVisit;
}
