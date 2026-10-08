package pl.kurs.java;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;

public class SumThread implements Callable<Integer> {

    private final List<Integer> list;

    public SumThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
