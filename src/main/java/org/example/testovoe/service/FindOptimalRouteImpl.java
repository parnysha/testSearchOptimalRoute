package org.example.testovoe.service;

import lombok.RequiredArgsConstructor;
import org.example.testovoe.converters.ConverterAny;
import org.example.testovoe.place.OptimalRoute;
import org.example.testovoe.place.PlaceInfo;
import org.springframework.stereotype.Service;

import com.groupdocs.parser.exceptions.System.IO.FileNotFoundException;
import java.util.*;

@RequiredArgsConstructor
@Service
public class FindOptimalRouteImpl implements FindOptimalRoute{
    private final ConverterAny converterAny;
    @Override
    public OptimalRoute find(String fileName) throws FileNotFoundException{
            List<String> words = converterAny.convert(fileName);
            List<PlaceInfo> placesInfo = structuringPlace(words);
            List<PlaceInfo> placesInfoSorted = placesInfo.stream().sorted(Comparator.comparing(PlaceInfo::importantOneHour).reversed()).toList();
            return createOptimalRoute(placesInfoSorted,2,8);
    }
    private List<PlaceInfo> structuringPlace(List<String> words){
        List<PlaceInfo> placesInfo = new ArrayList<>();
        for (int i = 0; i < words.size(); i+=3) {
            String name = words.get(i);
            double time = Double.parseDouble(words.get(i+1).substring(0, words.get(i+1).length()-1).replace(',','.'));
            int important = Integer.parseInt(words.get(i+2));
            placesInfo.add(new PlaceInfo(name, time, important));
        }
        return placesInfo;
    }
    private OptimalRoute createOptimalRoute(List<PlaceInfo> placesInfoSorted, int day, int sleep){
        List<Deque<PlaceInfo>> placeVisit = new ArrayList<>(day);
        double[] daysHours = new double[day];
        for (int i=0; i<daysHours.length;i++){
            daysHours[i] = 24-sleep;
            placeVisit.add(new ArrayDeque<>());
        }
        for (PlaceInfo placeInfo : placesInfoSorted) {
            for (int i=0; i<daysHours.length;i++){
                if (daysHours[i]>0&&daysHours[i]-placeInfo.getTime()>=0){
                    placeVisit.get(i).addLast(placeInfo);
                    daysHours[i]-=placeInfo.getTime();
                    break;
                }
            }
        }
        return new OptimalRoute(placeVisit);
    }
}
