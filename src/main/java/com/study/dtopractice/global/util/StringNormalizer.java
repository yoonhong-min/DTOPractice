package com.study.dtopractice.global.util;


import java.text.Normalizer;
import java.util.Objects;

public final class StringNormalizer {
    public static String normalize(String str) {
        if(str == null){
            return null;
        }
        String normalized = Normalizer.normalize(str, Normalizer.Form.NFKC);
        normalized = normalized.replaceAll("\\s+", "");
        normalized = normalized.replaceAll("[^가-힣a-zA-Z0-9]", "");
        return normalized.toUpperCase();
    }

    public static boolean equalsNormalized(String a, String b) {
        return Objects.equals(normalize(a), normalize(b));
    }
}
