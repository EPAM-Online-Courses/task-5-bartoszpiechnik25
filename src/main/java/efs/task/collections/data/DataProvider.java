package efs.task.collections.data;

import efs.task.collections.entity.Hero;
import efs.task.collections.entity.Town;

import java.util.*;
import java.util.stream.Collectors;

public class DataProvider {

    public static final String DATA_SEPARATOR = ",";

    // TODO Utwórz listę miast na podstawie tablicy Data.baseTownsArray.
    //  Tablica zawiera String zawierający nazwę miasta oraz dwie klasy bohatera związane z tym miastem oddzielone przecinkami.
    //  Korzystając z funkcji split() oraz stałej DATA_SEPARATOR utwórz listę obiektów klasy efs.task.collections.entities.Town.
    //  Funkcja zwraca listę obiektów typu Town ze wszystkimi dziewięcioma podstawowymi miastami.
    public List<Town> getTownsList() {
        List<Town> result = new ArrayList<>();

        for (String record: Data.baseTownsArray) {
            String[] splited = record.split(DATA_SEPARATOR);
            List<String> heroes = Arrays.stream(Arrays.copyOfRange(splited, 1, splited.length))
                    .map(String::trim)
                    .collect(Collectors.toList());
            result.add(new Town(splited[0], heroes));
       }
        return result;
    }

    //TODO Analogicznie do getTownsList utwórz listę miast na podstawie tablicy Data.DLCTownsArray
    public List<Town> getDLCTownsList() {
        List<Town> result = new ArrayList<>();

        for (String record: Data.dlcTownsArray) {
            String[] splited = record.split(DATA_SEPARATOR);
            List<String> heroes = Arrays.stream(Arrays.copyOfRange(splited, 1, splited.length))
                            .map(String::trim).collect(Collectors.toList());
            result.add(new Town(splited[0], heroes));
        }
        return result;
    }

    //TODO Na podstawie tablicy Data.baseCharactersArray utworzyć listę bohaterów dostępnych w grze.
    // Tablica Data.baseCharactersArray zawiera oddzielone przecinkiem imie bohatera, klasę bohatera.
    // Korzystając z funkcji split() oraz DATA_SEPARATOR utwórz listę unikalnych obiektów efs.task.collections.entities.Hero.
    // UWAGA w Data.baseCharactersArray niektórzy bohaterowie powtarzają się, do porównania bohaterów używamy zarówno imie jak i jego klasę;
    public Set<Hero> getHeroesSet() {

        Set<Hero> heroes = new HashSet<>();

        for (String record: Data.baseCharactersArray) {
            String[] splited = record.split(DATA_SEPARATOR);
            heroes.add(new Hero(splited[0].trim(), splited[1].trim()));
        }

        return heroes;
    }

    //TODO Analogicznie do getHeroesSet utwórz listę bohaterów na podstawie tablicy Data.DLCCharactersArray
    public Set<Hero> getDLCHeroesSet() {
        Set<Hero> heroes = new HashSet<>();

        for (String record: Data.dlcCharactersArray) {
            String[] splited = record.split(DATA_SEPARATOR);
            heroes.add(new Hero(splited[0].trim(), splited[1].trim()));
        }

        return heroes;
    }
}
